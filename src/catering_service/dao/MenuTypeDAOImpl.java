package catering_service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import catering_service.dbconnectionpool.DBConnectionPool;
import catering_service.entity.MenuType;

public class MenuTypeDAOImpl implements MenuTypeDAO {

	@Override
	public List<MenuType> findAll() {
		List<MenuType> menuTypeList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from menu_type";
		try {
			DataSource ds = DBConnectionPool.getDataSource(); // 5 steps of db connectivity
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int menuTypeId = resultSet.getInt(1);
				String typeName = resultSet.getString(2);
				String description = resultSet.getString(3);

				MenuType menuType = new MenuType(menuTypeId, typeName, description);
				menuTypeList.add(menuType);

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

		return menuTypeList;
	}

	@Override
	public int save(MenuType menuType) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into menu_type(menu_type_id, type_name, description) values(?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, menuType.getMenuTypeId());
			preparedStatement.setString(2, menuType.getTypeName());
			preparedStatement.setString(3, menuType.getDescription());
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
	public int update(MenuType menuType) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update menu_type set type_name = ?, description = ? where menu_type_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);

			preparedStatement.setString(1, menuType.getTypeName());
			preparedStatement.setString(2, menuType.getDescription());
			preparedStatement.setInt(3, menuType.getMenuTypeId());
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
	public int delete(MenuType menuType) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from menu_type where menu_type_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, menuType.getMenuTypeId());

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
	public MenuType findById(int menuTypeId) {
		MenuType menuType = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from menu_type where menu_type_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, menuTypeId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				String typeName = resultSet.getString(2);
				String description = resultSet.getString(3);

				menuType = new MenuType(menuTypeId, typeName, description);
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
		return menuType;
	}

}
