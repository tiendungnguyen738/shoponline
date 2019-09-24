package shoponline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoponline.entity.OrdersDetail;
import shoponline.repository.OrdersDetailRepository;
import shoponline.service.OrdersDetailService;

@Service
public class OrdersDetailServiceImpl implements OrdersDetailService{

	@Autowired
	private OrdersDetailRepository ordersDetailRepository;
	
	@Override
	public void addOrdersDetailService(OrdersDetail ordersDetail) {
		ordersDetailRepository.save(ordersDetail);
	}

}
