package kodlamaio.hrms.business.concretes;


import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService2;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class EmailVerificationManager2 implements EmailVerificationService2{

	
	private EmailVerificationDao emailVerificationDao; 
	
	@Autowired
	public EmailVerificationManager2(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

	@Override
	public Result add(User user, EmailVerification emailVerification) {
	
		
		UUID uuid = UUID.randomUUID();
		String activationCode = uuid.toString();
		
	
		emailVerification.setActivationCode(activationCode);
		emailVerification.setActivationDate(LocalDate.now());
		emailVerification.setVerified(false);
		emailVerification.setUser(user);
		
		
		
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult("Aktivasyon Eklendi");
	}

	@Override
	public Result update(EmailVerification emailVerification) {
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult("Aktivasyon Güncellendi");
	}

	@Override
	public DataResult<EmailVerification> getByUserIdAndId(int userId, int id) {
		
		return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.findByUserIdAndId(userId, id));
	}

	@Override
	public Result sendEmail(User user) {
		
		return new SuccessResult(user.getEmail());
		
		
	}



}
