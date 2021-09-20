package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<List<EmployerUpdate>> findAllByVerifiedFalse();
	Result add(Employer employer);
	DataResult<Employer> getById(int id);
	Result update(EmployerUpdate employerUpdate);
	Result updateVerifiedByTrue(int id,int employeeId);
	
}
