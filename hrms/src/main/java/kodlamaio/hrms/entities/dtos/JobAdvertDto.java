package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	private int id;
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private int typeWorkId;
	private int howWorkId;
	private float salaryMin;
	private float salaryMax;
	private int positionNumber;
	//private LocalDate createdDate;
	private LocalDate deadlineDate;
	private String jobDescription;
}
