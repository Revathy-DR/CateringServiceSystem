package catering_service.service;

import java.util.List;
import catering_service.dao.StaffDAOImpl;
import catering_service.entity.Staff;

public class StaffServiceImpl implements StaffService {

	@Override
	public List<Staff> findAll() {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		List<Staff> staffList = staffDAOImpl.findAll();
		return staffList;
	}

	@Override
	public void save(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.save(staff);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}
	@Override
	public void update(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.update(staff);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void delete(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.delete(staff);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");

	}

	@Override
	public Staff findById(int staffId) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		Staff staff = staffDAOImpl.findById(staffId);
		return staff;
	}

}
