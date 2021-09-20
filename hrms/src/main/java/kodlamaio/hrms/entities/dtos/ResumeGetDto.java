package kodlamaio.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Technology;

public class ResumeGetDto {
	
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedLink;
	private String photo;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private List<JobExperience> jobExperiences;
	private List<School> schools;
	private List<Language> languages;
	private List<Technology> technologies;
}
