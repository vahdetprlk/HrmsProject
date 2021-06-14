package kodlamaio.hrms.core.utilities.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
	
public class CloudinaryImageUploadManager implements ImageUploadService  {
	private Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "kodlamaio-vhdt",
			"api_key", "538243689868794",
			"api_secret", "UFProbHtiaESHMfhSSh693pfwVI"));
	
@Override
	public DataResult<Map> save(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            ;
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>("Something went wrong");
    }
	


	



	}
