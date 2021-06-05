package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeEducationHistory;

public interface ResumeEducationHistoryDao extends JpaRepository<ResumeEducationHistory, Integer> {

	List<ResumeEducationHistory> findAllByResume_JobSeeker_IdOrderByGraduationEndDateDesc(int userId);

}
