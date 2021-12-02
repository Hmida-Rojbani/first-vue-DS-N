package de.tekup.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.models.User;
import de.tekup.vue.models.UserDB;
import de.tekup.vue.models.WelcomeMsg;

@Controller
public class IndexCtrl {
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		WelcomeMsg welcomeMsg = new WelcomeMsg("Hello DSEN-N", "Welcome to Spring");
		model.addAttribute("obj", welcomeMsg);
		return "index";
	}
	
	@GetMapping("/show/users")
	public String getShowUsers(Model model) {
		model.addAttribute("listUsers", UserDB.getUsers());
		return "user/show-users";
	}
	
	@GetMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		UserDB.remove(id); 
		return "redirect:/show/users";
	}

	@GetMapping("/add/user")
	public String getAddUser(Model model) {
		model.addAttribute("user", new User());
		return "user/add-user";
	}
	
	@PostMapping("/add/user")
	public String postAddUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		UserDB.add(user);
		return "redirect:/show/users";
	}
	
	@GetMapping("/update/user/{id}")
	public String updateUser(@PathVariable("id") int id,Model model) {
		model.addAttribute("user", UserDB.get(id)); 
		return "user/add-user";
	}
}
