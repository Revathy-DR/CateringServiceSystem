package catering_service.dao;

import java.util.List;
import catering_service.entity.Order;

public interface OrderDAO {
	
	List<Order> findAll();
	Order findById(int orderId);
	int save(Order order);
	int update(Order order);
	int delete(Order order);

}
