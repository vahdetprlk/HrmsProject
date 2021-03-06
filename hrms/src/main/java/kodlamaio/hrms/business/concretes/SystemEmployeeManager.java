package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;

import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService{

		private SystemEmployeeDao systemEmployeeDao;
		
		@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
			super();
			this.systemEmployeeDao = systemEmployeeDao;
		}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {

		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(),
				"Sistem Kullanıcıları Listelendi");

	}

	@Override
	public Result add(SystemEmployee systemEmployee) {

		if (systemEmployee.getFirstName().isBlank()) {

			return new ErrorResult("İsim Bilgisi Giriniz");

		} else if (systemEmployee.getLastName().isBlank()) {

			return new ErrorResult("Soyisim Bilgisi Giriniz");
		
	}else
		 
		this.systemEmployeeDao.save(systemEmployee);
		return new SuccessResult("Sistem Kullanıcısı Eklendi");
	
	}
	
}

