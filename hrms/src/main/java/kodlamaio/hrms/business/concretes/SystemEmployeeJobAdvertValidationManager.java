package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeJobAdvertValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeJobAdvertValidationDao;
import kodlamaio.hrms.entities.concretes.SystemEmployeeJobAdvertValidation;
@Service
public class SystemEmployeeJobAdvertValidationManager implements SystemEmployeeJobAdvertValidationService{

		private SystemEmployeeJobAdvertValidationDao systemEmployeeJobAdvertValidationDao;
		
		@Autowired
	public SystemEmployeeJobAdvertValidationManager(
				SystemEmployeeJobAdvertValidationDao systemEmployeeJobAdvertValidationDao) {
			super();
			this.systemEmployeeJobAdvertValidationDao = systemEmployeeJobAdvertValidationDao;
		}

	@Override
	public DataResult<List<SystemEmployeeJobAdvertValidation>> getAll() {
		
		return new SuccessDataResult<List<SystemEmployeeJobAdvertValidation>>(this.systemEmployeeJobAdvertValidationDao.findAll(), "DataListelendi");
	}

	@Override
	public Result add(SystemEmployeeJobAdvertValidation systemEmployeeJobAdvertValidation) {

		this.systemEmployeeJobAdvertValidationDao.save(systemEmployeeJobAdvertValidation);
		
		return new SuccessResult("Eklendi");
	}

}
