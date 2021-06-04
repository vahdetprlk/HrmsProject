package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;


import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;

	
	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getByIsActive")
	
	public DataResult<List<Resume>> getByIsActive(){
		return this.resumeService.getByIsActive(true);
		
	}
	
	@GetMapping("/getByJobSeekerIdAndActiveTrue")
	
	public DataResult<List<Resume>> getByJobSeekerIdAndIsActive(@RequestParam("userId") int userId , @RequestParam("isActive") boolean isActive){
		
		return this.resumeService.getByJobSeeker_IdAndIsActive(userId, isActive);


}
}


