package com.mouritech.onlineshoppingsystem.entity;




import java.io.Serializable;

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
@Table(name = "cart")
public class Cart implements Serializable  {
	 private static final long serialVersionUID = 1L;
	    /**
	     * 
	     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;
	
	@Column(name = "content")
	private String content;

	 
	 @ManyToOne(fetch = FetchType.LAZY,optional = false)
		
		@OnDelete(action = OnDeleteAction.CASCADE)
	    @JoinColumn(name = "product_id", nullable = false)
	    private Product product;

	public Cart(long cartId, String content, Product product) {
		super();
		this.cartId = cartId;
		this.content = content;
		this.product = product;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", content=" + content + "]";
	}
	

	public Cart(long cartId, String content) {
		super();
		this.cartId = cartId;
		this.content = content;
	}

	public Cart(String content, Product product) {
		super();
		this.content = content;
		this.product = product;
	}


	
	
	

//	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
//	@JoinColumn(name = "prodId")
//  @OnDelete(action = OnDeleteAction.CASCADE)
//	private Product product;

//	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//	private Set<Product> products = new HashSet<>();

//	@OneToOne(cascade = CascadeType.PERSIST)
//     @JoinColumn(name = "custId")
//     @OnDelete(action = OnDeleteAction.CASCADE)
//	private Customer customer;

	





}
