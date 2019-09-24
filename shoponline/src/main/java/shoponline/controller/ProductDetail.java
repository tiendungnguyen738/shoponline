package shoponline.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import shoponline.dto.GioHangDTO;
import shoponline.entity.Product;
import shoponline.service.impl.ProductServiceImpl;

@Controller
@SessionAttributes("gioHang")
public class ProductDetail {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/productDetail/{idProduct}")
	@ResponseBody
	public ModelAndView pageProductDetail(@PathVariable("idProduct") Long idProduct, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("product-detail");
		Product product = productServiceImpl.getProductbyId(idProduct);

		if(httpSession.getAttribute("gioHang") != null) {
			List<GioHangDTO> listGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			mav.addObject("soLuongSanPham", listGioHang.size());
		}
		mav.addObject("product", product);
		return mav;
	}
}
