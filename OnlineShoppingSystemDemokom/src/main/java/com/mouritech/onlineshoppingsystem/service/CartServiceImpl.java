package com.mouritech.onlineshoppingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlineshoppingsystem.entity.Cart;
import com.mouritech.onlineshoppingsystem.exception.CartNotFoundException;
import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;
import com.mouritech.onlineshoppingsystem.repository.CartRepository;
import com.mouritech.onlineshoppingsystem.repository.ProductRepository;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Cart insertCart(Cart newCart) {
		// TODO Auto-generated method stub
		return cartRepository.save(newCart);
	}

	@Override
	public Cart showCartById(Long cartId) throws CartNotFoundException {
		// TODO Auto-generated method stub
		return cartRepository.findByCartId(cartId).orElseThrow(
				() -> new CartNotFoundException("Cart not found with id " + cartId));
	}

	@Override
	public List<Cart> showAllCarts() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public Cart updateCartById(Long cartId, Cart cart) throws CartNotFoundException {
		// TODO Auto-generated method stub
		Cart existingCart = cartRepository.findByCartId(cartId).orElseThrow(() -> new CartNotFoundException("cart not found with id " + cartId));
		existingCart.setProduct(cart.getProduct());
		existingCart.setContent(cart.getContent());
		cartRepository.save(existingCart);
		return existingCart;
	}

	@Override
	public void deleteCartById(Long cartId) throws CartNotFoundException {
		Cart existingCart = cartRepository.findByCartId(cartId).orElseThrow(() -> new CartNotFoundException("cart not found with id " + cartId));
						cartRepository.delete(existingCart);
		
	}

//	@Override
//	public ResponseEntity<List<Cart>> getAllCartsByProductId(String prodId){
//	
//		
//		List<Cart> carts = cartRepository.findByProduct(prodId);
//		return new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
//	}

	@Override
	public ResponseEntity<Cart> createCart(String prodId, Cart newCart) throws ProductNotFoundException {
		Cart cart = productRepository.findByProdId(prodId).map(
				product ->{
					newCart.setProduct(product);
					
					return cartRepository.save(newCart);
				}).orElseThrow(()-> new ProductNotFoundException("Product not found with id = "  + prodId));
		return new ResponseEntity<Cart>(newCart,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Cart>> getAllCartsByprodId(String prodId) {
		List<Cart> carts = cartRepository.findByProduct(prodId);
		return new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
	}


	
}
