package catering_service.dao;

import java.util.List;
import catering_service.entity.MenuType;


public interface MenuTypeDAO {
	
	List<MenuType> findAll();
	MenuType findById(int menuTypeId);
	int save(MenuType menuType);
	int update(MenuType menuType);
	int delete(MenuType menuType);

}
