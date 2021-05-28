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

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "system_employee_validations")
public class SystemEmployeeValidation {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	 @ManyToOne()
		@JoinColumn(name = "employer_id")
	private Employer employer;
	
	 @ManyToOne()
		@JoinColumn(name = "system_employee_id")
	private SystemEmployee systemEmployee;
	
	@Column(name = "is_valid")
	private boolean isValid;
	
	@Column(name = "validation_date")
	private LocalDate validationDate;

}
