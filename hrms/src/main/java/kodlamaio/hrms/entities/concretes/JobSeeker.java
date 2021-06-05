package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "emailVerifications","resumes" })
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User {

	@Column(name = "first_name") 
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "national_id")
	private String nationalId;

	@OneToMany(mappedBy = "jobSeeker")
	private List<Resume> resumes;
	


}
