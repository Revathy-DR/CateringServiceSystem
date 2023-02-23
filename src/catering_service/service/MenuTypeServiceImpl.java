package catering_service.service;

import java.util.List;

import catering_service.dao.CustomerDAOImpl;
import catering_service.dao.MenuTypeDAOImpl;
import catering_service.entity.Customer;
import catering_service.entity.MenuType;

public class MenuTypeServiceImpl implements MenuTypeService {

	@Override
	public List<MenuType> findAll() {
		MenuTypeDAOImpl menuTypeDAOImpl = new MenuTypeDAOImpl();
		List<MenuType> menuTypeList = menuTypeDAOImpl.findAll();
		return menuTypeList;
	}

	@Override
	public void save(MenuType menuType) {
		MenuTypeDAOImpl menuTypeDAOImpl = new MenuTypeDAOImpl();
		int row = menuTypeDAOImpl.save(menuType);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void update(MenuType menuType) {
		MenuTypeDAOImpl menuTypeDAOImpl = new MenuTypeDAOImpl();
		int row = menuTypeDAOImpl.update(menuType);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(MenuType menuType) {
		MenuTypeDAOImpl menuTypeDAOImpl = new MenuTypeDAOImpl();
		int row = menuTypeDAOImpl.delete(menuType);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");

	}

	@Override
	public MenuType findById(int menuTypeId) {
		MenuTypeDAOImpl menuTypeDAOImpl = new MenuTypeDAOImpl();
		MenuType menuType = menuTypeDAOImpl.findById(menuTypeId);
		return menuType;
	}

}
