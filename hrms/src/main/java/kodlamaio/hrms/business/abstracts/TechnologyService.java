package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {
	Result add(TechnologyDto technologyDto);
	Result delete(TechnologyDto technologyDto);
	DataResult<List<Technology>> getAll();
	DataResult<List<Technology>> getByResumeId(int resumeId);
}
