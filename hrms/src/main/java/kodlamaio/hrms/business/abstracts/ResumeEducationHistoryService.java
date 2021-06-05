package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeEducationHistory;

public interface ResumeEducationHistoryService {

	DataResult<List<ResumeEducationHistory>> getAll();
	Result add(ResumeEducationHistory resumeEducationHistory);
	
	DataResult<List<ResumeEducationHistory>> findAllByResume_JobSeeker_UserIdOrderByGraduationEndDateDesc(int userId);
}
