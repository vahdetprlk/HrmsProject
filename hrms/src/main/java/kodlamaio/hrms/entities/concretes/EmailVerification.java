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
@Table(name = "email_verifications")

public class EmailVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	//@ManyToOne
	//@JoinColumn(name = "user_id")
	//private User user;
	
	
//	@Column(name = "user_id")
//	private int userId;
	
	@Column(name = "is_verified")
	private boolean isVerified;

	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "activation_date")
	private LocalDate activationDate;
	
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
}
