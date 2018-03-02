package edu.mum.waa.lab04.prob2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.waa.lab04.prob2.daos.BookDao;
import edu.mum.waa.lab04.prob2.entities.Book;

@Controller
public class BookController {

	@Autowired
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
	public String update(@PathVariable("id") int id, @Valid Book book, BindingResult result) {
		String view = "redirect:/books";
//		if (!result.hasErrors()) {
//			bookDao.update(id, book);
//		} else {
//			return "redirect:/books/" + id;
//		}
		bookDao.update(id, book);
		
		return view;
	}
	
	@RequestMapping(value="/books/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {
		bookDao.delete(id);
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/addBook", method=RequestMethod.GET)
	public String add(@ModelAttribute("book") Book book) {
		return "addBook";
	}
		
	@RequestMapping(value="/books/addBook", method=RequestMethod.POST)
	public String addBook(@Valid Book book, BindingResult result) {
		String view = "redirect:/books";
		if (!result.hasErrors()) {
			bookDao.add(book);
		} else {
			view = "addBook";
		}
		
		return view;
	}
	
}
