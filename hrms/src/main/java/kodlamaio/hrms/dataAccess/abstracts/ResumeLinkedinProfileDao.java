package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeLinkedinProfile;

public interface ResumeLinkedinProfileDao extends JpaRepository<ResumeLinkedinProfile, Integer>{

}
