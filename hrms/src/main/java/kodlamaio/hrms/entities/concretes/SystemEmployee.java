package kodlamaio.hrms.entities.concretes;

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
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","systemEmployeeValidations"})
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "system_employees")
@PrimaryKeyJoinColumn(name = "user_id")
public class SystemEmployee extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	
	@OneToMany(mappedBy = "systemEmployee")
	private List<SystemEmployeeValidation> systemEmployeeValidations;

}
