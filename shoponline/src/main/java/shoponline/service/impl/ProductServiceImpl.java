package shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shoponline.entity.Product;
import shoponline.repository.ProductRepository;
import shoponline.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public int getTongSoLuongSanPham() {
		return productRepository.getSoLuongSanPham();
	}

	public Page<Product> getTrangSanPham(Pageable pageable) {
		return productRepository.listProductLoadMore(pageable);
	}

	public Product getProductbyId(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public List<Product> listProductSearch(String productName) {
		return productRepository.listProductSearch(productName);
	}

	@Override
	public void ProductPopular(Long id) {
		Product pro = productRepository.getOne(id);
		pro.setPopular(pro.getPopular()+1);
		productRepository.save(pro);
	}

	@Override
	public Page<Product> pagenationProduct(Pageable pageable) {
		return productRepository.PagenationProduct(pageable);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepository.delete(id);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}


}
