package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{

	List<Resume> getByJobSeeker_IdAndIsActive(int userId,boolean isActive);
	
	List<Resume> getByIsActive(boolean isActive);
}
