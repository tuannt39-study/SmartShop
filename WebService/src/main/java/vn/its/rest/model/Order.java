package vn.its.rest.model;

import java.sql.Timestamp;

public class Order {
	private long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String note;
	private long amuont;
	private String payment;
	private String paymentInfo;
	private String security;
	private long userID;
	private Timestamp createdTime;
	private String status;
	
	public Order() {
		
	}

}
