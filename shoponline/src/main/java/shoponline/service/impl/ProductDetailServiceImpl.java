package shoponline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoponline.entity.ProductDetail;
import shoponline.repository.ProductDetailRepository;
import shoponline.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Override
	public ProductDetail getDetailProduct(Long id) {
		return productDetailRepository.findOne(id);
	}


}
