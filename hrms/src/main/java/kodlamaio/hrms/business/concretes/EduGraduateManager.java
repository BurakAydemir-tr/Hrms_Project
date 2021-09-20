package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EduGraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EduGraduateDao;
import kodlamaio.hrms.entities.concretes.EduGraduate;

@Service
public class EduGraduateManager implements EduGraduateService{
	
	private EduGraduateDao eduGraduateDao;
	
	@Autowired
	public EduGraduateManager(EduGraduateDao eduGraduateDao) {
		super();
		this.eduGraduateDao = eduGraduateDao;
	}

	@Override
	public Result add(EduGraduate eduGraduate) {
		this.eduGraduateDao.save(eduGraduate);
		return new SuccessResult("Mezuniyet derecesi eklendi.");
	}

	@Override
	public DataResult<List<EduGraduate>> getAll() {
		
		return new SuccessDataResult<List<EduGraduate>>(this.eduGraduateDao.findAll(),"Mezuniyet Dereceleri listelendi");
	}

}
