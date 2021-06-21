package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemEmployeeJobAdvertValidation;

public interface SystemEmployeeJobAdvertValidationDao extends JpaRepository<SystemEmployeeJobAdvertValidation, Integer> {

}
