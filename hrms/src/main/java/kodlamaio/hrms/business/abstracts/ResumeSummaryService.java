package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.ResumeSummary;

public interface ResumeSummaryService {
	DataResult<List<ResumeSummary>> getAll();
	Result add(ResumeSummary resumeSummary);
}
