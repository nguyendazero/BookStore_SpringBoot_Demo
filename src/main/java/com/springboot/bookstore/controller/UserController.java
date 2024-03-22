package com.springboot.bookstore.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
    private HttpSession session;
	@Autowired
	private UserService userService;

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
	    User user = userService.getUserByUsernameAndPass(username, password);
	    if (user != null) {
	        session.setAttribute("userLogin", user);
	        return "redirect:/home"; 
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
            @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam("date_of_birth") Date dateOfBirth,
            @RequestParam("gender") String gender,
            @RequestParam("email") String email,
            @RequestParam("full_name") String fullName,
            @RequestParam("telephone") String telephone, Model model) {
		
		User newUser = new User(username, password, fullName, gender, address, dateOfBirth, telephone, email, 0);
		userService.saveUser(newUser);
		model.addAttribute("error", "đã đăng ký thành công, hãy đăng nhập");
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
}
