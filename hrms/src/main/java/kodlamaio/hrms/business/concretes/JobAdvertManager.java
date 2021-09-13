package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;


@Service
public class JobAdvertManager implements JobAdvertService{
	private JobAdvertDao jobAdvertDao;
	
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş İlanı eklendi");
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		JobAdvert jobAdvertInDatabase = this.jobAdvertDao.getOne(jobAdvert.getId());
		jobAdvertInDatabase.setActive(false);
		this.jobAdvertDao.save(jobAdvertInDatabase);
		return new SuccessResult("İlan Pasif Duruma Alındı");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByActiveTrue(boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActive(isActive), "Aktif İlanlar Listelendi");
		
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByActiveTrueAndSortedByCreatedDate() {
	
	Sort sort = Sort.by(Sort.Direction.DESC,"createdDate" );
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"Başarılı");
	}
		
		
	

	@Override
	public DataResult<List<JobAdvert>> getAllByEmployerIdAndActiveTrue(int id, boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_IdAndIsActive(id,isActive), "Data Listelendi");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id), "Data Listelendi");
	}






}
