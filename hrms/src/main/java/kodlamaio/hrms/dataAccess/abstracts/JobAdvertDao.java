package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByEmployer_IdAndIsActive(int id,boolean isActive);
	List<JobAdvert> getByIsActive(boolean isActive);
	JobAdvert getById(int id);
	
}

