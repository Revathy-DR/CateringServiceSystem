package catering_service.utility;
/*
 * Revathy DR
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import catering_service.entity.Customer;
import catering_service.entity.Menu;
import catering_service.entity.Payment;
import catering_service.service.CustomerServiceImpl;
import catering_service.service.MenuServiceImpl;
import catering_service.service.PaymentServiceImpl;

public class BillPdfGenerator {

	public static void main(String[] args) {
		generateBillById();
	}

	public static void generateBillById() {
		String filePath = "D:\\payment\\payment.pdf";
		Document document = new Document();

		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(Image.getInstance("D:\\catering.jpg"));
			document.add(new Paragraph(" "));
			
			Paragraph para = new Paragraph("*******************************BILL*******************************");
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the payment id");
			int paymentId = scanner.nextInt();

			PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
			Payment payment = paymentServiceImpl.findById(paymentId);
			Payment payment1 = paymentServiceImpl.generatePdf(paymentId);
			
			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			Customer customer = customerServiceImpl.findById(payment.getCustomer().getCustomerId());
			
			MenuServiceImpl menuServiceImpl = new MenuServiceImpl();
			Menu menu = menuServiceImpl.findById(payment.getMenu().getMenuId());

			Paragraph paymentID = new Paragraph("Payment ID: " + payment.getPaymentId());
			Paragraph customerID = new Paragraph("Customer ID: " + customer.getCustomerId());
			Paragraph customerName = new Paragraph("Customer Name: " + customer.getCustomerFirstName());
			Paragraph menuName = new Paragraph("Menu name: " + menu.getMenuName());
			Paragraph amount = new Paragraph("Amount: " + payment.getAmount());
			Paragraph paymentDate = new Paragraph("Payment Date: " + payment.getPaymentDate());
			System.out.println("Bill generated successfully");
			
			document.add(para);
			document.add(paymentID);
			document.add(customerID);
			document.add(customerName);
			document.add(menuName);
			document.add(amount);
			document.add(paymentDate);
			Paragraph para1 = new Paragraph("*******************************************************************");
            document.add(para1);
            document.close();
            
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Bill ID not found...");
		/*} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();*/
		}
		
	}

}
