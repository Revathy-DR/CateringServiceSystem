package catering_service.service;

import java.util.List;

import catering_service.dao.PaymentDAOImpl;
import catering_service.entity.Payment;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public List<Payment> findAll() {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		List<Payment> paymentList = paymentDAOImpl.findAll();
		return paymentList;
	}

	@Override
	public void save(Payment payment) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		int row = paymentDAOImpl.save(payment);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	}

	@Override
	public void update(Payment payment) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		int row = paymentDAOImpl.update(payment);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
	}

	@Override
	public void delete(Payment payment) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		int row = paymentDAOImpl.delete(payment);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETE FAILED!!!!!!!!!!!!");
	}

	@Override
	public Payment findById(int paymentId) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		Payment payment = paymentDAOImpl.findById(paymentId);
		return payment;
	}

	@Override
	public Payment generatePdf(int paymentId) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		Payment payment = paymentDAOImpl.generatePdf(paymentId);
		return payment;
	}

}
