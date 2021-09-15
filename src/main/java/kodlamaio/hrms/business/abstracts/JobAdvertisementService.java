package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertFilter;


public interface JobAdvertisementService {
	Result add(JobAdvertDto jobAdvertDto);
	Result confirmIsActivated(int id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findAllByIsActivated(boolean isActivated);
	DataResult<List<JobAdvertisement>> findAllByIsActivatedTrueOrderByCreatedDate();
	DataResult<List<JobAdvertisement>> findAllIsActivatedAndEmployer(int employerId);
	DataResult<List<JobAdvertisement>> findAllByEmployerId(int employerId);
	DataResult<List<JobAdvertisement>> findAllByIsActivatedFalse();
	DataResult<JobAdvertisement> getById(int id);
	DataResult<Integer> getCountJobAdvert();
	DataResult<List<JobAdvertisement>> getFilterAndPage(int pageNo,int pageSize,JobAdvertFilter jobAdvertFilter);
	
}
