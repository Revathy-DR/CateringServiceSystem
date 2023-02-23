package catering_service.entity;

public class Payment {
	
	private int paymentId;
	private Staff staff;
	private Order order;
	private Customer customer;
	private Menu menu;
	private int amount;
	private String paidBy;
	private String paymentDate;
	
	public Payment() {
		super();
	}

	public Payment(int paymentId, Staff staff, Order order, Customer customer, Menu menu, int amount, String paidBy,
			String paymentDate) {
		super();
		this.paymentId = paymentId;
		this.staff = staff;
		this.order = order;
		this.customer = customer;
		this.menu = menu;
		this.amount = amount;
		this.paidBy = paidBy;
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
