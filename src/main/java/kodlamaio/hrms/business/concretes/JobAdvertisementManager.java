package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import kodlamaio.hrms.entities.dtos.JobAdvertFilter;

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
		return new SuccessResult("???? ilan?? eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"??lanlar listelendi.");
	}
	
	private Result jobPositionCheck(int id) {
		if(id==0) {
			return new ErrorResult("i?? pozisyonu girilmesi zorunludur.");
		}
		return new SuccessResult();
	}
	
	private Result jobDescriptionCheck(String description) {
		if(description==null) {
			return new ErrorResult("i?? tan??m?? bo?? b??rak??lamaz.");
		}
		return new SuccessResult();
	}
	
	private Result cityCheck(int cityId) {
		if(cityId<1 && cityId>81) {
			return new ErrorResult("??ehir bulunamad??.");
		}
		return new SuccessResult();
	}
	
	private Result positionNumberCheck(int count) {
		if(count<=0) {
			return new ErrorResult("A????k i?? pozisyonu 0 ve 0'dan k??????k olamaz.");
		}
		return new SuccessResult();
	}
	
	private Result deadlineDateCheck(LocalDate endDate) {
		if(LocalDate.now().isAfter(endDate)) {
			return new ErrorResult("Son ba??vuru tarihi i?? ilan?? tarihinden ??nce olamaz.");
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

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActivatedFalse() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActivatedFalse());
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public Result confirmIsActivated(int id) {
		JobAdvertisement jobAdvert=this.jobAdvertisementDao.getById(id);
		if(jobAdvert.isActivated()) {
			return new ErrorResult("???? ilan?? zaten yay??nda");
		}
		
		jobAdvert.setActivated(true);
		this.jobAdvertisementDao.save(jobAdvert);
		return new SuccessResult("???? ilan?? onayland??");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getFilterAndPage(int pageNo, int pageSize, JobAdvertFilter jobAdvertFilter) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByFilter(jobAdvertFilter, pageable).getContent());
	}

	@Override
	public DataResult<Integer> getCountJobAdvert() {
		
		return new SuccessDataResult<Integer>(this.jobAdvertisementDao.findAll().size());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByEmployerId(int employerId) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployerId(employerId),"??lanlar listelendi.");
	}
	
	

}
