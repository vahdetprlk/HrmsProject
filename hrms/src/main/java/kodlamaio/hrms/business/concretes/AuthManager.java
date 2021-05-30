package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService2;
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
	private EmailVerificationService2 emailVerificationService2;

	@Autowired
	public AuthManager(JobSeekerService jobSeekerManager, EmployerService employerService,
			EmailVerificationService2 emailVerificationService2) {
		super();
		this.jobSeekerService = jobSeekerManager;
		this.employerService = employerService;
		this.emailVerificationService2 = emailVerificationService2;
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) {

		if (this.jobSeekerService.add(jobSeeker).isSuccess() == false) {

			return new ErrorResult("Kullanıcı Kaydedilemedi Tekrar Deneyin Problem= "
					+ this.jobSeekerService.add(jobSeeker).getMessage());

		} else {

			EmailVerification emailVerification = new EmailVerification();
			this.emailVerificationService2.add(jobSeeker, emailVerification);

			this.emailVerificationService2.sendEmail(jobSeeker);
			return new SuccessResult("Kullanıcı Kaydedildi ve Aktivasyon Maili Gönderildi =  "
					+ this.emailVerificationService2.sendEmail(jobSeeker).getMessage());
		}

	}

	@Override
	public Result registerEmployer(Employer employer) {

		if (this.employerService.add(employer).isSuccess() == false) {

			return new ErrorResult("Kullanıcı Kaydedilemedi Tekrar Deneyin Problem= "
					+ this.employerService.add(employer).getMessage());

		} else {

			EmailVerification emailVerification = new EmailVerification();
			this.emailVerificationService2.add(employer, emailVerification);

			this.emailVerificationService2.sendEmail(employer);
			return new SuccessResult("Kullanıcı Kaydedildi ve Aktivasyon Maili Gönderildi =  "
					+ this.emailVerificationService2.sendEmail(employer).getMessage());
		}

	}

	@Override
	public Result verifyUserByEmail(int userId, int id) {

		EmailVerification emailVerificationInDataBase = this.emailVerificationService2.getByUserIdAndId(userId, id).getData();
		emailVerificationInDataBase.setVerified(true);
		this.emailVerificationService2.update(emailVerificationInDataBase);

		return new SuccessResult("Email Aktivasyonu Tamamlandı");
	}
}