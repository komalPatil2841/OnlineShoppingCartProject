package com.mouritech.onlineshoppingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlineshoppingsystem.entity.Cart;
import com.mouritech.onlineshoppingsystem.exception.CartNotFoundException;
import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;
import com.mouritech.onlineshoppingsystem.repository.CartRepository;
import com.mouritech.onlineshoppingsystem.service.CartService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController// (@Controller + @ResponseBody)
@RequestMapping("api/v1")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepository cartRepo;
	
	
    @PostMapping("Cart")	
	public Cart insertCart(@RequestBody Cart newCart) {
		
		return cartService.insertCart(newCart);
		
	}
	
	@GetMapping("Cart")
	public List<Cart> showAllCarts(){
		return cartService.showAllCarts();
		
	}
	
	@GetMapping("Cart/{cid}")
	
  
	public Cart showCartById(@PathVariable("cid") Long CartId) throws CartNotFoundException{
		return cartService.showCartById(CartId);
		
	}
	
	@PutMapping("Cart/{cid}")
	public Cart updateCartById(@PathVariable("cid") Long CartId,@RequestBody Cart Cart) throws CartNotFoundException{
		return cartService.updateCartById(CartId,Cart);
		
	}
	
	@DeleteMapping("Cart/{cid}")
	public String deleteCartById(@PathVariable("cid") Long CartId) throws CartNotFoundException{
		 cartService.deleteCartById(CartId);
		 return "deleted the Cart";
		
	}
	

	@GetMapping("/Carts/{productid}")
	public ResponseEntity<List<Cart>> getAllCartsBySellerId(@PathVariable("productid") String prodId) throws ProductNotFoundException {
		return cartService. getAllCartsByprodId(prodId);
	}
	
	@PostMapping("/Carts/{produtid}/product")
	public ResponseEntity<Cart> createCart(@PathVariable("produtid") String prodId,
			@RequestBody Cart newCart) throws ProductNotFoundException {
		return cartService.createCart(prodId,newCart);
		
	}

	
	
	
}
