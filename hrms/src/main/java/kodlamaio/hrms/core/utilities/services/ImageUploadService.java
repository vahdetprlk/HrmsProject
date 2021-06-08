package kodlamaio.hrms.core.utilities.services;



import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	public DataResult<?> save(MultipartFile file);
}
