package catering_service.service;

import java.util.List;
import catering_service.entity.Payment;

public interface PaymentService {

	List<Payment> findAll();
	Payment findById(int paymentId);
	void save(Payment payment);
	void update(Payment payment);
	void delete(Payment payment);
	Payment generatePdf(int paymentId);
	
}
