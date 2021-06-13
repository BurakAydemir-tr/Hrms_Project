package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TypeWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeWorkDao;
import kodlamaio.hrms.entities.concretes.TypeWork;

@Service
public class TypeWorkManager implements TypeWorkService{

	private TypeWorkDao typeWorkDao;
	
	@Autowired
	public TypeWorkManager(TypeWorkDao typeWorkDao) {
		super();
		this.typeWorkDao = typeWorkDao;
	}

	@Override
	public DataResult<List<TypeWork>> getAll() {
		
		return new SuccessDataResult<List<TypeWork>>(this.typeWorkDao.findAll(),"Çalışma türü listelendi.");
	}

	@Override
	public Result add(TypeWork typeWork) {
		this.typeWorkDao.save(typeWork);
		return new SuccessResult("Çalışma türü eklendi");
	}

}
