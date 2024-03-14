package com.springboot.bookstore.service;


import com.springboot.bookstore.entity.Cart;

public interface CartService {

	Cart saveCart(Cart Cart);
	
	Cart getCartByUser(int id_user);
	
	Cart updateCart(Cart Cart);
	
	void deleteCart(int id);
	
}
