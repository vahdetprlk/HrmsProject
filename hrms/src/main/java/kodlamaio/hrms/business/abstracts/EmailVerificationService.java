package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.User;

public interface EmailVerificationService {
	Result add(User user,EmailVerification emailVerification);
	 
	Result sendEmail(User user);
	
	Result update(EmailVerification emailVerification);
	
	DataResult<EmailVerification> getByUserIdAndId(int userId,int id);
	



}
