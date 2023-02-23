package catering_service.dao;

import java.util.List;
import catering_service.entity.Staff;

public interface StaffDAO {

	List<Staff> findAll();
	Staff findById(int staffId);
	int save(Staff staff);
	int update(Staff staff);
	int delete(Staff staff);

}
