package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService) {
		super();
		this.languageDao = languageDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		
		this.languageDao.save((Language)dtoConverterService.dtoClassConverter(languageDto, Language.class));
		return new SuccessResult("Dil eklendi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Diller listelendi");
	}

	@Override
	public DataResult<List<Language>> getByResumeId(int resumeId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByResumeId(resumeId),"Diller listelendi");
	}

	@Override
	public Result delete(LanguageDto languageDto) {
		this.languageDao.delete((Language)dtoConverterService.dtoClassConverter(languageDto, Language.class));
		return new SuccessResult("Dil silindi");
	}

}
