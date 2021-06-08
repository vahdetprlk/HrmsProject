package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.ResumeImage;

@RestController
@RequestMapping("/api/resume-images")
public class ResumeImagesController {


		private ResumeImageService resumeImageService;
		@Autowired	
		
		public ResumeImagesController(ResumeImageService resumeImageService) {
			super();
			this.resumeImageService = resumeImageService;
		}
		@GetMapping("/getAll")
		
		DataResult<List<ResumeImage>> getAll(){
			return this.resumeImageService.getAll();
		}
		@PostMapping("/add")
		Result add(@RequestParam int resumeId,@RequestParam MultipartFile multipartFile) {
			ResumeImage resumeImage = new ResumeImage();
			Resume resume = new Resume();
			resume.setId(resumeId);
			resumeImage.setResume(resume);
			resumeImage.setCreatedDate(LocalDate.now());
			
			
			return this.resumeImageService.add(resumeImage,multipartFile);
		}

	}

