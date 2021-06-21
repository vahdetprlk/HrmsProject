package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_employee_job_advert_validations")
public class SystemEmployeeJobAdvertValidation {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "system_employee_id")
	private SystemEmployee systemEmployee;
	
	@ManyToOne()
	@JoinColumn(name = "job_advert_id")
	private JobAdvert jobAdvert;
	
	@Column(name = "is_valid")
	private boolean isValid;
	
	@Column(name = "validation_date")
	private LocalDate validationDate;
	
	@Column(name = "created_date")
	private LocalDate createdDate;

}
