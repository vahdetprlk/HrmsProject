package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeWorkHistory;

public interface ResumeWorkHistoryDao extends JpaRepository<ResumeWorkHistory, Integer> {


}
