package catering_service.service;

import java.util.List;
import catering_service.entity.Menu;

public interface MenuService {
	
	List<Menu> findAll();
	Menu findById(int menuId);
	void save(Menu menu);
	void update(Menu menu);
	void delete(Menu menu);

}
