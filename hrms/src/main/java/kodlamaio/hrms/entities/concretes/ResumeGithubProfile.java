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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_github_profiles")

public class ResumeGithubProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "resume_id")
//	private int resumeId;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@Column(name = "url")
	private String url;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "is_active")
	private boolean isActive;

}
