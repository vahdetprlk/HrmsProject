package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemEmployeeValidation;

public interface SystemEmployeeValidationDao extends JpaRepository<SystemEmployeeValidation, Integer>{

}
