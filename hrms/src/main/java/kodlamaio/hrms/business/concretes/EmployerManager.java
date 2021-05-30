package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşveren Listesi Getirildi");
	}

	@Override
	public Result add(Employer employer) {
		String[] splitMail = employer.getEmail().split("@");
		if (employer.getEmail().isBlank()) {

			return new ErrorResult("Email bilgisi giriniz");

		} else if (employer.getPassword().isBlank()) {

			return new ErrorResult("Şifre Giriniz");

		} else if (employer.getPasswordAgain().isBlank()) {

			return new ErrorResult("Şifre Tekrarını Giriniz");

		} else if (employer.getCompanyName().isBlank()) {

			return new ErrorResult("Şirket Adı Giriniz");

		} else if (employer.getPhoneNumber().isBlank()) {

			return new ErrorResult("Telefon Giriniz");
		} else if (employer.getWebSite().isBlank()) {

			return new ErrorResult("website Giriniz");
		}

		else if (employerDao.existsByEmail(employer.getEmail())) {

			return new ErrorResult("Bu mail ile kayıtlı bir kullanıcı mevcut.");

		}
		
		else if (!splitMail[1].equals(employer.getWebSite())) {
			return new ErrorResult("Emailiniz Şirket Domainli Olmalıdır.");
		}else if(!employer.getPassword().equals(employer.getPasswordAgain())) {
			
			return new ErrorResult("Şifre tekrarı uyuşmuyor.");
			
		}
		
	

		this.employerDao.save(employer);
		return new SuccessResult("İşveren Sisteme eklendi");
	}

}
