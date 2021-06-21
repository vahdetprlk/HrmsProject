package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployeeJobAdvertValidation;

public interface SystemEmployeeJobAdvertValidationService {
	
	DataResult<List<SystemEmployeeJobAdvertValidation>> getAll();

	Result add(SystemEmployeeJobAdvertValidation systemEmployeeJobAdvertValidation);
}
