package shoponline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoponline.entity.Orders;
import shoponline.repository.OrdersRepository;
import shoponline.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository ordersRepository;
	
	
	@Override
	public void addOrders(Orders orders) {
		ordersRepository.save(orders);
	}

}
