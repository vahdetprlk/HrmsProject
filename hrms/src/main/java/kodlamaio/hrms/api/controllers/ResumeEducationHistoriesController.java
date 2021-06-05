package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeEducationHistoryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeEducationHistory;

@RestController
@RequestMapping("/api/resume-education-histories")
public class ResumeEducationHistoriesController {
	
	private ResumeEducationHistoryService  resumeEducationHistoryService;
	@Autowired
	public ResumeEducationHistoriesController(ResumeEducationHistoryService resumeEducationHistoryService) {
		super();
		this.resumeEducationHistoryService = resumeEducationHistoryService;
	}
	
	
	@GetMapping("/getAll")
	
	public DataResult<List<ResumeEducationHistory>> getAll(){
		
		return this.resumeEducationHistoryService.getAll();
	}
	
	@GetMapping("/findAllByResumeJobSeekerUserIdOrderByGraduationEndDate")
	
	public DataResult<List<ResumeEducationHistory>> findAllByResume_JobSeeker_UserIdOrderByGraduationEndDate(@RequestParam int userId){
		
		return this.resumeEducationHistoryService.findAllByResume_JobSeeker_UserIdOrderByGraduationEndDate(userId);
		
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody ResumeEducationHistory resumeEducationHistory) {
		
		return this.resumeEducationHistoryService.add(resumeEducationHistory);
	}
}
