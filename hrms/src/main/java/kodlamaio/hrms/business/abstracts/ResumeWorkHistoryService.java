package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeWorkHistory;

public interface ResumeWorkHistoryService {

	DataResult<List<ResumeWorkHistory>> getAll();
	Result add(ResumeWorkHistory resumeWorkHistory);
	DataResult<List<ResumeWorkHistory>> findAllByResume_JobSeeker_UserIdOrderByExperienceEndDateDesc(int userId);
}


