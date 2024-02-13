package com.seproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.seproject.entity.Papers;
import com.seproject.entity.User;
import com.seproject.service.PapersService;
import com.seproject.service.UserService;



@Controller
public class PapersController {
	
	@Autowired
	private PapersService paperService;
	

	@PutMapping("/addPapers")
	public Papers postDetails(@RequestBody Papers paper) {
		return paperService.saveDetails(paper);
	}
	
	
	
/*	@GetMapping("getPapers/{id}") 
	public Papers fetchDetailsById(@PathVariable int id) {
		return paperService.getPapersDetailsById(id);
	} */
	
    @GetMapping("/dashboard/getPapers/{id}") 
    public ModelAndView fetchDetailsByIdfromwebpage(@PathVariable int id) {
        Papers papers = paperService.getPapersDetailsById(id);

        ModelAndView modelAndView = new ModelAndView("paperDetails"); // Assuming "paperDetails" is the name of your HTML template
        modelAndView.addObject("papers", papers);

        return modelAndView;
    }
	
/*	@GetMapping("/getPapers/6") 
	public Papers fetchDetailsByIdfromwebpage(@PathVariable int id) {
		return paperService.getPapersDetailsById(id);
	} */
    
 
    
    @GetMapping("/dashboard")
    public String dashboard() {
    	return "Dashboard.html";
    }
	
	@GetMapping("updatePapers/{id}") 
	public Papers updatePapers(@PathVariable int id, @RequestBody Papers paper) {
		paper.setId(id);
		return paperService.updatePapers(paper);
	}
	
	   @GetMapping("/searchPapers")
	    public String searchPapersPage() {
	        return "searchPaper";
	    }

	    @GetMapping("/dashboard/paperDetails")
	    public ModelAndView fetchDetailsByIdfromwebpage2(@RequestParam int id) {
	        Papers papers = paperService.getPapersDetailsById(id);

	        ModelAndView modelAndView = new ModelAndView("paperDetails");
	        modelAndView.addObject("papers", papers);

	        return modelAndView;
	    }

	    @PostMapping("/dashboard/updateDecision")
	    public ModelAndView updateDecision(@RequestParam int id, @RequestParam String decision) {
	        Papers paper = paperService.getPapersDetailsById(id);

	        // Update the decision
	        paper.setDecision(decision);
	        paperService.updatePapers(paper);

	        // Redirect back to paperDetails page
	        ModelAndView modelAndView = new ModelAndView("redirect:/dashboard/getPapers/" + id);
	        return modelAndView;
	    }
	    
	    @PostMapping("/dashboard/assignReview")
	    public String assignReview(@RequestParam int id, @RequestParam String review) {
	        Papers paper = paperService.getPapersDetailsById(id);

	        // Update the review
	        paper.setReview(review);
	        paperService.updatePapers(paper);

	        // Redirect back to paperDetails page
	        return "redirect:/dashboard/getPapers/" + id;
	    }
	    
	    @RequestMapping("/home")
	    public String home() {
	    	return "SE_lab";
	    }
	    
	    
	    @GetMapping("/login")
	    public String login(@AuthenticationPrincipal UserDetails userDetails) {
	        if (userDetails == null) {
	            return "login";
	        } else {
	            return "redirect:/home";
	        }
	    }


	    
	    @GetMapping("/error")
	    public String handleError() {
	        // Provide a view name for error handling page
	        return "error";
	    }

	    public String getErrorPath() {
	        return "/error";
	    }
	    
	    @Autowired
	    private UserService userService;

	    @GetMapping("/registration")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User()); // Add an empty user to the model
	        return "registration"; // Assuming "registration" is the name of your registration HTML template
	    }

	   @PostMapping("/register")
	    public String registerUser(@ModelAttribute("user") User user) {
	        boolean registrationSuccess = userService.registerNewUser(user.getUsername(), user.getPassword());

	        if (registrationSuccess) {
	            return "redirect:/login"; // Redirect to the login page after successful registration
	        } else {
	            return "redirect:/registration?error"; // Redirect back to the registration page with an error parameter
	        }
	    }


}
