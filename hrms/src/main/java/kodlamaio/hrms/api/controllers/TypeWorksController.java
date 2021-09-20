package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TypeWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.TypeWork;

@RestController
@RequestMapping("/api/typeWorks")
@CrossOrigin
public class TypeWorksController {
	
	private TypeWorkService typeWorkService;

	@Autowired
	public TypeWorksController(TypeWorkService typeWorkService) {
		super();
		this.typeWorkService = typeWorkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody TypeWork typeWork) {
		return this.typeWorkService.add(typeWork);
	}
	
	@GetMapping("/getall")
	public DataResult<List<TypeWork>> getAll(){
		return this.typeWorkService.getAll();
	}
}
