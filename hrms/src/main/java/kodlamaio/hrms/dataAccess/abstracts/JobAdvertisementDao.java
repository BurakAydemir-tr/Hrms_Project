package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findAllByIsActivated(boolean isActivated);
	List<JobAdvertisement> findAllByIsActivatedTrueOrderByCreatedDate();
	
	@Query("From JobAdvertisement where isActivated = true and employer_id =:employerId")
	List<JobAdvertisement> findAllIsActivatedAndEmployer(int employerId);
	
}
