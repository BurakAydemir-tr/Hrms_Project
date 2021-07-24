package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		this.jobExperienceDao.save((JobExperience)dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("İş Deneyimi eklendi.");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Deneyimler listelendi");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByResume_IdOrderByEndedDateDesc(int id) {
		
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByResume_IdOrderByEndedDateDesc(id));
	}

	@Override
	public Result delete(JobExperienceDto jobExperienceDto) {
		this.jobExperienceDao.delete((JobExperience)dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("İş deneyimi silindi.");
	}

	@Override
	public DataResult<List<JobExperience>> getByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.getByResumeId(resumeId),"Deneyimler listelendi");
	}

}
