package edu.mum.waa.lab07.prob1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.waa.lab07.prob1.entities.Team;
import edu.mum.waa.lab07.prob1.services.TeamService;

@Controller()
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTeamGet(@ModelAttribute("team") Team team, @RequestParam(value="id", required=false) Integer id, Model model) {
		if (id != null) {
			model.addAttribute("team", service.get(id));
		}
		return "team/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTeam(@ModelAttribute("team") Team team) {
		System.out.println(team.getTeamKey());
		if (team.getTeamKey() != 0) {
			service.update(team.getTeamKey(), team);
		} else {
			service.add(team);
		}
		return "redirect:/team/list";
	}

	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("team/list");
		mv.getModel().put("teams", service.getAll());
		return mv;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="id", required=true) Integer id) {
		service.delete(id);
		return "redirect:/team/list";
	}
}
