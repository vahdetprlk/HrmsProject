package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public AuthManager(JobSeekerService jobSeekerManager, EmployerService employerService,
			EmailVerificationService emailVerificationService2) {
		super();
		this.jobSeekerService = jobSeekerManager;
		this.employerService = employerService;
		this.emailVerificationService = emailVerificationService2;
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) {

		if (this.jobSeekerService.add(jobSeeker).isSuccess() == false) {

			return new ErrorResult("Kullanıcı Kaydedilemedi Tekrar Deneyin Problem= "
					+ this.jobSeekerService.add(jobSeeker).getMessage());

		} else {

			EmailVerification emailVerification = new EmailVerification();
			this.emailVerificationService.add(jobSeeker, emailVerification);

			this.emailVerificationService.sendEmail(jobSeeker);
			return new SuccessResult("Kullanıcı Kaydedildi ve Aktivasyon Maili Gönderildi =  "
					+ this.emailVerificationService.sendEmail(jobSeeker).getMessage());
		}

	}

	@Override
	public Result registerEmployer(Employer employer) {

		if (this.employerService.add(employer).isSuccess() == false) {

			return new ErrorResult("Kullanıcı Kaydedilemedi Tekrar Deneyin Problem= "
					+ this.employerService.add(employer).getMessage());

		} else {

			EmailVerification emailVerification = new EmailVerification();
			this.emailVerificationService.add(employer, emailVerification);

			this.emailVerificationService.sendEmail(employer);
			return new SuccessResult("Kullanıcı Kaydedildi ve Aktivasyon Maili Gönderildi =  "
					+ this.emailVerificationService.sendEmail(employer).getMessage());
		}

	}

	@Override
	public Result verifyUserByEmail(int userId, int id) {

		EmailVerification emailVerificationInDataBase = this.emailVerificationService.getByUserIdAndId(userId, id).getData();
		emailVerificationInDataBase.setVerified(true);
		this.emailVerificationService.update(emailVerificationInDataBase);
 
		return new SuccessResult("Email Aktivasyonu Tamamlandı");
	}
}