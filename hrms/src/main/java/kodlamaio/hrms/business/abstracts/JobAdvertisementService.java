package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findAllByIsActivated(boolean isActivated);
	DataResult<List<JobAdvertisement>> findAllByIsActivatedTrueOrderByCreatedDate();
	DataResult<List<JobAdvertisement>> findAllIsActivatedAndEmployer(int employerId);
}
