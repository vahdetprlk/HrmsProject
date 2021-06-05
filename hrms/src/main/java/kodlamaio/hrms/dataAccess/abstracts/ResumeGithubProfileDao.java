package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeGithubProfile;

public interface ResumeGithubProfileDao extends JpaRepository<ResumeGithubProfile, Integer>{

}
