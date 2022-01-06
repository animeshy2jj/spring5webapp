package com.anii.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anii.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/authors")
	public String getAuthor(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}
}
