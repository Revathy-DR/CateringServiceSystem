package catering_service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import catering_service.dbconnectionpool.DBConnectionPool;
import catering_service.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from customer";
		try {
			DataSource ds = DBConnectionPool.getDataSource(); // 5 steps of db connectivity
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int customerId = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String customerEmail = resultSet.getString(4);
				String customerPhone = resultSet.getString(5);
				Customer customer = new Customer(customerId, customerFirstName, customerLastName, customerEmail,
						customerPhone);
				customerList.add(customer);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customerList;

	}

	@Override
	public int save(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into customer(customer_id, customer_first_name, customer_last_name, customer_email, customer_phone) values(?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerFirstName());
			preparedStatement.setString(3, customer.getCustomerLastName());
			preparedStatement.setString(4, customer.getCustomerEmail());
			preparedStatement.setString(5, customer.getCustomerPhone());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}
	@Override
	public int update(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update customer set customer_first_name = ?, customer_last_name = ?, customer_email = ?, customer_phone = ? where customer_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, customer.getCustomerFirstName());
			preparedStatement.setString(2, customer.getCustomerLastName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPhone());
			preparedStatement.setInt(5, customer.getCustomerId());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from customer where customer_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, customer.getCustomerId());
		
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Customer findById(int customerId) {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from customer where customer_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource(); 
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, customerId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String customerEmail = resultSet.getString(4);
				String customerPhone = resultSet.getString(5);
				
				customer = new Customer(customerId, customerFirstName, customerLastName, customerEmail,
						customerPhone);
				//customerList.add(customer);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customer;
	}

}
