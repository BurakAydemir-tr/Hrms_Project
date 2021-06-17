package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		
		Result businessRulesResult=BusinessRules.run(
				jobPositionCheck(jobAdvertDto.getJobPositionId()),
				jobDescriptionCheck(jobAdvertDto.getJobDescription()),
				cityCheck(jobAdvertDto.getCityId()),
				positionNumberCheck(jobAdvertDto.getPositionNumber()),
				deadlineDateCheck(jobAdvertDto.getDeadlineDate())
				);
		
		if ( businessRulesResult != null ) {
			return new ErrorResult(businessRulesResult.getMessage());
		}
		
		
		
		this.jobAdvertisementDao.save((JobAdvertisement)dtoConverterService.dtoClassConverter(jobAdvertDto, JobAdvertisement.class));
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"İlanlar listelendi.");
	}
	
	private Result jobPositionCheck(int id) {
		if(id==0) {
			return new ErrorResult("iş pozisyonu girilmesi zorunludur.");
		}
		return new SuccessResult();
	}
	
	private Result jobDescriptionCheck(String description) {
		if(description==null) {
			return new ErrorResult("iş tanımı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
	
	private Result cityCheck(int cityId) {
		if(cityId<1 && cityId>81) {
			return new ErrorResult("Şehir bulunamadı.");
		}
		return new SuccessResult();
	}
	
	private Result positionNumberCheck(int count) {
		if(count<=0) {
			return new ErrorResult("Açık iş pozisyonu 0 ve 0'dan küçük olamaz.");
		}
		return new SuccessResult();
	}
	
	private Result deadlineDateCheck(LocalDate endDate) {
		if(LocalDate.now().isAfter(endDate)) {
			return new ErrorResult("Son başvuru tarihi iş ilanı tarihinden önce olamaz.");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActivated(boolean isActivated) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActivated(isActivated));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActivatedTrueOrderByCreatedDate() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActivatedTrueOrderByCreatedDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllIsActivatedAndEmployer(int employerId) {
	
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllIsActivatedAndEmployer(employerId));
	}

}
