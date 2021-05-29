package kodlamaio.hrms.core.utilities.adapters.api;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.core.utilities.adapters.service.FakeCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public class FakeMernisVerification implements FakeCheckService{

	@Override
	public boolean fakeMernisVerification(JobSeeker jobSeeker) {
		
		if(jobSeeker.getNationalId().length()!=11) {
			
			return false;
		}else
		
		return true;
	}

}
