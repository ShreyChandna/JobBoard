package com.job.board.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.board.dao.UserRepository;
import com.job.board.entities.JobDetails;
import com.job.board.entities.Users;
import com.job.board.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{	model.addAttribute("user", new Users());
		return "signup";
	}
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") Users user,Model model,HttpSession session)
	{	
		try{
		System.out.print("user"+user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		Users result=this.userRepository.save(user);
		model.addAttribute("user", new Users());
		session.setAttribute("message",new Message("Successfully Registered","alert-success"));
		return "signup";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("user", new Users());

			session.setAttribute("message", new Message("Something went Wrong.Try Again!","alert-danger"));
			return "signup";
		}
		
		
		
		
	}
	
	@RequestMapping("/signin")
	public String customLogin(Model model)
	
	{
	return "login";	
	}
	
	
	
}
