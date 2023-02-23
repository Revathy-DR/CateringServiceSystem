package catering_service.entity;

import java.util.Date;

public class Rating {
	
	private int ratingId;
	private Customer customer;
	private Menu menu;
	private Payment payment;
	private int score;
	private String review;
	
	public Rating() {
		super();
	}

	public Rating(int ratingId, Customer customer, Menu menu, Payment payment, int score, String review) {
		super();
		this.ratingId = ratingId;
		this.customer = customer;
		this.menu = menu;
		this.payment = payment;
		this.score = score;
		this.review = review;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}