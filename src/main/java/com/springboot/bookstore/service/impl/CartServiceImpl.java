package com.springboot.bookstore.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.repository.CartRepository;
import com.springboot.bookstore.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	private CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart saveCart(Cart Cart) {
		return cartRepository.save(Cart);
	}

	@Override
	public Cart getCartByUser(int id_user) {
		return cartRepository.findByUserId(id_user);
	}

	@Override
	public Cart updateCart(Cart Cart) {
		return cartRepository.save(Cart);
	}

	@Override
	public void deleteCart(int id) {
		cartRepository.deleteById(id);
		
	}
	
	
	
}
