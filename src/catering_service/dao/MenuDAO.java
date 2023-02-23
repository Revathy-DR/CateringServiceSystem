package catering_service.dao;

import java.util.List;
import catering_service.entity.Menu;

public interface MenuDAO {
	
	List<Menu> findAll();
	Menu findById(int menuId);
	int save(Menu menu);
	int update(Menu menu);
	int delete(Menu menu);

}
