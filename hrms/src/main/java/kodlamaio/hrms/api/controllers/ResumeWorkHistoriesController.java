package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeWorkHistoryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeWorkHistory;

@RestController
@RequestMapping("/api/resume-work-histories")
public class ResumeWorkHistoriesController {
	
	private ResumeWorkHistoryService  resumeWorkHistoryService;
	@Autowired
	public ResumeWorkHistoriesController(ResumeWorkHistoryService resumeWorkHistoryService) {
		super();
		this.resumeWorkHistoryService = resumeWorkHistoryService;
	}
	
	
	@GetMapping("/getAll")
	
	public DataResult<List<ResumeWorkHistory>> getAll(){
		
		return this.resumeWorkHistoryService.getAll();
	}
	
	@GetMapping("/findAllByResumeJobSeekerUserIdOrderByExperienceEndDate")
	
	public DataResult<List<ResumeWorkHistory>> findAllByResume_JobSeeker_UserIdOrderByGraduationEndDateDesc(@RequestParam int userId){
		
		return this.resumeWorkHistoryService.findAllByResume_JobSeeker_UserIdOrderByExperienceEndDateDesc(userId);
		
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody ResumeWorkHistory resumeWorkHistory) {
		
		return this.resumeWorkHistoryService.add(resumeWorkHistory);
	}
}
