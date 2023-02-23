package catering_service.service;

import java.util.List;

import catering_service.dao.MenuDAOImpl;
import catering_service.entity.Menu;

public class MenuServiceImpl implements MenuService {

	@Override
	public List<Menu> findAll() {

		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		List<Menu> menuList = menuDAOImpl.findAll();
		return menuList;

	}

	@Override
	public void save(Menu menu) {
		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		int row = menuDAOImpl.save(menu);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void update(Menu menu) {
		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		int row = menuDAOImpl.update(menu);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(Menu menu) {
		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		int row = menuDAOImpl.delete(menu);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");

	}

	@Override
	public Menu findById(int menuId) {
		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		Menu menu = menuDAOImpl.findById(menuId);
		return menu;
	}

}
