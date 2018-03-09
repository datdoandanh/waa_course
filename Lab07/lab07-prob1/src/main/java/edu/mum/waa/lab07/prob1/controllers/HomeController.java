package edu.mum.waa.lab07.prob1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.waa.lab07.prob1.entities.Player;

@Controller
@SessionAttributes(value= {"abc"})
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model, ModelMap map) {
		Player player = new Player();
		player.setName("Danh Dat Doan");
		player.setNum(1);
		model.addAttribute("player", player);
		return "index";
	}
	
}
