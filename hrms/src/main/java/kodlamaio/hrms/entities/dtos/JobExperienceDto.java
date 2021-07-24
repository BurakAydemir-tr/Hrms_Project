package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
	private int id;
	private int resumeId;
	private String companyName;
	private String jobPosition;
	private Date startedDate;
	private Date endedDate;
}
