package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeJobAdvertValidationService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployeeJobAdvertValidation;


@RestController
@RequestMapping("/api/systemEmployeeJobAdvertValidations")
public class SystemEmployeeJobAdvertValidationsController {
	private SystemEmployeeJobAdvertValidationService systemEmployeeJobAdvertValidationService;

	@Autowired
	public SystemEmployeeJobAdvertValidationsController(SystemEmployeeJobAdvertValidationService systemEmployeeJobAdvertValidationService) {
		super();
		this.systemEmployeeJobAdvertValidationService = systemEmployeeJobAdvertValidationService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemEmployeeJobAdvertValidation>> getAll() {
		
		
		return this.systemEmployeeJobAdvertValidationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployeeJobAdvertValidation systemEmployeeJobAdvertValidation) {
		
		return this.systemEmployeeJobAdvertValidationService.add(systemEmployeeJobAdvertValidation);
	}
	
	
}
