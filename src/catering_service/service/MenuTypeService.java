package catering_service.service;

import java.util.List;
import catering_service.entity.MenuType;

public interface MenuTypeService {
	
	List<MenuType> findAll();
	MenuType findById(int menuTypeId);
	void save(MenuType menuType);
	void update(MenuType menuType);
	void delete(MenuType menuType);

}
