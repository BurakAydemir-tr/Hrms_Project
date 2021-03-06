package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	List<JobExperience> findAllByResume_IdOrderByEndedDateDesc(int id);
	List<JobExperience> getByResumeId(int resumeId);
}
