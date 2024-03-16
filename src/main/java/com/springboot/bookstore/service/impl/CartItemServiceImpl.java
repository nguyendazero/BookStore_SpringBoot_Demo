package com.springboot.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.CartItem;
import com.springboot.bookstore.repository.CartItemRepository;
import com.springboot.bookstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	private CartItemRepository cartItemRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository) {
		super();
		this.cartItemRepository = cartItemRepository;
	}

	@Override
    public List<CartItem> getAllCartItemByCartId(int id_cart) {
        return cartItemRepository.findAllByCartId(id_cart);
    }

	@Override
	public CartItem saveCartItem(CartItem cart_item) {
		return cartItemRepository.save(cart_item);
	}

	@Override
	public void deleteCartItem(int id) {
		cartItemRepository.deleteById(id);;
	}
	
	
	
}
