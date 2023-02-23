package catering_service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import catering_service.dbconnectionpool.DBConnectionPool;
import catering_service.entity.Staff;

public class StaffDAOImpl implements StaffDAO {

	@Override
	public List<Staff> findAll() {
		List<Staff> staffList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from staff";
		try {
			DataSource ds = DBConnectionPool.getDataSource(); // 5 steps of db connectivity
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int staffId = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String staffPhone = resultSet.getString(3);
				String staffAddress = resultSet.getString(4);

				Staff staff = new Staff(staffId, staffName, staffPhone, staffAddress);
				staffList.add(staff);

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

		return staffList;

	}

	@Override
	public int save(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into staff(staff_id, staff_name, staff_phone, staff_address) values(?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, staff.getStaffId());
			preparedStatement.setString(2, staff.getStaffName());
			preparedStatement.setString(3, staff.getStaffPhone());
			preparedStatement.setString(4, staff.getStaffAddress());
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
	public int update(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update staff set staff_name = ?, staff_phone = ?, staff_address = ? where staff_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, staff.getStaffName());
			preparedStatement.setString(2, staff.getStaffPhone());
			preparedStatement.setString(3, staff.getStaffAddress());
			preparedStatement.setInt(4, staff.getStaffId());
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
	public int delete(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from staff where staff_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, staff.getStaffId());

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
	public Staff findById(int staffId) {
		Staff staff = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from staff where staff_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, staffId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String staffPhone = resultSet.getString(3);
				String staffAddress = resultSet.getString(4);

				staff = new Staff(staffId, staffName, staffPhone, staffAddress);
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
		return staff;
	}

}
