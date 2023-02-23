package catering_service.dao;

import java.util.List;
import catering_service.entity.Payment;

public interface PaymentDAO {
	
	List<Payment> findAll();
	Payment findById(int paymentId);
	int save(Payment payment);
	int update(Payment payment);
	int delete(Payment payment);
	Payment generatePdf(int paymentId);

}
