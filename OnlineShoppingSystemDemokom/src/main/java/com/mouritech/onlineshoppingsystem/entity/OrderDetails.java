package com.mouritech.onlineshoppingsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="order_details")
public class OrderDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDetailsId;

	@Column(name = "unit_price", nullable = false)
	private double price;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "orderId")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "prodId")
	private Product product;

	public OrderDetails() {
		super();
	}

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}



	


	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	public OrderDetails(Long orderDetailsId,  double price, long quantity,
			double totalPrice, String status, String comments) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.comments = comments;
	}

	
	public OrderDetails( double price, long quantity, double totalPrice, String status,
			String comments) {
		super();
		

		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId  + 
				 ", price=" + price + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", comments=" + comments + ", order=" + order + "]";
	}


}
