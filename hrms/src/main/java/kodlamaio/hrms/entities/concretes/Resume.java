package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resumeEducationHistory", "resumeWorkHistory",
		"resumeSummary", "resumeSkill", "resumeLinkedinProfile", "resumeGithubProfile", "resumeLanguage",
		"resumeImage" })
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "is_active")
	private boolean isActive;

	@OneToMany(mappedBy = "resume")
	private List<ResumeEducationHistory> resumeEducationHistory;

	@OneToMany(mappedBy = "resume")
	private List<ResumeWorkHistory> resumeWorkHistory;

	@OneToMany(mappedBy = "resume")
	private List<ResumeSummary> resumeSummary;

	@OneToMany(mappedBy = "resume")
	private List<ResumeSkill> resumeSkill;

	@OneToMany(mappedBy = "resume")
	private List<ResumeLinkedinProfile> resumeLinkedinProfile;

	@OneToMany(mappedBy = "resume")
	private List<ResumeGithubProfile> resumeGithubProfile;

	@OneToMany(mappedBy = "resume")
	private List<ResumeLanguage> resumeLanguage;

	@OneToMany(mappedBy = "resume")
	private List<ResumeImage> resumeImage;
}
