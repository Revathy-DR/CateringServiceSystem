package catering_service.service;

import java.util.List;
import catering_service.entity.Staff;

public interface StaffService {
	
	List<Staff> findAll();
	Staff findById(int staffId);
	void save(Staff staff);
	void update(Staff staff);
	void delete(Staff staff);

}
