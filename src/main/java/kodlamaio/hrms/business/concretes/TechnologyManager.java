package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,DtoConverterService dtoConverterService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		this.technologyDao.save((Technology)dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Teknoloji eklendi.");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(),"Teknolojiler listelendi.");
	}

	
	@Override
	public Result delete(TechnologyDto technologyDto) {
		this.technologyDao.delete((Technology)dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Teknoloji silindi");
	}

	@Override
	public DataResult<List<Technology>> getByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<Technology>>(this.technologyDao.getByResumeId(resumeId),"Teknolojiler listelendi");
	}

}
