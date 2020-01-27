package com.dspohn.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dspohn.demo.dao.AlienRepo;
import com.dspohn.demo.model.Alien;

@RestController  //To use the @RequestMapping methods change @RestController to @Controller (.stereotype.Controller) annotation.
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(Alien alien) {		
		repo.delete(alien);	
		return "home.jsp";
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(Integer alienID) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(alienID).orElse(new Alien());
		
		// Quick examples of some simple custom repository requests		
//		System.out.println(repo.findByTech("Extreme drama"));
//		System.out.println(repo.findByAlienIDGreaterThan(102));
//		System.out.println(repo.findByTechSorted("Improv"));
		
		mv.addObject(alien);
		return mv;
	}
	
	/*
	// Keeping old method for reference.
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	} */
	
	@GetMapping("/aliens")
	//@RequestMapping(path="/aliens",produces= {"applicaiton/xml"})
	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	/* 
	// Keeping old method for reference. 
	@RequestMapping("/alien/{alienID}")
	@ResponseBody
	public String getAlien(@PathVariable("alienID") int alienID) {
		return repo.findById(alienID).toString();
	}
	*/
	@GetMapping("/alien/{alienID}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("alienID") int alienID) {
		return repo.findById(alienID);
	}
	
	//@PostMapping(path="/alien", consumes={"application/json"}) // this limits to only accepting JSON formatted data
	@PostMapping("/alien")
	public Alien addAlien2(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PutMapping(path="/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("alien/{alienID}")
	public String deleteAlien(@PathVariable int alienID) {
		Alien alien = repo.getOne(alienID);
		repo.delete(alien);
		return "Deleted";
	}
	
	
}
