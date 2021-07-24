package kodlamaio.hrms.entities.dtos;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
	private int id;
	private int resumeId;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private int graduateId;
	private String schoolName;
	private String department;
	private Date startedDate;
	private Date endedDate;
}
