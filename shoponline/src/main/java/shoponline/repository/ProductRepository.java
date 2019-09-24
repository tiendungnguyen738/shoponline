package shoponline.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoponline.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select count(u) from Product u")
	int getSoLuongSanPham();
	
	@Query("select u from Product u where u.productName LIKE '%' || :productName || '%'")
	List<Product> listProductSearch(@Param("productName") String productName);
	
	@Query("from Product u order by u.popular DESC")
	Page<Product> listProductLoadMore(Pageable pageable);
	
	@Query("from Product u")
	Page<Product> PagenationProduct(Pageable pageable);
}
