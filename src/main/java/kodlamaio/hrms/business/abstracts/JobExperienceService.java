package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService {
	Result add(JobExperienceDto jobExperienceDto);
	Result delete(JobExperienceDto jobExperienceDto);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getByResumeId(int resumeId);
	DataResult<List<JobExperience>> findAllByResume_IdOrderByEndedDateDesc(int id);
}
