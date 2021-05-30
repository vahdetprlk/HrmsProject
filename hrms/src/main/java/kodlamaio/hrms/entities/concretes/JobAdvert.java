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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "salary_min")
	private double salaryMin;
	
	@Column(name = "salary_max")
	private double salaryMax;
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	

//	@Column(name = "employer_id")
//	private int employerId;

		
	
//	@Column(name = "position_id")
//	private int positionId;
	
	@Column(name = "open_position_qty")
	private int openPositionQty;

	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
