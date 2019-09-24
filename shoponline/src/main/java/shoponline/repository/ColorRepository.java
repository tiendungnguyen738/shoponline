package shoponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shoponline.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long>{

	@Query("select u from Color u")
	List<Color> getListColor();
}
