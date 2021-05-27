package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),
				"İş Arayan Kullanıcıları Listelendi");

	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		if (jobSeeker.getFirstName().isBlank()) {

			return new ErrorResult("İsim Bilgisi Giriniz");

		} else if (jobSeeker.getLastName().isBlank()) {

			return new ErrorResult("Soyisim Bilgisi Giriniz");

		} else if (jobSeeker.getNationalId().isBlank()) {

			return new ErrorResult("TC kimlik no bilgisi giriniz");

		} else if (jobSeeker.getEmail().isBlank()) {

			return new ErrorResult("Email bilgisi giriniz");

		} else if (jobSeeker.getPassword().isBlank()) {

			return new ErrorResult("Şifre Giriniz");

		} else if (jobSeeker.getPasswordAgain().isBlank()) {

			return new ErrorResult("Şifre Tekrarını Giriniz");
		
		} else if (jobSeekerDao.existsByEmail(jobSeeker.getEmail())) {

			return new ErrorResult("Bu mail ile kayıtlı bir kullanıcı mevcut.");

		} else if (jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())) {

		return new ErrorResult("Bu TcKimlik Numarası ile kayıtlı bir kullanıcı mevcut.");

	}

		{

			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kullanıcı İş Arayan Listesine Eklendi");

		}

	}

}
