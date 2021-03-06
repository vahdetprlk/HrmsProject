package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	
	Result delete(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAllByActiveTrue(boolean isActive);
	
	DataResult<List<JobAdvert>> getAllByActiveTrueAndSortedByCreatedDate();
	
	DataResult<List<JobAdvert>> getAllByEmployerIdAndActiveTrue(int id,boolean isActive);
	
	DataResult<JobAdvert> getById(int id);
	
	
}
