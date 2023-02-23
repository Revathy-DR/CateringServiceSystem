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
import catering_service.entity.Menu;
import catering_service.entity.Order;
import catering_service.entity.Staff;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Order> findAll() {
		List<Order> orderList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "select * from order_details";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int orderId = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				int menuId = resultSet.getInt(4);
				String orderStatus = resultSet.getString(5);
				String orderDate = resultSet.getString(6);
				int noOfServings = resultSet.getInt(7);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);

				Order order = new Order(orderId, customer, staff, menu, orderStatus, orderDate, noOfServings);
				orderList.add(order);

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

		return orderList;
	}

	@Override
	public int save(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String INSERT_SQL = "insert into order_details(order_id, customer_id, staff_id, menu_id, order_status, order_date, no_ofservings)"
				+ " values(?,?,?,?,?,?,?)";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, order.getOrderId());
			preparedStatement.setInt(2, order.getCustomer().getCustomerId());
			preparedStatement.setInt(3, order.getStaff().getStaffId());
			preparedStatement.setInt(4, order.getMenu().getMenuId());
			preparedStatement.setString(5, order.getOrderStatus());
			preparedStatement.setString(6, order.getOrderDate());
			preparedStatement.setInt(7, order.getNoOfServings());

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
	public int update(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update order_details set customer_id = ?, staff_id = ?, menu_id = ?, order_status = ?, order_date = ?, no_ofservings = ? where order_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, order.getCustomer().getCustomerId());
			preparedStatement.setInt(2, order.getStaff().getStaffId());
			preparedStatement.setInt(3, order.getMenu().getMenuId());
			preparedStatement.setString(4, order.getOrderStatus());
			preparedStatement.setString(5, order.getOrderDate());
			preparedStatement.setInt(6, order.getNoOfServings());
			preparedStatement.setInt(7, order.getOrderId());

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
	public int delete(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from order_details where order_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, order.getOrderId());

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
	public Order findById(int orderId) {
		Order order = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from order_details where order_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, orderId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				int menuId = resultSet.getInt(4);
				String orderStatus = resultSet.getString(5);
				String orderDate = resultSet.getString(6);
				int noOfServings = resultSet.getInt(7);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);

				order = new Order(orderId, customer, staff, menu, orderStatus, orderDate, noOfServings);

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
		return order;
	}

}
