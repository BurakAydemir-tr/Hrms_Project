package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HowWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.HowWorkDao;
import kodlamaio.hrms.entities.concretes.HowWork;

@Service
public class HowWorkManager implements HowWorkService{

	private HowWorkDao howWorkDao;
	
	@Autowired
	public HowWorkManager(HowWorkDao howWorkDao) {
		super();
		this.howWorkDao = howWorkDao;
	}

	@Override
	public DataResult<List<HowWork>> getAll() {
		
		return new SuccessDataResult<List<HowWork>>(this.howWorkDao.findAll(),"Çalışma zamanı listelendi.");
	}

	@Override
	public Result add(HowWork howWork) {
		this.howWorkDao.save(howWork);
		return new SuccessResult("Çalışma zamanı eklendi");
	}

}
