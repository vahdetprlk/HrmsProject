package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeSummaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeSummary;

@RestController
@RequestMapping("/api/resume-summaries")

public class ResumeSummariesController {

	private ResumeSummaryService resumeSummaryService;

	@Autowired
	public ResumeSummariesController(ResumeSummaryService resumeSummaryService) {
		super();
		this.resumeSummaryService = resumeSummaryService;
	}

	
	@GetMapping("/getAll")
	public DataResult<List<ResumeSummary>> getAll(){
		
		return this.resumeSummaryService.getAll();
		
	}
			@PostMapping("/add")
			public Result add(@RequestBody ResumeSummary resumeSummary) {
				
				return this.resumeSummaryService.add(resumeSummary);
				
	}
}
