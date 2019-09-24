package shoponline.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import shoponline.dto.ProductDTO;
import shoponline.entity.Category;
import shoponline.entity.Color;
import shoponline.entity.Product;
import shoponline.entity.Size;
import shoponline.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/api-product-manage")
public class ApiProductManage {

	@Autowired
    ServletContext context;

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value = "/upload-image", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(MultipartHttpServletRequest request){
        String path_save_image = context.getRealPath("/resources/image/products/");

        Iterator<String> listNames = request.getFileNames();
        MultipartFile mpf = request.getFile(listNames.next());
        File imageFile = new File(path_save_image + mpf.getOriginalFilename());
        try {
            mpf.transferTo(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }
	
	@PostMapping("/update-product")
	@ResponseBody
	public void getJson(@RequestParam String formInfor) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(formInfor);
			System.out.println(node);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/add-product")
	@ResponseBody
	public void addProduct(@RequestParam String formInfor) {
		ObjectMapper objectMapper = new ObjectMapper();

        Product product = new Product();

        Set<shoponline.entity.ProductDetail> productDetailSet = new HashSet<shoponline.entity.ProductDetail>();

		try {
			JsonNode jsonObjectProduct = objectMapper.readTree(formInfor);

            JsonNode jsonChiTiet = jsonObjectProduct.get("productDetail");
            for (JsonNode objectChiTiet: jsonChiTiet
                 ) {
            	shoponline.entity.ProductDetail productDetail = new shoponline.entity.ProductDetail();

                Color color = new Color();
                color.setId(objectChiTiet.get("mauSanPham").asLong());

                Size size = new Size();
                size.setId(objectChiTiet.get("sizeSanPham").asLong());

                productDetail.setColor(color);
                productDetail.setSize(size);
                productDetail.setSoLuong(objectChiTiet.get("soLuong").asInt());

                productDetailSet.add(productDetail);
            }
            product.setProductsDetail(productDetailSet);

            Category category =  new Category();
            category.setCategory_id(jsonObjectProduct.get("danhmucsanpham").asLong());

            product.setCategory(category);
            product.setProductName(jsonObjectProduct.get("tenSanPham").asText());
            product.setPrice(jsonObjectProduct.get("giaTien").asText());
            product.setImage(jsonObjectProduct.get("nameImage").asText());
            product.setPopular((long) 0);
            productServiceImpl.addProduct(product);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/delete-product")
	public void deleteProductById(@RequestParam Long idProduct) {
		productServiceImpl.deleteProductById(idProduct);
	}
	//, produces = MediaType.APPLICATION_JSON_VALUE: khong can dung dong nay, chi can @ResponseBody thi spring tu hieu tra ve du lieu json
	@RequestMapping(value = "/edit-product",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDTO getInforProduct(@RequestParam Long idProduct) {
		Product product = productServiceImpl.getProductbyId(idProduct);

        ProductDTO productDTO = new ProductDTO();
       
        Set<shoponline.entity.ProductDetail> productDetailSet = new HashSet<>();
        for (shoponline.entity.ProductDetail pro:product.getProductsDetail()
             ) {
        	shoponline.entity.ProductDetail pd = new shoponline.entity.ProductDetail();
            pd.setId(pro.getId());

            Product pr = new Product();
            pr.setId(pro.getProduct().getId());

            pd.setProduct(pr);

            Color color = new Color();
            color.setId(pro.getColor().getId());

            pd.setColor(color);

            Size size = new Size();
            size.setId(pro.getSize().getId());

            pd.setSize(size);

            pd.setSoLuong(pro.getSoLuong());
            productDetailSet.add(pd);
        }

        Category category = new Category();
        category.setCategory_id(product.getCategory().getCategory_id());

        productDTO.setCategory(category);
        productDTO.setId(product.getId());
        productDTO.setImage(product.getImage());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductsDetail(productDetailSet);
        return productDTO;
	} 
	
	@PostMapping("/capNhapSanPham")
    @ResponseBody
    public void capNhapSanPham(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();

        Product product = new Product();

        Set<shoponline.entity.ProductDetail> productDetailSet = new HashSet<shoponline.entity.ProductDetail>();

        try {
            JsonNode jsonObjectProduct = objectMapper.readTree(dataJson);

            JsonNode jsonChiTiet = jsonObjectProduct.get("chiTietSanPham");
            for (JsonNode objectChiTiet: jsonChiTiet
            ) {
            	shoponline.entity.ProductDetail productDetail = new shoponline.entity.ProductDetail();

                Color color = new Color();
                color.setId(objectChiTiet.get("mauSanPham").asLong());

                Size size = new Size();
                size.setId(objectChiTiet.get("sizeSanPham").asLong());

                productDetail.setColor(color);
                productDetail.setSize(size);
                productDetail.setSoLuong(objectChiTiet.get("soLuong").asInt());

                productDetailSet.add(productDetail);
            }
            product.setProductsDetail(productDetailSet);
            product.setId(jsonObjectProduct.get("idProduct").asLong());
            Category category =  new Category();
            category.setCategory_id(jsonObjectProduct.get("danhmucsanpham").asLong());

            product.setCategory(category);
            product.setProductName(jsonObjectProduct.get("tenSanPham").asText());
            product.setPrice(jsonObjectProduct.get("giaTien").asText());
          //  System.out.print(product.getId());
            productServiceImpl.updateProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
