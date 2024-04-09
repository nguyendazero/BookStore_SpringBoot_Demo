package com.springboot.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.bookstore.entity.CartItem;
import com.springboot.bookstore.entity.OrderDetail;
import com.springboot.bookstore.entity.OrderEntity;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CartItemService;
import com.springboot.bookstore.service.OrderDetailService;
import com.springboot.bookstore.service.OrderEntityService;
import com.springboot.bookstore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private HttpSession session;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private OrderEntityService orderEntityService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/add-order-detail")
	public String addOrderDetail(Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		int random = (int) session.getAttribute("randomNumber");
		
		boolean check = false;
		List<Product> products = new ArrayList<>();
		
		List<CartItem> cartItems = cartItemService.getAllCartItemByCartId(userLogin.getId());
		for (CartItem cartItem : cartItems) {
			OrderDetail od = new OrderDetail(random, cartItem.getQuantity(), cartItem.getProduct().getProductName(), cartItem.getProduct().getCategory().getName(), cartItem.getProduct().getPriceSelling());
			orderDetailService.saveOrderDetail(od);
			Product p = cartItem.getProduct();
			p.setRemainQuantity(p.getRemainQuantity()-cartItem.getQuantity());
			productService.updateProduct(p);
			products.add(p);
			if(p.getRemainQuantity() < 0) {
				for (Product product : products) {
					product.setRemainQuantity(product.getRemainQuantity()+cartItem.getQuantity());
					orderEntityService.deleteOrderEntity(random);
					model.addAttribute("error", "không đủ số lượng sản phẩm "+product.getProductName()+ " trong kho");
					return "redirect:/cartItems/"+userLogin.getId();
				}
			}
			
		}
		
		
		cartItemService.removeAllCartItemsByIdCart(userLogin.getId());
		return "redirect:/orders/" + userLogin.getId();
	}
	
	@GetMapping("/order-detail/{id}")
	public String viewOrderDetail(@PathVariable("id") int id, Model model) {
		List<OrderDetail> od = orderDetailService.getAllOrderDetailById(id);
		OrderEntity order = orderEntityService.getOrderEntityById(id);
		model.addAttribute("order", order);
		model.addAttribute("od", od);
		return "order_detail";
	}
	
}
