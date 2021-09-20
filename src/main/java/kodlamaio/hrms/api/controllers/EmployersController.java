package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerService.update(employerUpdate);
	}
	
	@PostMapping("/updateVerifiedByTrue")
	public Result updateVerifiedByTrue(@RequestParam int id,@RequestParam int employeeId) {
		return this.employerService.updateVerifiedByTrue(id, employeeId);
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("/findAllByVerifiedFalse")
	public DataResult<List<EmployerUpdate>> findAllByVerifiedFalse(){
		return this.employerService.findAllByVerifiedFalse();
	}
}
