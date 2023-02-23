package catering_service.service;

import java.util.List;
import catering_service.dao.OrderDAOImpl;
import catering_service.entity.Order;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> findAll() {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		List<Order> orderList = orderDAOImpl.findAll();
		return orderList;
	}

	@Override
	public void save(Order order) {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		int row = orderDAOImpl.save(order);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	}

	@Override
	public void update(Order order) {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		int row = orderDAOImpl.update(order);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(Order order) {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		int row = orderDAOImpl.delete(order);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");
	}

	@Override
	public Order findById(int orderId) {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		Order order = orderDAOImpl.findById(orderId);
		return order;
	}

}
