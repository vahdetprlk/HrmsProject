package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkedinProfileService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkedinProfileDao;
import kodlamaio.hrms.entities.concretes.ResumeLinkedinProfile;
@Service
public class ResumeLinkedinProfileManager implements ResumeLinkedinProfileService{

	
	private ResumeLinkedinProfileDao resumeLinkedinProfileDao;
	@Autowired
	public ResumeLinkedinProfileManager(ResumeLinkedinProfileDao resumeLinkedinProfileDao) {
		super();
		this.resumeLinkedinProfileDao = resumeLinkedinProfileDao;
	}

	@Override
	public DataResult<List<ResumeLinkedinProfile>> getAll() {
		return new SuccessDataResult<List<ResumeLinkedinProfile>>(this.resumeLinkedinProfileDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeLinkedinProfile resumeLinkedinProfile) {
		this.resumeLinkedinProfileDao.save(resumeLinkedinProfile);
		return new SuccessResult("Başarılı");
	}

}
