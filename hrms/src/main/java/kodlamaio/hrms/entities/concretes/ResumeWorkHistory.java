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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_work_histories")

public class ResumeWorkHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "resume_id")
//	private int resumeId;

	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@Column(name = "workplace_name")
	private String workplaceName;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@Column(name = "experience_start_date")
	private LocalDate experienceStartDate;

	@Column(name = "experience_end_date")
	private LocalDate experienceEndDate;

	@Column(name = "current_status")
	private boolean currentStatus;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "is_active")
	private boolean isActive;

}
