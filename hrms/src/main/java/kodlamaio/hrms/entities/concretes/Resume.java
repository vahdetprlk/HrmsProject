package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","jobSeeker", "resumeEducationHistories", "resumeWorkHistories",
		"resumeSummaries", "resumeSkills", "resumeLinkedinProfiles", "resumeGithubProfiles", "resumeLanguages",
		"resumeImages" })
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;


	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "is_active")
	private boolean isActive;



	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "resume")
	private List<ResumeEducationHistory> resumeEducationHistories;

	@OneToMany(mappedBy = "resume")
	private List<ResumeWorkHistory> resumeWorkHistories;

	@OneToMany(mappedBy = "resume")
	private List<ResumeSummary> resumeSummaries;

	@OneToMany(mappedBy = "resume")
	private List<ResumeSkill> resumeSkills;

	@OneToMany(mappedBy = "resume")
	private List<ResumeLinkedinProfile> resumeLinkedinProfiles;

	@OneToMany(mappedBy = "resume")
	private List<ResumeGithubProfile> resumeGithubProfiles;

	@OneToMany(mappedBy = "resume")
	private List<ResumeLanguage> resumeLanguages;

	@OneToMany(mappedBy = "resume")
	private List<ResumeImage> resumeImages;
}
