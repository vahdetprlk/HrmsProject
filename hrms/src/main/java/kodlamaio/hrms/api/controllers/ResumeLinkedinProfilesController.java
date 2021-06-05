package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLinkedinProfileService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLinkedinProfile;

@RestController
@RequestMapping("/api/resume-linkedin-profiles")

public class ResumeLinkedinProfilesController {

	private ResumeLinkedinProfileService resumeLinkedinProfileService;

	@Autowired
	public ResumeLinkedinProfilesController(ResumeLinkedinProfileService resumeLinkedinProfileService) {
		super();
		this.resumeLinkedinProfileService = resumeLinkedinProfileService;
	}

	
	@GetMapping("/getAll")
	public DataResult<List<ResumeLinkedinProfile>> getAll(){
		
		return this.resumeLinkedinProfileService.getAll();
		
	}
			@PostMapping("/add")
			public Result add(@RequestBody ResumeLinkedinProfile resumeLinkedinProfile) {
				
				return this.resumeLinkedinProfileService.add(resumeLinkedinProfile);
				
	}
}
