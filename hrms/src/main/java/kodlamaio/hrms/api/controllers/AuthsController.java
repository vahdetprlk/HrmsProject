package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthsController {
	
	private AuthService authService;
@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}

 @PostMapping("/register-jobseeker")
 
 public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker) {
	 
	 
	return this.authService.registerJobSeeker(jobSeeker);
	 
 }
 
 @PostMapping("/register-employer")
 
 public Result registerEmployer(@RequestBody Employer employer) {
	 
	 
	return this.authService.registerEmployer(employer);
	 
 }
 @PostMapping("/verify-user-by-email")
 	public Result verifyUserByEmail(@RequestParam("userId") int userId,@RequestParam("id") int id) {
		return this.authService.verifyUserByEmail(userId, id);
	 
 }
}
