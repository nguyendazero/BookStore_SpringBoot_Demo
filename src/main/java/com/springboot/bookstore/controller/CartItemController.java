package com.springboot.bookstore.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.entity.CartItem;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CartItemService;
import com.springboot.bookstore.service.CartService;
import com.springboot.bookstore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartItemController {
	
	@Autowired
    private HttpSession session;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
    private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/cartItems/{id}")
	public String viewCartItems(@PathVariable("id") int userId, Model model) {
	    Cart cart = cartService.getCartByUser(userId);
	    List<CartItem> cartItems = cart.getCartItems();
	    model.addAttribute("cartItems", cartItems);
	        
	    double sum = 0;
	    for (CartItem cartItem : cartItems) {
			sum += cartItem.getQuantity() * cartItem.getProduct().getPriceSelling();
		}
	    model.addAttribute("sum", sum);
	    
	    return "cart";
	}

	@GetMapping("/add-to-cart/{productId}")
	public String addToCart(@PathVariable("productId") int productId, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin!=null) {
			List<CartItem> cartItems = cartItemService.getAllCartItemByCartId(userLogin.getId());
			for (CartItem cartItem : cartItems) {
				if(productId == cartItem.getProduct().getId()) {
					session.setAttribute("error", "Sản phẩm đã tồn tại trong giỏ hàng");
					return "redirect:/home";
				}
			}
			
			Product p = productService.getProductById(productId);
			Cart c = cartService.getCartByUser(userLogin.getId());
			CartItem cartItem = new CartItem(c, p, 1);
			cartItemService.saveCartItem(cartItem);
			return "redirect:/home";
		}else {
			session.setAttribute("error", "Bạn chưa đăng nhập");
			return "redirect:/home";
		}    
	}
	
	@GetMapping("/delete/{itemId}")
	public String DeleteCartItems(@PathVariable("itemId") int itemId, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		
		cartItemService.deleteCartItem(itemId);
		return "redirect:/cartItems/" + userLogin.getId();
	}
	
	@PostMapping("/updateQuantity/{itemId}")
    public String updateQuantity(@PathVariable("itemId") int itemId,
                                 @RequestParam("action") String action) {
        CartItem cartItem = cartItemService.getCartItemById(itemId);
        User userLogin = (User) session.getAttribute("userLogin");
        if (action.equals("increase")) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else if (action.equals("decrease")) {
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
            }
        }
        cartItemService.saveCartItem(cartItem);
        return "redirect:/cartItems/" + userLogin.getId();
    }
	
	
}
