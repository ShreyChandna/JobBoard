package com.job.board.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.board.dao.HomeRepository;
import com.job.board.dao.UserRepository;
import com.job.board.entities.JobDetails;
import com.job.board.entities.Users;
import com.job.board.helper.Message;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.time.temporal.ChronoUnit;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private HomeRepository homeRepository;
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/")
	public String home()
	{
		return "Banner";
	}
	
	@RequestMapping("/addJobs")
	public String addJobs(Model model)
	{	model.addAttribute("add",new JobDetails());
		return "add-jobs";
	}
	@RequestMapping(value="/process_jobs",method=RequestMethod.POST)
	public String processJobs(@ModelAttribute("add") JobDetails addJobs,Model model,HttpSession session,Principal principal)
	{
		try {
		String username=principal.getName();
		Users user=userRepository.getUsersByuserName(username);
		addJobs.setUser(user);
		
		
		// No of days left for applying 
		
		String today= java.time.LocalDate.now().toString();
	    LocalDate dateBefore = LocalDate.parse(today);
		LocalDate dateAfter = LocalDate.parse(addJobs.getDeadline());
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		addJobs.setDaysleft(noOfDaysBetween);
		
		
		
		user.getJobdetails().add(addJobs);
		this.userRepository.save(user);
		model.addAttribute("add", new JobDetails());
		session.setAttribute("message",new Message("Job posted successfully","alert-success"));
		return "add-jobs";
		}
		catch(Exception e){
			model.addAttribute("add", new JobDetails());

			session.setAttribute("message", new Message("Something went Wrong.Try Again!"+e.getMessage(),"alert-danger"));
			return "add-jobs";
		}
	}
	@RequestMapping("/showjobs")
	public String showJobs(Model model)
	{
		List<JobDetails> jobDetails=this.homeRepository.findAll();
		model.addAttribute("show",jobDetails);
		System.out.print(jobDetails);
		
		return "show-jobs";
	}
	@RequestMapping("/postedjobs")
	public String postedJobs(Model model,Principal principal)
	{
		String username=principal.getName();
		Users user=userRepository.getUsersByuserName(username);
		List<JobDetails> jobDetails=this.homeRepository.findJobDetailsByUser(username);
		model.addAttribute("show", jobDetails);
		return "posted-jobs";
	}
	@GetMapping("/delete/{jobid}")
	 public String deleteJob(@PathVariable("jobid") Integer jobid,Model model,HttpSession session,Principal principal)
	 {
		 JobDetails jobDetails=this.homeRepository.getJobDetailsByJobId(jobid);
		 this.homeRepository.delete(jobDetails);
		 session.setAttribute("message", new Message("Successfully Deleted !!", "alert-success"));
		 return "redirect:/user/postedjobs";
	 }
//	@RequestMapping("/interested/{jobid}")
//	public String intersted(@PathVariable("jobid") Integer jobid,Model model,HttpSession session,Principal principal)
//	{	
//		 String username=principal.getName();
//		 Users user2=userRepository.getUsersByuserName(username); 
//		 JobDetails jobDetails=this.homeRepository.getJobDetailsByJobId(jobid);
//		 Users user=jobDetails.getUser();
//		 
//		 
//		 return "redirect:/user/postedjobs";
//	}
}
