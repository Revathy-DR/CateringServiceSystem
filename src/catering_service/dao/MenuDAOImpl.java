package catering_service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import catering_service.dbconnectionpool.DBConnectionPool;
import catering_service.entity.Menu;
import catering_service.entity.MenuType;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> findAll() {
		List<Menu> menuList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from menu";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int menuId = resultSet.getInt(1);
				int menuTypeId = resultSet.getInt(2);
				String menuName = resultSet.getString(3);
				String menuStatus = resultSet.getString(4);
				int price = resultSet.getInt(5);

				MenuType menuType = new MenuType();
				menuType.setMenuTypeId(menuTypeId);

				Menu menu = new Menu(menuId, menuType, menuName, menuStatus, price);
				menuList.add(menu);

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

		return menuList;
	}

	@Override
	public int save(Menu menu) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into menu(menu_id, menu_type_id, menu_name, menu_status, price) "
				+ " values(?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, menu.getMenuId());
			preparedStatement.setInt(2, menu.getMenuType().getMenuTypeId());
			preparedStatement.setString(3, menu.getMenuName());
			preparedStatement.setString(4, menu.getMenuStatus());
			preparedStatement.setInt(5, menu.getPrice());

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
	public int update(Menu menu) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update menu set menu_type_id = ?, menu_name = ?, menu_status = ?, price = ? where menu_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, menu.getMenuType().getMenuTypeId());
			preparedStatement.setString(2, menu.getMenuName());
			preparedStatement.setString(3, menu.getMenuStatus());
			preparedStatement.setInt(4, menu.getPrice());
			preparedStatement.setInt(5, menu.getMenuId());

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
	public int delete(Menu menu) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from menu where menu_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, menu.getMenuId());

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
	public Menu findById(int menuId) {
		Menu menu = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from menu where menu_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, menuId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				int menuTypeId = resultSet.getInt(2);
				String menuName = resultSet.getString(3);
				String menuStatus = resultSet.getString(4);
				int price = resultSet.getInt(5);

				MenuType menuType = new MenuType();
				menuType.setMenuTypeId(menuTypeId);

				menu = new Menu(menuId, menuType, menuName, menuStatus, price);

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
		return menu;
	}

}
