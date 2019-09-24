package shoponline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shoponline.entity.Product;


public interface ProductService {

	int getTongSoLuongSanPham();
	Page<Product> getTrangSanPham(Pageable pageable);
	Product getProductbyId(Long id);
	List<Product> listProductSearch(String productName);
	void ProductPopular(Long id);
	Page<Product> pagenationProduct(Pageable pageable);
	void addProduct(Product product);
	void deleteProductById(Long id);
	void updateProduct(Product product);
}