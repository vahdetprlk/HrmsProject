package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSummaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSummaryDao;
import kodlamaio.hrms.entities.concretes.ResumeSummary;
@Service
public class ResumeSummaryManager implements ResumeSummaryService{

	
	private ResumeSummaryDao resumeSummaryDao;
	
	@Autowired
	public ResumeSummaryManager(ResumeSummaryDao resumeSummaryDao) {
		super();
		this.resumeSummaryDao = resumeSummaryDao;
	}

	@Override
	public DataResult<List<ResumeSummary>> getAll() {
	
		return new SuccessDataResult<List<ResumeSummary>>(this.resumeSummaryDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeSummary resumeSummary) {
this.resumeSummaryDao.save(resumeSummary);
		return new SuccessResult("Başarılı");
	}

}
