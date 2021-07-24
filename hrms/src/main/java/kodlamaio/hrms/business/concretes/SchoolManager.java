package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao,DtoConverterService dtoConverterService) {
		super();
		this.schoolDao = schoolDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(School school) {
		//School newSchool=new School();
		//newSchool=(School)dtoConverterService.dtoClassConverter(schoolDto,School.class);
		this.schoolDao.save(school);
		//this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi.");
	}

	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi.");
	}

	@Override
	public DataResult<List<School>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAllByResumeIdOrderByEndedDateDesc(id),"Okullar listelendi.");
	}

	@Override
	public Result delete(School school) {
		this.schoolDao.delete(school);
		return new SuccessResult("Okul silindi");
	}

	
	@Override
	public DataResult<List<School>> getByResumeId(int resumeId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByResumeId(resumeId),"Okullar listelendi");
	}}
