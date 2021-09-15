package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.HowWork;

public interface HowWorkService {
	DataResult<List<HowWork>> getAll();
	Result add(HowWork howWork);
}
