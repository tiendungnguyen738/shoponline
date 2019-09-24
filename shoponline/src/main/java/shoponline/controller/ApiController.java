package shoponline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import shoponline.dto.GioHangDTO;

@Controller
@RequestMapping("/api")
@SessionAttributes({"gioHang"})
public class ApiController {

	@GetMapping("/update-gio-hang")
	@ResponseBody
	public void UpdateGioHang(@RequestParam Long maSp,@RequestParam Long maSize,@RequestParam Long maMau,
							  @RequestParam int soLuong,HttpSession httpSession) {
		if(null != httpSession.getAttribute("gioHang")) {
			List<GioHangDTO> listGioHangDTOs = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			for (GioHangDTO gioHangDTO : listGioHangDTOs) {
				if(gioHangDTO.getColorId() == maMau && gioHangDTO.getProductId() == maSp && gioHangDTO.getSizeId() == maSize) {
					gioHangDTO.setSoLuong(soLuong);
				}
			}
		}
	}
	
	@GetMapping("/delete-gio-hang")
	@ResponseBody
	public void DeleteGioHang(@RequestParam Long maSp,@RequestParam Long maSize,@RequestParam Long maMau,HttpSession httpSession) {
		if(null != httpSession.getAttribute("gioHang")) {
			List<GioHangDTO> listDtos = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			for(int i = 0;i<listDtos.size();i++) {
				if(listDtos.get(i).getColorId() == maMau && listDtos.get(i).getProductId() == maSp && listDtos.get(i).getSizeId() == maSize) {
					listDtos.remove(i);
				}
			}
		}
	}
	
	@GetMapping("/them-gio-hang")
	@ResponseBody
	public int ThemGioHang(@RequestParam Long productId, @RequestParam String productName, @RequestParam Long productPrice,
							@RequestParam Long sizeId,@RequestParam String image,@RequestParam Long productDetailId,
							@RequestParam Long colorId,@RequestParam String colorName,@RequestParam String sizeName, HttpSession httpSession) {
		if(null == httpSession.getAttribute("gioHang")) {
			List<GioHangDTO> listGioHang = new ArrayList<GioHangDTO>();
			listGioHang.add(createGioHang(productId,  productName,  productPrice, sizeId, colorId,  colorName,  sizeName,image,productDetailId));
			httpSession.setAttribute("gioHang", listGioHang);
		}
		else {
			List<GioHangDTO> listSessionGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
			if(ktraTrungGioHang(httpSession, productId, sizeId, colorId) == -1) {				
				listSessionGioHang.add(createGioHang(productId,  productName,  productPrice, sizeId, colorId,  colorName,  sizeName,image,productDetailId));
			}
		}
		List<GioHangDTO> listSessionGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
		return listSessionGioHang.size();
	}
	
	private int ktraTrungGioHang(HttpSession httpSession, Long productId,Long sizeId,Long colorId) {
		List<GioHangDTO> listSessionGioHang = (List<GioHangDTO>) httpSession.getAttribute("gioHang");
		for (GioHangDTO gioHangDTO : listSessionGioHang) {
			if(gioHangDTO.getColorId() == colorId && gioHangDTO.getProductId() == productId && gioHangDTO.getSizeId() == sizeId) {
				gioHangDTO.setSoLuong(gioHangDTO.getSoLuong()+1);
				return 1;
			}
		}
		return -1;
	}
	
	private GioHangDTO createGioHang(Long productId, String productName, Long productPrice,Long sizeId,
									 Long colorId, String colorName, String sizeName,String image,Long productDetailId) {
		GioHangDTO gioHangDTO = new GioHangDTO();
		gioHangDTO.setProductId(productId);
		gioHangDTO.setProductName(productName);
		gioHangDTO.setPrice(productPrice.toString());
		gioHangDTO.setColorId(colorId);
		gioHangDTO.setColorName(colorName);
		gioHangDTO.setSizeId(sizeId);
		gioHangDTO.setSizeName(sizeName);
		gioHangDTO.setImage(image);
		gioHangDTO.setSoLuong(1);
		gioHangDTO.setProductDetailId(productDetailId);
		return gioHangDTO;
	}
}
