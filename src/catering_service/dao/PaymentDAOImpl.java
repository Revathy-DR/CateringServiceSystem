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
import catering_service.entity.Payment;
import catering_service.entity.Staff;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public List<Payment> findAll() {
		List<Payment> paymentList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from payment";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int paymentId = resultSet.getInt(1);
				int staffId = resultSet.getInt(2);
				int orderId = resultSet.getInt(3);
				int customerId = resultSet.getInt(4);
				int menuId = resultSet.getInt(5);
				int amount = resultSet.getInt(6);
				String paidBy = resultSet.getString(7);
				String paymentDate = resultSet.getString(8);

				Staff staff = new Staff();
				staff.setStaffId(staffId);
				Order order = new Order();
				order.setOrderId(orderId);
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);

				Payment payment = new Payment(paymentId, staff, order, customer, menu, amount, paidBy, paymentDate);
				paymentList.add(payment);

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

		return paymentList;
	}

	@Override
	public int save(Payment payment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into payment(payment_id, staff_id, order_id, customer_id, menu_id, amount, paid_by, payment_date) "
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, payment.getPaymentId());
			preparedStatement.setInt(2, payment.getStaff().getStaffId());
			preparedStatement.setInt(3, payment.getOrder().getOrderId());
			preparedStatement.setInt(4, payment.getCustomer().getCustomerId());
			preparedStatement.setInt(5, payment.getMenu().getMenuId());
			preparedStatement.setInt(6, payment.getAmount());
			preparedStatement.setString(7, payment.getPaidBy());
			preparedStatement.setString(8, payment.getPaymentDate());

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
	public int update(Payment payment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update payment set staff_id = ?, order_id = ?, customer_id = ?, menu_id = ?, amount = ?, paid_by = ?, payment_date = ? where payment_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, payment.getStaff().getStaffId());
			preparedStatement.setInt(2, payment.getOrder().getOrderId());
			preparedStatement.setInt(3, payment.getCustomer().getCustomerId());
			preparedStatement.setInt(4, payment.getMenu().getMenuId());
			preparedStatement.setInt(5, payment.getAmount());
			preparedStatement.setString(6, payment.getPaidBy());
			preparedStatement.setString(7, payment.getPaymentDate());
			preparedStatement.setInt(8, payment.getPaymentId());

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
	public int delete(Payment payment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from payment where payment_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, payment.getPaymentId());

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
	public Payment findById(int paymentId) {
		Payment payment = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from payment where payment_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, paymentId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				int staffId = resultSet.getInt(2);
				int orderId = resultSet.getInt(3);
				int customerId = resultSet.getInt(4);
				int menuId = resultSet.getInt(5);
				int amount = resultSet.getInt(6);
				String paidBy = resultSet.getString(7);
				String paymentDate = resultSet.getString(8);

				Staff staff = new Staff();
				staff.setStaffId(staffId);
				Order order = new Order();
				order.setOrderId(orderId);
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);

				payment = new Payment(paymentId, staff, order, customer, menu, amount, paidBy, paymentDate);

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
		return payment;
	}
	@Override
	public Payment generatePdf(int paymentId) {
		Payment payment = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from payment";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			//prepStmt.setInt(1, paymentId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int payment_Id = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				int menuId = resultSet.getInt(3);
				int amount = resultSet.getInt(4);
				String paymentDate = resultSet.getString(5);
				
				Customer customer = new Customer();
				customer.setCustomerId(customerId);	
				Menu menu = new Menu();
				menu.setMenuId(menuId);
				payment = new Payment();
				payment.setPaymentId(payment_Id);
				payment.setAmount(amount);
				payment.setPaymentDate(paymentDate);
				payment.setMenu(menu);
				payment.setCustomer(customer);

			}
		} catch (SQLException e) {
			System.out.println("Id does not exist");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return payment;
	}
}

	/*@Override
	public Payment generatePdf(int paymentId) {
		Payment payment = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		
		String selectSQL = "Select * from payment where payment_id=" + paymentId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			//prepStmt.setInt(1, paymentId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int payment_Id = resultSet.getInt(1);
				int customerId = resultSet.getInt(3);
				int menuId = resultSet.getInt(2);
				int amount = resultSet.getInt(4);
				String paymentDate = resultSet.getString(5);

				Menu menu = new Menu();
				menu.setMenuId(menuId);
				
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
		
				String selectSQL2 = "Select customer_id, customer_name from customer where customer_id=" + customerId;
				try {
					DataSource ds2 = DBConnectionPool.getDataSource();
					connection = ds2.getConnection();
					prepStmt = connection.prepareStatement(selectSQL2);
					ResultSet resultSet2 = prepStmt.executeQuery();
					while (resultSet2.next()) {
						int customerid = resultSet2.getInt(1);
						String customerName = resultSet2.getString(2);
					}
		
		return null;
	}

}*/
/*public Bill generateBillById(int billId) {
	Bill bill = null;
	Connection connection = null;
	PreparedStatement prepStmt = null;

	String selectSQL = "Select * from bill where bill_id=" + billId;

	try {
		DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();
		prepStmt = connection.prepareStatement(selectSQL);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			int bill_id = resultSet.getInt(1);
			int vehicleId = resultSet.getInt(2);
			int serviceId = resultSet.getInt(3);
			int customerId = resultSet.getInt(4);
			String paymentMode = resultSet.getString(5);
			double billAmount = resultSet.getDouble(6);
			String billDate = resultSet.getString(7);

			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(vehicleId);

			Service service = new Service();
			service.setServiceId(serviceId);

			Customer customer = new Customer();
			customer.setCusId(customerId);

//			bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);

			String selectSQL2 = "Select service_type ,service_id from service where service_id=" + serviceId;

			try {
				DataSource ds2 = DBConnectionPool.getDataSource();
				connection = ds2.getConnection();
				prepStmt = connection.prepareStatement(selectSQL2);
				ResultSet resultSet2 = prepStmt.executeQuery();
				while (resultSet2.next()) {
					String serviceType = resultSet2.getString(1);
					int vehicleid = resultSet2.getInt(2);

					String selectSQL3 = "Select vehicle_id, vehicle_name,vehicle_number from vehicle  where vehicle_id="
							+ vehicleId;

					try {
						DataSource ds3 = DBConnectionPool.getDataSource();
						connection = ds3.getConnection();
						prepStmt = connection.prepareStatement(selectSQL3);
						ResultSet resultSet3 = prepStmt.executeQuery();
						while (resultSet3.next()) {
							int customerid = resultSet3.getInt(1);
							String vehicleName = resultSet3.getString(2);
							String vehicleNumber = resultSet3.getString(3);
							

							String selectSQL4 = "Select customer_name,customer_phonenumber from customer  where customer_id="
									+ customerId;

							try {
								DataSource ds4 = DBConnectionPool.getDataSource();
								connection = ds4.getConnection();
								prepStmt = connection.prepareStatement(selectSQL3);
								ResultSet resultSet4 = prepStmt.executeQuery();
								while (resultSet4.next()) {
									String customerName = resultSet3.getString(1);
									String customerphoneNumber = resultSet3.getString(2);

								}
							} catch (SQLException e) {
								e.printStackTrace();

							}

						}
					} catch (SQLException e) {
						e.printStackTrace();

					}
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);
		}
	}

	catch (SQLException e) {
		e.printStackTrace();

	} finally {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	return bill;
}

}*/