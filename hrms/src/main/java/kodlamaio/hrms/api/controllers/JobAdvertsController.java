package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/job-adverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){
		
		
		return this.jobAdvertService.getAllByActiveTrue();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		
	return this.jobAdvertService.add(jobAdvert);

	}
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.delete(jobAdvert);
		
	}
	
	@GetMapping("/getAllByActiveTrueAndSortedByCreatedDateDescDate")
	public DataResult<List<JobAdvert>> getAllByActiveTrueAndSortedByCreatedDate(){
		
		
		return this.jobAdvertService.getAllByActiveTrueAndSortedByCreatedDate();
		
	}
	
	
	@GetMapping("/getAllByEmployerIdAndActive")
	public DataResult<List<JobAdvert>> getAllByEmployerIdAndActive(@RequestParam("id") int id,@RequestParam("isActive")boolean isActive){
		
		
		return this.jobAdvertService.getAllByEmployerIdAndActive(id, isActive);
		
	}
	

}


