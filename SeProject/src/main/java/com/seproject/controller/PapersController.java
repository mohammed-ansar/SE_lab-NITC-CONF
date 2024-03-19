package com.seproject.controller;

import java.util.List;

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

import com.seproject.entity.Paper;
import com.seproject.entity.Papers;
import com.seproject.entity.Reviewers;
import com.seproject.entity.User;
import com.seproject.service.PaperService;
import com.seproject.service.ReviewersService;
import com.seproject.service.UserService;



@Controller
public class PapersController {
	

	
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private ReviewersService reviewersService;
	

	@PutMapping("/addPapers")
	public Paper postDetails(@RequestBody Paper paper) {
		return paperService.saveDetails(paper);
	}
	
	
	
/*	@GetMapping("getPapers/{id}") 
	public Papers fetchDetailsById(@PathVariable int id) {
		return paperService.getPapersDetailsById(id);
	} */
	
    @GetMapping("/dashboard/getPapers/{id}") 
    public ModelAndView fetchDetailsByIdfromwebpage(@PathVariable int id) {
        Paper paper = paperService.getPaperDetailsById(id);

        ModelAndView modelAndView = new ModelAndView("paperDetails"); // Assuming "paperDetails" is the name of your HTML template
        modelAndView.addObject("paper", paper);

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
    
    @GetMapping("/About")
    public String about() {
    	return "About.html";
    }
	
/*	@PutMapping("updatePapers/{id}") 
	public Papers updatePapers(@PathVariable int id, @RequestBody Papers paper) {
		paper.setId(id);
		return paperService.updatePapers(paper);
	}	*/
	
	   @GetMapping("/searchPapers")
	    public String searchPapersPage() {
	        return "searchPaper";
	    }

	    @GetMapping("/dashboard/paperDetails")
	    public ModelAndView fetchDetailsByIdfromwebpage2(@RequestParam int id) {
	        Paper paper = paperService.getPaperDetailsById(id);

	        ModelAndView modelAndView = new ModelAndView("paperDetails");
	        modelAndView.addObject("paper", paper);

	        return modelAndView;
	    }
	    

	    @PostMapping("/dashboard/assignReviewer")
	    public ModelAndView assignReviewer(@RequestParam int paperId, @RequestParam String reviewerName) {
	        // Get the paper
	        Paper paper = paperService.getPaperDetailsById(paperId);

	        // Update paper details
	        paper.setReviewer(reviewerName);
	        paper.setState("assigned");
	        paperService.updatePaper(paper);

	        // Redirect back to paperDetails page
	        ModelAndView modelAndView = new ModelAndView("redirect:/dashboard/getPapers/" + paperId);
	        return modelAndView;
	    }




	    @PostMapping("/dashboard/updateDecision")
	    public ModelAndView updateDecision(@RequestParam int id, @RequestParam String decision) {
	        Paper paper = paperService.getPaperDetailsById(id);

	        // Update the decision and decision state based on user action
	        if (decision.equals("accepted")) {
	            paper.setDecision("accepted");
	            paper.setDecision_state("decided");
	        } else if (decision.equals("rejected")) {
	            paper.setDecision("rejected");
	            paper.setDecision_state("decided");
	        }

	        // Save the updated paper
	        paperService.updatePaper(paper);

	        // Redirect back to paperDetails page
	        ModelAndView modelAndView = new ModelAndView("redirect:/dashboard/getPapers/" + id);
	        return modelAndView;
	    }
	    
	    @PostMapping("/dashboard/assignReview")
	    public String assignReview(@RequestParam int id, @RequestParam String review) {
	        Paper paper = paperService.getPaperDetailsById(id);

	        // Update the review
	        paper.setReview(review);
	        paperService.updatePaper(paper);

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

	    @GetMapping("/getAllPapers")
	    public String getAllPapers(Model model) {
	        // Retrieve all papers from the service
	        List<Paper> paperList = paperService.getAllPapers();
	        
	        // Add papersList to the model
	        model.addAttribute("paperList", paperList);
	        
	        // Return the view name (all.html)
	        return "all";
	    }
	    
	    @GetMapping("/getAllReviewers")
	    public String getAllReviewers(Model model) {
	        // Retrieve all papers from the service
	        List<Reviewers> reviewersList = reviewersService.getAllReviewers();
	        
	        // Add papersList to the model
	        model.addAttribute("reviewersList", reviewersList);
	        
	        // Return the view name (all.html)
	        return "Reviewers";
	    }

}
