package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;

import kodlamaio.hrms.entities.concretes.Resume;
@Service
public class ResumeManager implements ResumeService{

		
	private ResumeDao resumeDao;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		
		return new SuccessResult("Cv Oluşturuldu");
	}

	@Override
	public Result delete(Resume resume) {
		Resume resumeInDatabase = this.resumeDao.getOne(resume.getId());
		resumeInDatabase.setActive(false);
		this.resumeDao.save(resumeInDatabase);
		return new SuccessResult("CV Silindi");
	}

	@Override
	public DataResult<List<Resume>> getByIsActive(boolean isActive) {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByIsActive(isActive), "Aktif Tüm Cv'ler Listelendi");
	}

	@Override
	public DataResult<List<Resume>> getByJobSeeker_IdAndIsActive(int userId, boolean isActive) {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByJobSeeker_IdAndIsActive(userId, isActive), "Kullanıcıya Ait CV Bilgisi Getirildi");
	}

}
