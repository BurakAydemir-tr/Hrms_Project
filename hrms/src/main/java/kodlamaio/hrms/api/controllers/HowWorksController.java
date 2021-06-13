package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.HowWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.HowWork;

@RestController
@RequestMapping("/api/howWorks")
public class HowWorksController {
	
	private HowWorkService howWorkService;
	
	@Autowired
	public HowWorksController(HowWorkService howWorkService) {
		super();
		this.howWorkService = howWorkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody HowWork howWork) {
		return this.howWorkService.add(howWork);
	}
	
	@GetMapping("/getall")
	public DataResult<List<HowWork>> getAll(){
		return this.howWorkService.getAll();
	}
	
}
