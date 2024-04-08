package com.springboot.bookstore.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bookstore.entity.CartItem;
import com.springboot.bookstore.entity.OrderDetail;
import com.springboot.bookstore.entity.OrderEntity;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CartItemService;
import com.springboot.bookstore.service.OrderDetailService;
import com.springboot.bookstore.service.OrderEntityService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderEntityController {

	@Autowired
	private OrderEntityService orderEntityService;
	@Autowired
	private HttpSession session;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/checkout")
	public String checkout(@RequestParam("sum") double sum, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin!=null) {
//			Random random = new Random();
//	        int randomNumber = random.nextInt(5000) + 1;
	        
			long millis=System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis); 

			OrderEntity o = new OrderEntity(userLogin, sum,date);
			o = orderEntityService.saveOrderEntity(o);
			
	        
	        cartItemService.removeAllCartItemsByIdCart(userLogin.getId());
	        return "redirect:/orders/" + userLogin.getId();
		}else {
			model.addAttribute("error", "Bạn chưa đăng nhập");
			return "cart";
		}
		
	}
	
	@GetMapping("/orders/{id}")
	public String viewOrders(@PathVariable("id") int id, Model model) {
		List<OrderEntity> o = orderEntityService.getAllOrderEntityByUserId(id);
		model.addAttribute("orders", o);
		return "orders";
	}
	
	@GetMapping("/order/delete/{orderId}")
	public String deleteOrder(@PathVariable("orderId") int orderId) {
		User userLogin = (User) session.getAttribute("userLogin");
		orderEntityService.deleteOrderEntity(orderId);
		return "redirect:/orders/"+userLogin.getId();
	}
	
}
