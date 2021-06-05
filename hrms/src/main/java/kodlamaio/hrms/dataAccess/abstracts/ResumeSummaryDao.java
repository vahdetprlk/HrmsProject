package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeSummary;

public interface ResumeSummaryDao extends JpaRepository<ResumeSummary, Integer>{

}
