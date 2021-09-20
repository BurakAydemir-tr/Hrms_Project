package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> findAllByPosition(String title);
	DataResult<JobPosition> findById(int id);
	DataResult<JobPosition> findByPosition(String position);
}