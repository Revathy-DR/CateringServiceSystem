package catering_service.service;

import java.util.List;
import catering_service.entity.Order;

public interface OrderService {
	
	List<Order> findAll();
	Order findById(int orderId);
	void save(Order order);
	void update(Order order);
	void delete(Order order);

}
