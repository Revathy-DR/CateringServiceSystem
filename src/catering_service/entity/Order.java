package catering_service.entity;

public class Order {
	
	private int orderId;
	private Customer customer;
	private Staff staff;
	private Menu menu;
	private String orderStatus;
	private String orderDate;
	private int noOfServings;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, Customer customer, Staff staff, Menu menu, String orderStatus, String orderDate,
			int noOfServings) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.staff = staff;
		this.menu = menu;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.noOfServings = noOfServings;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getNoOfServings() {
		return noOfServings;
	}
	public void setNoOfServings(int noOfServings) {
		this.noOfServings = noOfServings;
	}

}
