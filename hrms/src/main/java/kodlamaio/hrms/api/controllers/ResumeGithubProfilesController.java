package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeGithubProfileService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeGithubProfile;

@RestController
@RequestMapping("/api/resume-github-profiles")

public class ResumeGithubProfilesController {

	private ResumeGithubProfileService resumeGithubProfileService;

	@Autowired
	public ResumeGithubProfilesController(ResumeGithubProfileService resumeGithubProfileService) {
		super();
		this.resumeGithubProfileService = resumeGithubProfileService;
	}

	
	@GetMapping("/getAll")
	public DataResult<List<ResumeGithubProfile>> getAll(){
		
		return this.resumeGithubProfileService.getAll();
		
	}
			@PostMapping("/add")
			public Result add(@RequestBody ResumeGithubProfile resumeGithubProfile) {
				
				return this.resumeGithubProfileService.add(resumeGithubProfile);
				
	}
}
