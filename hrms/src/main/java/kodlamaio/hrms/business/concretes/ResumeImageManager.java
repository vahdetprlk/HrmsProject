package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.services.ImageUploadService;
import kodlamaio.hrms.dataAccess.abstracts.ResumeImageDao;

import kodlamaio.hrms.entities.concretes.ResumeImage;


@Service
public class ResumeImageManager implements ResumeImageService {

	private ImageUploadService imageUploadService;
	private ResumeImageDao resumeImageDao;


	@Autowired
	public ResumeImageManager(ResumeImageDao resumeImageDao, ImageUploadService imageUploadService) {
		super();
		this.resumeImageDao = resumeImageDao;
		this.imageUploadService = imageUploadService;

	}

	@Override
	public Result add(ResumeImage resumeImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageUploadService.save(file).getData();
		String url = result.get("url");
		resumeImage.setUrl(url);
		
		
		
		return add(resumeImage);
	}

	@Override
	public DataResult<List<ResumeImage>> getAll() {
		return new SuccessDataResult<List<ResumeImage>>(this.resumeImageDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(ResumeImage resumeImage) {
		this.resumeImageDao.save(resumeImage);
		return new SuccessResult("Başarılı");
	}

}
