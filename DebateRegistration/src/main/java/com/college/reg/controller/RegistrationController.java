package com.college.reg.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.college.reg.entity.Participant;
import com.college.reg.service.DebateRegistration;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	DebateRegistration registration;

	@RequestMapping("/list")
	public String findAll(Model theModel) {
		List<Participant> participants = registration.findAll();
		theModel.addAttribute("Participants", participants);
		return "list-Participants";
	}

	@RequestMapping("/addNewParticipant")
	public String addNewParticipant(Model theModel) {
		Participant student = new Participant();
		theModel.addAttribute("Participant", student);
		return "Participant-form";
	}

	@RequestMapping("/updateParticipant")
	public String updateParticipant(@RequestParam("participantId") int theId, Model theModel) {
		Participant student = registration.findById(theId);
		theModel.addAttribute("Participant", student);
		return "Participant-form";
	}

	@PostMapping("/save")
	public String saveParticipant(@RequestParam("id") String sid, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		int id;
		if (sid.length() == 0)
			id = 0;
		else
			id = Integer.parseInt(sid);

		Participant student;
		if (id != 0) {
			student = registration.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new Participant(name, department, country);
		// save new participant
		registration.save(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/registration/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("participantId") int theId) {
		registration.deleteParticipantById(theId);
		return "redirect:/registration/list";
	}

	@RequestMapping("/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}
}
