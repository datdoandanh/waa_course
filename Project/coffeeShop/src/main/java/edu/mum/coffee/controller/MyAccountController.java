package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.config.SessionListener;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.UserService;

@Controller
@RequestMapping("/me/")
public class MyAccountController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionListener sessionListener;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping({"order"})
	public String order(Model model) {
		Person person = sessionListener.getPerson();
		model.addAttribute("historicalOrder",orderService.findByPerson(person));
		return "myaccount/order";
	}

	// Update Account
	@GetMapping({"/account/update"})
	public String account(Model model) {
		Person updatedPerson = personService.findById(sessionListener.getPerson().getId());
		User user = userService.findByEmail(updatedPerson.getEmail());
		if (user.getRoles().size() == 1) {
			updatedPerson.setRole(user.getRoles().get(0).getId());
		}
		model.addAttribute("user", updatedPerson);
		return "myaccount/account";
	}
	
	@PostMapping("/acoount/update")
	public String updateAccount(Model model, @ModelAttribute("user")  Person person) {
		User user = userService.findByEmail(person.getEmail());
		if (person.getPassword() != null && !person.getPassword().isEmpty()) {
			person.setPassword(encoder.encode(person.getPassword()));
		} else {
			person.setPassword(user.getPassword());
		}
		personService.savePerson(person);
		return "redirect:/";
	}
	
	// Sign up
	@GetMapping({"/account/signup"})
	public String signUp(Model model, @ModelAttribute("user")  Person person) {
		// set the default role for a new user
		person.setRole(2);
		person.setEnable(true);
		return "myaccount/signup";
	}
	
	@PostMapping("/account/signup")
	public String createNewAccount(Model model, @ModelAttribute("user")  Person person) {
		String view = "myaccount/signup";
		User user = userService.findByEmail(person.getEmail());
		if (user != null) {
			model.addAttribute("errorMsg", "This email already exists. Please use another email.");
			return view;
		}
		if (person.getPassword() != null && !person.getPassword().isEmpty()) {
			person.setPassword(encoder.encode(person.getPassword()));
		}
		personService.savePerson(person);
		model.addAttribute("infoMsg", "Your new account has been created sucessfully. Click here to login");
		return view;
	}
	
}
