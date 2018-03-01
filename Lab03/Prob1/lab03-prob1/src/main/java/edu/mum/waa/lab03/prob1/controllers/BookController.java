package edu.mum.waa.lab03.prob1.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.waa.lab03.prob1.daos.BookDao;
import edu.mum.waa.lab03.prob1.entities.Book;

@Controller
public class BookController {

	@Resource
	private BookDao bookDao;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books")
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public String get(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetail";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	public String update(@PathVariable("id") int id, Book book) {
		bookDao.update(id, book);
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {
		bookDao.delete(id);
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String add(Book book) {
		bookDao.add(book);
		return "redirect:/books";
	}
	
}
