package shoponline.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import shoponline.dto.GioHangDTO;
import shoponline.dto.ProductDTO;
import shoponline.entity.Category;
import shoponline.entity.Color;
import shoponline.entity.Product;
import shoponline.entity.ProductDetail;
import shoponline.entity.Size;
import shoponline.service.impl.CategoryServiceImpl;
import shoponline.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/")
@SessionAttributes({"gioHang"})
public class HomeController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/")
	public ModelAndView pageAdmin(HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("trang-chu-san-pham");
		int soLuongSanPham = productServiceImpl.getTongSoLuongSanPham();
		Pageable pageable = new PageRequest(0,4);
		Page<Product> listProduct =  productServiceImpl.getTrangSanPham(pageable);
		List<Product> listProduct1 = new ArrayList<Product>();
		for (Product product : listProduct) {
			listProduct1.add(product);
		}
		if(null != httpSession.getAttribute("gioHang")) {
			List<GioHangDTO> listGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			mav.addObject("soLuongSanPham", listGioHang.size());
		}
		mav.addObject("listProduct1", listProduct1);
		mav.addObject("tongSoLuongSanPham",soLuongSanPham );
		return mav;
	}
	
	@RequestMapping(value="/loadmore",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductDTO> loadmoreProduct(@RequestParam int count) {
		List<Product> listPro = new ArrayList<Product>();
		int pageIndex = (count/4);
		Pageable pageable = new PageRequest(pageIndex, 4);
		Page<Product> listProduct = productServiceImpl.getTrangSanPham(pageable);	
		for (Product product : listProduct) {
				listPro.add(product);
		}
		List<ProductDTO> listProductDTo = new ArrayList<ProductDTO>();
		
		for (Product product : listPro) {
			
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setImage(product.getImage());
			productDTO.setPopular(product.getPopular());
			productDTO.setPrice(product.getPrice());
			productDTO.setProductName(product.getProductName());
			
			Category category = new Category();
			category.setCategory_id(product.getCategory().getCategory_id());
			
			productDTO.setCategory(category);
			
			Set<ProductDetail> proDT= new HashSet<ProductDetail>();
			
			for (ProductDetail pro : product.getProductsDetail()) {
				ProductDetail p = new ProductDetail();
				p.setId(pro.getId());

	            Product pr = new Product();
	            pr.setId(pro.getProduct().getId());

	            p.setProduct(pr);

	            Color color = new Color();
	            color.setId(pro.getColor().getId());

	            p.setColor(color);

	            Size size = new Size();
	            size.setId(pro.getSize().getId());

	            p.setSize(size);

	            p.setSoLuong(pro.getSoLuong());
	            proDT.add(p);
			}
			productDTO.setProductsDetail(proDT);
			listProductDTo.add(productDTO);
		}	
		
		return listProductDTo;
	}
	
	
	@GetMapping("/search")
	public ModelAndView getListProductSearch(@RequestParam String productName){
		ModelAndView mav = new ModelAndView("trang-chu-san-pham");
		List<Product> listProductSearch = productServiceImpl.listProductSearch(productName);
		mav.addObject("listProductSearch", listProductSearch);
		mav.addObject("soLuongSanPhamTimKiem", listProductSearch.size());
		mav.addObject("ParameterSearch", productName);
		return mav;
	}
}
