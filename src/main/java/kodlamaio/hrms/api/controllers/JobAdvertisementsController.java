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

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertFilter;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertDto jobAdvertDto) {
		return this.jobAdvertisementService.add(jobAdvertDto);
	}
	
	@GetMapping("/findAllByIsActivated")
	public DataResult<List<JobAdvertisement>> findAllByIsActivated(@RequestParam boolean isActivated){
		return this.jobAdvertisementService.findAllByIsActivated(isActivated);
	}
	
	@GetMapping("/findAllByIsActivatedOrderByCreatedDate")
	public DataResult<List<JobAdvertisement>> findAllByIsActivatedTrueOrderByCreatedDate(){
		return this.jobAdvertisementService.findAllByIsActivatedTrueOrderByCreatedDate();
	}
	
	@GetMapping("/findAllIsActivatedAndEmployer")
	public DataResult<List<JobAdvertisement>>  findAllIsActivatedAndEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.findAllIsActivatedAndEmployer(employerId);
	}
	
	@GetMapping("/findAllByEmployer")
	public DataResult<List<JobAdvertisement>>  findAllByEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.findAllByEmployerId(employerId);
	}
	
	@GetMapping("/findAllIsActivatedFalse")
	public DataResult<List<JobAdvertisement>> findAllByIsActivatedFalse(){
		return this.jobAdvertisementService.findAllByIsActivatedFalse();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getCountJobAdvert")
	public DataResult<Integer> getCountJobAdvert(){
		return this.jobAdvertisementService.getCountJobAdvert();
	}
	
	@PostMapping("/confirmIsActivate")
	public Result confirmIsActivated(@RequestParam int id) {
		return this.jobAdvertisementService.confirmIsActivated(id);
	}
	
	@PostMapping("/getFilterAndPage")
	public DataResult<List<JobAdvertisement>> getFilterAndPage(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertFilter jobAdvertFilter){
		return this.jobAdvertisementService.getFilterAndPage(pageNo, pageSize, jobAdvertFilter);
	}
}
