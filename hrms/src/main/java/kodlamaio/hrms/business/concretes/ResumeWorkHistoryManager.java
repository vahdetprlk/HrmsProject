package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeWorkHistoryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeWorkHistoryDao;
import kodlamaio.hrms.entities.concretes.ResumeWorkHistory;
@Service
public class ResumeWorkHistoryManager implements ResumeWorkHistoryService{

	
	private		ResumeWorkHistoryDao resumeWorkHistoryDao;
	
	@Autowired
	public ResumeWorkHistoryManager(ResumeWorkHistoryDao resumeWorkHistoryDao) {
		super();
		this.resumeWorkHistoryDao = resumeWorkHistoryDao;
	}

	@Override
	public DataResult<List<ResumeWorkHistory>> getAll() {
		
		return new SuccessDataResult<List<ResumeWorkHistory>>(this.resumeWorkHistoryDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeWorkHistory resumeWorkHistory) {
		this.resumeWorkHistoryDao.save(resumeWorkHistory);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<ResumeWorkHistory>> findAllByResume_JobSeeker_UserIdOrderByExperienceEndDateDesc(int userId) {
		
		return new SuccessDataResult<List<ResumeWorkHistory>>(this.resumeWorkHistoryDao.findAllByResume_JobSeeker_IdOrderByExperienceEndDateDesc(userId), "Data Listelendi");
	}

}
