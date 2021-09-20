package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserService userService;
	private ValidationService validationService;
	private VerificationService verificationService;
	private ActivationCodeService activationCodeService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService,
			ValidationService validationService,VerificationService verificationService,
			ActivationCodeService activationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userService=userService;
		this.validationService=validationService;
		this.verificationService=verificationService;
		this.activationCodeService=activationCodeService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"iş Arayanlar listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(!this.checkEmptyField(candidate)) {
			return new ErrorResult("Boş alan bırakmayınız.");
			
		}else if(this.checkIfRealPerson(Long.parseLong(candidate.getNationalId()), 
				candidate.getFirstName(), 
				candidate.getLastName())==false){
			return new ErrorResult("TC Kimlik No doğrulanamadı");
			
		}else if(!this.checkEmailExist(candidate.getEmail())) {
			return new ErrorResult("Bu email'e sahip bir iş arayan mevcut");
			
		}else if(!this.getAllByNationalId(candidate.getNationalId()).getData().isEmpty()) {
			return new ErrorResult("TC Kimlik No zaten kayıtlı");
		}
		
		
		this.candidateDao.save(candidate);
		String code=this.verificationService.sendCode();
		activationCodeService.add(new ActivationCode(candidate.getId(),code,false));
		return new SuccessResult("İş arayan kaydı gerçekleştirldi.");
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAllByNationalId(String nationalId) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAllByNationalId(nationalId));
	}
	
	private boolean checkEmptyField(Candidate candidate) {
		if(candidate.getFirstName().isBlank()|| candidate.getLastName().isBlank()||
				candidate.getBirthDate().toString().isBlank()|| candidate.getEmail().isBlank()||
				candidate.getNationalId().isBlank()|| candidate.getPassword().isBlank()) {
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

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName) {
		if(this.validationService.validateByMernis(nationalId, firstName, lastName)) {
			return true;
		}
		return false;
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	
	
	
	
}
