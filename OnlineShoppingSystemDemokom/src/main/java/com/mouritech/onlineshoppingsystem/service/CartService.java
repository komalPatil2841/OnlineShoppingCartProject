package com.mouritech.onlineshoppingsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlineshoppingsystem.entity.Cart;
import com.mouritech.onlineshoppingsystem.exception.CartNotFoundException;
import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;

public interface CartService {

	Cart insertCart(Cart newCart);

	Cart showCartById(Long cartId) throws CartNotFoundException;

	List<Cart> showAllCarts();



	Cart updateCartById(Long cartId, Cart cart) throws CartNotFoundException;

	void deleteCartById(Long prodId) throws CartNotFoundException;

	ResponseEntity<List<Cart>> getAllCartsByprodId(String prodId); //throws ProductNotFoundException;



	ResponseEntity<Cart> createCart(String prodId, Cart newCart) throws ProductNotFoundException;



	
}
