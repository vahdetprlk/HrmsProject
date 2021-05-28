package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployeeValidation;

@RestController
@RequestMapping("/api/systemEmployeeValidations")
public class SystemEmployeeValidationsController {
	private SystemEmployeeValidationService systemEmployeeValidationService;

	@Autowired
	public SystemEmployeeValidationsController(SystemEmployeeValidationService systemEmployeeValidationService) {
		super();
		this.systemEmployeeValidationService = systemEmployeeValidationService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemEmployeeValidation>> getAll() {
		
		
		return this.systemEmployeeValidationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployeeValidation systemEmployeeValidation) {
		
		return this.systemEmployeeValidationService.add(systemEmployeeValidation);
	}
	
	
}
