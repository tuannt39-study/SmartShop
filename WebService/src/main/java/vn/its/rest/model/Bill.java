package vn.its.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill {
	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "ORDERS_ID")
	private long orderId;
	
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "QUANTITY")
	private long quantity;
	
	@Column(name = "AMOUNT")
	private long amount;
	
	@Column(name = "NOTE")
	private String note;
	
	@Column(name = "STATUS")
	private String status;

	public Bill() {
		super();
	}

	public Bill(long id, long orderId, long productId, long quantity, long amount, String note, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.note = note;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
