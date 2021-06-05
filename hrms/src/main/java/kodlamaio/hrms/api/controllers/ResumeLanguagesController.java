package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/resume-languages")

public class ResumeLanguagesController {

	private ResumeLanguageService resumeLanguageService;

	@Autowired
	public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
		super();
		this.resumeLanguageService = resumeLanguageService;
	}

	
	@GetMapping("/getAll")
	public DataResult<List<ResumeLanguage>> getAll(){
		
		return this.resumeLanguageService.getAll();
		
	}
			@PostMapping("/add")
			public Result add(@RequestBody ResumeLanguage resumeLanguage) {
				
				return this.resumeLanguageService.add(resumeLanguage);
				
	}
}
