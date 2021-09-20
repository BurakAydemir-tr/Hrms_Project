package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.TypeWork;

public interface TypeWorkService {
	DataResult<List<TypeWork>> getAll();
	Result add(TypeWork typeWork);
}
