package com.springboot.bookstore.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bookstore.entity.Author;
import com.springboot.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/manager-authors")
	public String getAllAuthors(Model model) {
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);
		return "manager_authors";
	}
	
	@PostMapping("/authors/add")
	public String addAuthors(@RequestParam("name") String name,
	                         @RequestParam("home-town") String homeTown,
	                         @RequestParam("date") Date date,
	                         @RequestParam("story") String story,
	                         @RequestParam("img") String img) {

	    Author a = new Author(name, homeTown, date, story, img);
	    authorService.saveAuthor(a);
	    
	    return "redirect:/manager-authors";
	}
	
	@GetMapping("/authors/delete/{id}")
	public String deleteAuthor(@RequestParam("authorId") int authorId) {
		authorService.deleteAuthor(authorId);
		return "redirect:/manager-authors";
	}

	
	@GetMapping("/edit-authors/{id}")
	public String formEditAuthor(@RequestParam("id") int id, Model model) {
		Author author = authorService.getAuthorById(id);
	    model.addAttribute("author", author);
	    return "edit_authors";
	}
	
	@PostMapping("/authors/edit/{id}")
	public String editAuthor(@RequestParam("authorId") int authorId,
							@RequestParam("fullName") String fullName,
							@RequestParam("homeTown") String homeTown,
							@RequestParam("date") Date date,
							@RequestParam("img") String img,
							@RequestParam("story") String story){
		Author a = new Author(authorId, fullName, homeTown, date, story, img);
		authorService.updateAuthor(a);
		return "redirect:/manager-authors";
	}

}
