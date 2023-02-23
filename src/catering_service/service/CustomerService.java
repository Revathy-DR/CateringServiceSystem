package catering_service.service;

import java.util.List;

import catering_service.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	Customer findById(int customerId);
	void save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);

}
