package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EduGraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EduGraduate;

@RestController
@RequestMapping("/api/edugraduate")
public class EduGraduatesController {

	private EduGraduateService eduGraduateService;

	@Autowired
	public EduGraduatesController(EduGraduateService eduGraduateService) {
		super();
		this.eduGraduateService = eduGraduateService;
	}
	
	@GetMapping("getall")
	public DataResult<List<EduGraduate>> getAll(){
		return this.eduGraduateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EduGraduate eduGraduate) {
		return this.eduGraduateService.add(eduGraduate);
	}
}
