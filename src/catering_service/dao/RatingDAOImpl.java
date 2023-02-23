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
import catering_service.entity.Payment;
import catering_service.entity.Rating;

public class RatingDAOImpl implements RatingDAO {

	@Override
	public List<Rating> findAll() {
		List<Rating> ratingList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from rating";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int ratingId = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				int menuId = resultSet.getInt(3);
				int paymentId = resultSet.getInt(4);
				int score = resultSet.getInt(5);
				String review = resultSet.getString(6);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);
				Payment payment = new Payment();
				payment.setPaymentId(paymentId);

				Rating rating = new Rating(ratingId, customer, menu, payment, score, review);
				ratingList.add(rating);

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

		return ratingList;
	}

	@Override
	public int save(Rating rating) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into rating(rating_id, customer_id, menu_id, payment_id, score, review) "
				+ " values(?,?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, rating.getRatingId());
			preparedStatement.setInt(2, rating.getCustomer().getCustomerId());
			preparedStatement.setInt(3, rating.getMenu().getMenuId());
			preparedStatement.setInt(4, rating.getPayment().getPaymentId());
			preparedStatement.setInt(5, rating.getScore());
			preparedStatement.setString(6, rating.getReview());

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
	public int update(Rating rating) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update rating set customer_id = ?, menu_id = ?, payment_id = ?, score = ?, review = ? where rating_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, rating.getCustomer().getCustomerId());
			preparedStatement.setInt(2, rating.getMenu().getMenuId());
			preparedStatement.setInt(3, rating.getPayment().getPaymentId());
			preparedStatement.setInt(4, rating.getScore());
			preparedStatement.setString(5, rating.getReview());
			preparedStatement.setInt(6, rating.getRatingId());

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
	public int delete(Rating rating) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from rating where rating_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, rating.getRatingId());

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
	public Rating findById(int ratingId) {
		Rating rating = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from rating where rating_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, ratingId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				int menuId = resultSet.getInt(3);
				int paymentId = resultSet.getInt(4);
				int score = resultSet.getInt(5);
				String review = resultSet.getString(6);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Menu menu = new Menu();
				menu.setMenuId(menuId);
				Payment payment = new Payment();
				payment.setPaymentId(paymentId);

				rating = new Rating(ratingId, customer, menu, payment, score, review);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rating;

	}

	@Override
	public List<Rating> findMaxScore() {
		List<Rating> ratingList = new ArrayList();
		Rating rating = new Rating();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "select customer_id, menu_id, max(score), review from rating where score = 5 GROUP BY customer_id, menu_id, review";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);

			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int customerId = resultSet.getInt(1);
				int menuId = resultSet.getInt(2);
				int score1 = resultSet.getInt(3);
				String review = resultSet.getString(4);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);

				Menu menu = new Menu();
				menu.setMenuId(menuId);

				rating = new Rating();
				rating.setCustomer(customer);
				rating.setMenu(menu);
				rating.setScore(score1);
				rating.setReview(review);
				ratingList.add(rating);

			}
		} catch (SQLException e) {
			System.out.println("Score does not exist");
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ratingList;
	}

}
