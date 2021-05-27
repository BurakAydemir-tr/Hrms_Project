package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;
	private VerificationService verificationService;
	private ActivationCodeService activationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, 
			VerificationService verificationService, ActivationCodeService activationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userService=userService;
		this.verificationService=verificationService;
		this.activationCodeService=activationCodeService;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		if(!this.checkEmptyField(employer)) {
			return new ErrorResult("Boş alan bırakmayınız.");
			
		}else if(!this.emailFormatValid(employer.getEmail())) {
			return new ErrorResult("Geçersiz email.");
			
		}else if(!this.checkEqualEmailAndDomain(employer.getEmail(), employer.getWebAdress())) {
			return new ErrorResult("Web site ile email aynı domain de değil");
			
		}else if(!this.checkEmailExist(employer.getEmail())) {
			return new ErrorResult("Email zaten kayıtlı.");
		}
		
		
		
		this.employerDao.save(employer);
		String code=this.verificationService.sendCode();
		activationCodeService.add(new ActivationCode(employer.getId(),code,false));
		this.verificationService.emailVerification();
		return new SuccessResult("İşveren eklendi");
		
		
	}
	
	private boolean checkEmptyField(Employer employer) {
		if(employer.getCompanyName().isBlank()|| employer.getEmail().isBlank()||
				employer.getPassword().isBlank()||employer.getPhoneNumber().isBlank()||
				employer.getWebAdress().isBlank()) {
			return false;
		}
		return true;
	}
	
	private boolean checkEmailExist(String email) {
		if(this.userService.getUsersByEmail(email).getData().isEmpty()) {
			return true;
		}
		return false;
	}
	
	private boolean emailFormatValid(String email) {
		return Pattern.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]+", email);
	}
	
	private boolean checkEqualEmailAndDomain(String email,String website) {
		int index=email.indexOf("@");
		int indexWeb=website.indexOf(".");
		String emailDomain=email.substring(index+1);
		String webDomain=website.substring(indexWeb+1);
		if(emailDomain.equals(webDomain)) {
			return true;
		}
		return false;
		
	}

}
