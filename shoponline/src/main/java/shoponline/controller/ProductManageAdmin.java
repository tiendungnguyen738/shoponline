package shoponline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shoponline.entity.Category;
import shoponline.entity.Color;
import shoponline.entity.Product;
import shoponline.entity.Size;
import shoponline.service.impl.CategoryServiceImpl;
import shoponline.service.impl.ColorServiceImpl;
import shoponline.service.impl.ProductServiceImpl;
import shoponline.service.impl.SizeServiceImpl;

@Controller
public class ProductManageAdmin {

	@Autowired
	private ProductServiceImpl productServiceImpl; 
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
    @Autowired
    private SizeServiceImpl sizeServiceImpl;

    @Autowired
    private ColorServiceImpl colorServiceImpl;
	
    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home-admin");
		return mav;
	}
    
	@RequestMapping(path= {"/admin-product/{id}","/admin-product"})
	public ModelAndView pageManageProduct(@PathVariable(name="id", required = false) Integer id ) {
		ModelAndView mav = new ModelAndView("Product_Admin");
		int soLuongSanPham = productServiceImpl.getTongSoLuongSanPham();
		int soTrangSanPham = (soLuongSanPham/5)+1;
		Pageable page = new PageRequest(0, 5);
		if(id == null) {
			 page = new PageRequest(0, 5);
		}
		else {
			 page = new PageRequest((id-1), 5);
		}
		Page<Product> listProduct = productServiceImpl.pagenationProduct(page);
        List<Product> productList1 = new ArrayList<Product>();
        for (Product pro:listProduct
        ) {
        	productList1.add(pro);
        }
        List<Category> categoryList = categoryServiceImpl.getListCategory();
        List<Color> colorList  = colorServiceImpl.getListColor();
        List<Size> sizeList = sizeServiceImpl.getListSize();
        mav.addObject("sizeList",sizeList);
        mav.addObject("colorList",colorList);
        mav.addObject("categoryList",categoryList);
        mav.addObject("tongSoTrang", soTrangSanPham);
        mav.addObject("productList1", productList1);
		return mav;
	}
}
