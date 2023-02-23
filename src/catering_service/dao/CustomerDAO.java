package catering_service.dao;

import java.util.List;

import catering_service.entity.Customer;

public interface CustomerDAO {
	
	 List<Customer> findAll();
	 Customer findById(int customerId);
	 int save(Customer customer);
	 int update(Customer customer);
	 int delete(Customer customer);

}
