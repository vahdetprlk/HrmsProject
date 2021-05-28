package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeValidationDao;
import kodlamaio.hrms.entities.concretes.SystemEmployeeValidation;
@Service
public class SystemEmployeeValidationManager implements SystemEmployeeValidationService{
	
	private SystemEmployeeValidationDao systemEmployeeValidationDao;
	
	@Autowired
	public SystemEmployeeValidationManager(SystemEmployeeValidationDao systemEmployeeValidationDao) {
		super();
		this.systemEmployeeValidationDao = systemEmployeeValidationDao;
	}

	@Override
	public DataResult<List<SystemEmployeeValidation>> getAll() {
		return new SuccessDataResult<List<SystemEmployeeValidation>>(this.systemEmployeeValidationDao.findAll(), "Sistem Kullanıcısı Doğrulamaları Listelendi");
	}

	@Override
	public Result add(SystemEmployeeValidation systemEmployeeValidation) {
		this.systemEmployeeValidationDao.save(systemEmployeeValidation);
		return new SuccessResult("Kullanıcı Doğrulandı");
	}

}
