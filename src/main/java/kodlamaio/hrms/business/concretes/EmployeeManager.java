package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private UserService userService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,UserService userService) {
		super();
		this.employeeDao = employeeDao;
		this.userService=userService;
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan kaydı gerçekleşti.");
	}

	@Override
	public DataResult<Employee> getById(int id) {
		
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
	//---------Business Rules-------
	
	private boolean checkEmailExist(String email) {
		if(this.userService.getUsersByEmail(email).getData().isEmpty()) {
			return true;
		}
		return false;
	}

}
