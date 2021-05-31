package kodlamaio.hrms.entities.concretes;

import java.util.Date;

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
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="salary_min")
	private float salaryMin;
	
	@Column(name="salary_max")
	private float salaryMax;
	
	@Column(name="position_number")
	private int positionNumber;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="deadline_date")
	private Date deadlineDate;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	
}
