package catering_service.service;

import java.util.List;

import catering_service.dao.CustomerDAOImpl;
import catering_service.entity.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public List<Customer> findAll() {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		List<Customer> customerList = customerDAOImpl.findAll();
		return customerList;
	}

	@Override
	public void save(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.save(customer);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
	}
	@Override
	public void update(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.update(customer);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.delete(customer);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");

	}

	@Override
	public Customer findById(int customerId) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		Customer customer = customerDAOImpl.findById(customerId);
		return customer;
	}

}
