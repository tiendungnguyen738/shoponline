package shoponline.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import shoponline.dto.GioHangDTO;
import shoponline.entity.Orders;
import shoponline.entity.OrdersDetail;
import shoponline.entity.OrdersDetailID;
import shoponline.service.impl.OrdersDetailServiceImpl;
import shoponline.service.impl.OrdersServiceImpl;
import shoponline.service.impl.ProductServiceImpl;

@Controller
@SessionAttributes({"gioHang"})
public class GioHangController {

	@Autowired
	private OrdersServiceImpl ordersServiceImpl;
	
	@Autowired
	private OrdersDetailServiceImpl ordersDetailServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/gio-hang")
	public ModelAndView pageGioHang(HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("gio-hang");
		
		if(httpSession.getAttribute("gioHang") != null) {
			List<GioHangDTO> listSessionGioHang=  (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			mav.addObject("listSessionGioHang", listSessionGioHang);
			mav.addObject("soLuongSanPham", listSessionGioHang.size());
		}
		return mav;
	}
	
	@PostMapping("/gio-hang")
	public ModelAndView hoaDonMuaHang(HttpSession httpSession,@RequestParam String CustomerName,@RequestParam String phone,
									  @RequestParam String address,@RequestParam String node) {
		ModelAndView mav = new ModelAndView("gio-hang");
		if(null != httpSession.getAttribute("gioHang")) {
			List<GioHangDTO> listGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			
			Orders orders = new Orders();
			orders.setAddress(address);
			orders.setPhone(phone);
			orders.setCustomerName(CustomerName);
			orders.setNote(node);
			ordersServiceImpl.addOrders(orders);
			
			for (GioHangDTO gioHangDTO : listGioHang) {
				
				OrdersDetail ordersDetail = new OrdersDetail();
				
				ordersDetail.setPrice(gioHangDTO.getPrice());
				ordersDetail.setQuantity(gioHangDTO.getSoLuong());
				
				OrdersDetailID ordersDetailID = new OrdersDetailID();
				ordersDetailID.setOrders_id(orders.getId());
				
				ordersDetailID.setProduct_detail_id(gioHangDTO.getProductDetailId());
				
				ordersDetail.setOrdersDetail(ordersDetailID);
				ordersDetailServiceImpl.addOrdersDetailService(ordersDetail);
				
				System.out.println("id product: "+gioHangDTO.getProductId());
				productServiceImpl.ProductPopular(gioHangDTO.getProductId());
			}
		}
		return mav;
	}
}
