package com.springboot.bookstore.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CartService;
import com.springboot.bookstore.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
    private HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
	    User user = userService.getUserByUsernameAndPass(username, password);
	    if (user != null) {
	    	if(user.getRole() != 1) {
	    		session.setAttribute("userLogin", user);
		        return "redirect:/home"; 
	    	}else {
	    		session.setAttribute("userLogin", user);
	    		return "redirect:/home-admin"; 
	    	} 
	    } else {
	        model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng!");
	        return "login";
	    }
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String checkRegister(@RequestParam("username") String username,
			@RequestParam("repassword") String repassword,
            @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam("date_of_birth") Date dateOfBirth,
            @RequestParam("gender") String gender,
            @RequestParam("email") String email,
            @RequestParam("full_name") String fullName,
            @RequestParam("telephone") String telephone, Model model) {
		
		
		if(!password.equalsIgnoreCase(repassword)) {
			model.addAttribute("error", "mật khẩu nhập lại không khớp");
			return "register";
		}
		List<User> users = userService.getAllUsers();
		boolean tonTai = false;
		for (User user : users) {
			if(username.equalsIgnoreCase(user.getUserName())) {
				model.addAttribute("error", "tên đăng nhập đã tồn tại");
				tonTai = true;
				return "register";
			}
		}
		if(tonTai != true) {
			User newUser = new User(username, password, fullName, gender, address, dateOfBirth, telephone, email, 0);
			userService.saveUser(newUser);
			Cart c = new Cart(newUser);
			cartService.saveCart(c);
			model.addAttribute("error", "đã đăng ký thành công, hãy đăng nhập");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.removeAttribute("userLogin");
		return "redirect:/home";
	}
	
	@GetMapping("/repass/{id}")
	public String rePass() {
		return "re_pass";
	}
	
	@PostMapping("/change-password")
	public String changePass(@RequestParam("password") String password,
							@RequestParam("newPassword") String newPassword,
							@RequestParam("confirmPassword") String confirmPassword,
							Model model) {
		User user = (User) session.getAttribute("userLogin");
		if(user.getPassword().equalsIgnoreCase(password)) {
			if(newPassword.equalsIgnoreCase(confirmPassword)) {
				if(!user.getPassword().equalsIgnoreCase(newPassword)) {
					user.setPassword(newPassword);
					userService.updateUser(user);
					model.addAttribute("error", "đã đổi mật khẩu thành công");
				}else {
					model.addAttribute("error", "mật khẩu mới không được trùng với mật khẩu cũ!");
				}
			}else {
				model.addAttribute("error", "mật khẩu nhập lại không khớp!");
			}
		}else {
			model.addAttribute("error", "mật khẩu cũ chưa đúng!");
		}
		return "re_pass";
	}
	
	@GetMapping("/edit-infor/{id}")
	public String editInfor() {
		return "edit_infor";
	}
	
	@PostMapping("/update-user")
	public String UpdateUser(@RequestParam("fullName") String fullName,
							@RequestParam("gender") String gender,
							@RequestParam("address") String address,
							@RequestParam("dateOfBirth") Date dateOfBirth,
							@RequestParam("telephone") String telephone,
							@RequestParam("email") String email,
							Model model) {
		User user = (User) session.getAttribute("userLogin");
		user.setFullName(fullName);
		user.setGender(gender);
		user.setAddress(address);
		user.setDateOfBirth(dateOfBirth);
		user.setTelephone(telephone);
		user.setEmail(email);
		userService.updateUser(user);
		model.addAttribute("error", "thay đổi thông tin thành công");
		return "edit_infor";
	}
	
	@GetMapping("/manager-users")
	public String managerUsers(Model model) {
		List<User> users = userService.getAllUsers();
		String error = (String) session.getAttribute("error");
		session.setAttribute("error", null);
		model.addAttribute("error", error);
		model.addAttribute("users", users);
		return "manager_users";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@RequestParam("userId") int userId, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin.getUserName().equals("admin")) {
			if(userLogin.getId() == userId) {
				session.setAttribute("error", "Bạn không thể xóa tài khoản này");
				return "redirect:/manager-users";
			}
			userService.deleteUser(userId);
		}else {
			session.setAttribute("error", "Bạn không được cấp quyền này");
		}
		return "redirect:/manager-users";
	}
	
	@GetMapping("/users/grant-administrative-rights/{id}")
	public String grantAdministrativeRights(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		user.setRole(1);
		userService.updateUser(user);
		return "redirect:/manager-users";
	}
	
	@GetMapping("/users/cancel-administrative-rights/{id}")
	public String cancelAdminRights(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		user.setRole(0);
		userService.updateUser(user);
		return "redirect:/manager-users";
	}
}
