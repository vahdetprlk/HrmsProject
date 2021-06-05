package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeSkill;

public interface ResumeSkillService {
	DataResult<List<ResumeSkill>> getAll();
	Result add(ResumeSkill resumeSkill);
}
