package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeImage;

public interface ResumeImageService {
	DataResult<List<ResumeImage>> getAll();
	Result add(ResumeImage resumeImage);
	Result add(ResumeImage resumeImage, MultipartFile file);

	
}
