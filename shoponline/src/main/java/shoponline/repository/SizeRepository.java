package shoponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shoponline.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long>{

	@Query("select u from Size u")
	List<Size> getListSize();
}
