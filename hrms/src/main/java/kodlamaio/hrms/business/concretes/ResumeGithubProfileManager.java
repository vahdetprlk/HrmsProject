package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeGithubProfileService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeGithubProfileDao;
import kodlamaio.hrms.entities.concretes.ResumeGithubProfile;
@Service
public class ResumeGithubProfileManager implements ResumeGithubProfileService{

	
	private ResumeGithubProfileDao resumeGithubProfileDao;
	@Autowired
	public ResumeGithubProfileManager(ResumeGithubProfileDao resumeGithubProfileDao) {
		super();
		this.resumeGithubProfileDao = resumeGithubProfileDao;
	}

	@Override
	public DataResult<List<ResumeGithubProfile>> getAll() {
		return new SuccessDataResult<List<ResumeGithubProfile>>(this.resumeGithubProfileDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeGithubProfile resumeGithubProfile) {
		this.resumeGithubProfileDao.save(resumeGithubProfile);
		return new SuccessResult("Başarılı");
	}

}
