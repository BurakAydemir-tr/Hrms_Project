package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employers_updates")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@JsonIgnore
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createDate;
	
	@JsonIgnore
	@Column(name="verified")
	private boolean verified;
	
	@JsonIgnore
	@Column(name="verified_date")
	private LocalDate verifiedDate;
}
