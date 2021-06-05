package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeEducationHistoryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeEducationHistoryDao;

import kodlamaio.hrms.entities.concretes.ResumeEducationHistory;
@Service
public class ResumeEducationHistoryManager implements ResumeEducationHistoryService{

	
	private ResumeEducationHistoryDao resumeEducationHistoryDao;
	
	@Autowired
	public ResumeEducationHistoryManager(ResumeEducationHistoryDao resumeEducationHistoryDao) {
		super();
		this.resumeEducationHistoryDao = resumeEducationHistoryDao;
	}

	@Override
	public DataResult<List<ResumeEducationHistory>> getAll() {
		
		return new SuccessDataResult<List<ResumeEducationHistory>>(this.resumeEducationHistoryDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeEducationHistory resumeEducationHistory) {
		this.resumeEducationHistoryDao.save(resumeEducationHistory);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<ResumeEducationHistory>> findAllByResume_JobSeeker_UserIdOrderByGraduationEndDate(
			int userId) {
		
		return new SuccessDataResult<List<ResumeEducationHistory>>(this.resumeEducationHistoryDao.findAllByResume_JobSeeker_IdOrderByGraduationEndDate(userId), "Başarılı");
	}

//	@Override
//	public DataResult<List<ResumeEducationHistory>> getAllSortedByGraduationEndDate() {
//		Sort sort = Sort.by(Sort.Direction.DESC,"graduationEndDate" );
//		
//		return new SuccessDataResult<List<ResumeEducationHistory>>(this.resumeEducationHistoryDao.findAll(sort), "Başarılı");
//		
		
//	}
	
}
				
				
				
				
				
				