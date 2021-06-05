package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.ResumeWorkHistory;

public interface ResumeWorkHistoryDao extends JpaRepository<ResumeWorkHistory, Integer> {
	List<ResumeWorkHistory> findAllByResume_JobSeeker_IdOrderByExperienceEndDateDesc(int userId);

}
