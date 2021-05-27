package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
@Service
public class EmailVerificationManager implements EmailVerificationService{
		private	EmailVerificationDao emailVerificationDao;
		@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
			super();
			this.emailVerificationDao = emailVerificationDao;
		}

	@Override
	public DataResult<List<EmailVerification>> getAll() {
		
		return new SuccessDataResult<List<EmailVerification>>(this.emailVerificationDao.findAll(), "Aktivasyon Listesi Getirildi");
	}

	@Override
	public Result sendCodeToEmail(EmailVerification emailVerification) {
		emailVerification.setVerified(false);
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult("Doğrulama Emaili Gönderildi");
	}

	@Override
	public Result confirmedCodeRequest(EmailVerification emailVerification) {
	EmailVerification emailVerificationInDB = this.emailVerificationDao.findById(emailVerification.getId()).get();
	emailVerificationInDB.setVerified(true);
	
	this.emailVerificationDao.save(emailVerificationInDB);
		return new SuccessResult("Kod Onaylandı");
	}

}
