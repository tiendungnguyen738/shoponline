package shoponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoponline.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
