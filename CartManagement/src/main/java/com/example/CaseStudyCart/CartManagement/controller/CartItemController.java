package com.example.CaseStudyCart.CartManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CaseStudyCart.CartManagement.Entity.CartItem;
import com.example.CaseStudyCart.CartManagement.dao.CartItemDAO;



@RestController
@RequestMapping("/api")
public class CartItemController {
	
	
	private CartItemDAO cartitemdao;
	
	public CartItemController(CartItemDAO theCartItemDAO) {  //Asking spring framework to create a new object for us(inversion of control)
		this.cartitemdao=theCartItemDAO;
	}
	@GetMapping("cartitems")
	public List<CartItem> findAllCartItems() {
		List<CartItem> cartitems=cartitemdao.findAll();
		return cartitems;
		
//		return "cart";
	}
	
	@GetMapping("/cartitems/{cartItemId}")
	public CartItem getCartItem(@PathVariable int cartItemId) {
		CartItem cart = cartitemdao.getCartItem(cartItemId);
		if(cart == null)
		{
			throw new CartNotFoundException("ID does not exist.... " + cartItemId);
		}
		return cart;
	}
	
	@PostMapping("/cartitems")
	public CartItem addCartItem(@RequestBody CartItem theCartItem) {
		
		CartItem cartitem=cartitemdao.addTheCartItem(theCartItem);
		return cartitem;
	}
	
	@PutMapping("/cartitems")
	public CartItem updateCartItem(@RequestBody CartItem theCartItem) {
		
		CartItem cartitem=cartitemdao.updateTheCartItem(theCartItem);
		return cartitem;
	}
	
	@DeleteMapping("/cartitems/{cartItemId}")
	public void deleteCartItem(@PathVariable int cartItemId) {
		
		cartitemdao.deleteTheCartItem(cartItemId);
		
	}
}
