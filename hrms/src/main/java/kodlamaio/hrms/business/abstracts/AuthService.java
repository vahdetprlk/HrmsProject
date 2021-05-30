package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	Result registerJobSeeker(JobSeeker jobSeeker);
	Result registerEmployer(Employer employer);
	Result verifyUserByEmail(int userId,int id);
}
