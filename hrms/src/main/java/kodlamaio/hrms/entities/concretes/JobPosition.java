package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts", "resumeWorkHistories" })
@AllArgsConstructor
@NoArgsConstructor
@Data

public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "position_name")
	private String name;

	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvert> jobAdverts;

	@OneToMany(mappedBy = "jobPosition")
	private List<ResumeWorkHistory> resumeWorkHistories;

}
