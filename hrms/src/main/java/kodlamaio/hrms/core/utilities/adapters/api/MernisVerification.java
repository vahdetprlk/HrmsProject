package kodlamaio.hrms.core.utilities.adapters.api;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.service.CheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
 
@Service
public class MernisVerification implements CheckService {
	

@Override
	public boolean mernisVerification(JobSeeker jobSeeker) {
		boolean result;
		KPSPublicSoapProxy kpsPublic;
		
		try {
			kpsPublic = new KPSPublicSoapProxy();
			result = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(jobSeeker.getNationalId()), 
							jobSeeker.getFirstName().toUpperCase(), 
							jobSeeker.getLastName().toUpperCase(), 
							(jobSeeker.getDateOfBirth().getYear()));
			
		} catch (RemoteException  e) {
			
			result = false;
					e.printStackTrace();
		}
			return result;
	}

}

