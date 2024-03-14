package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.CartItem;

public interface CartItemService {

	List<CartItem> getAllCartItemByCartId(int id_cart);
	
	CartItem saveCartItem(CartItem cart_item);
	
	void deleteCartItem(int id);

}
