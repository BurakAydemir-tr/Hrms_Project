package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findAllByIsActivated(boolean isActivated);
	List<JobAdvertisement> findAllByIsActivatedTrueOrderByCreatedDate();
	List<JobAdvertisement> findAllByIsActivatedFalse();
	JobAdvertisement getById(int id);
	
	@Query("From JobAdvertisement where isActivated = true and employer_id =:employerId")
	List<JobAdvertisement> findAllIsActivatedAndEmployer(int employerId);
	List<JobAdvertisement> findAllByEmployerId(int employerId);
	
	@Query("Select j from JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ "and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
			+ "and ((:#{#filter.typeWorkId}) IS NULL OR j.typeWork.id IN (:#{#filter.typeWorkId}))"
			+ "and ((:#{#filter.howWorkId}) IS NULL OR j.howWork.id IN (:#{#filter.howWorkId}))")
	public Page<JobAdvertisement> getByFilter(@Param("filter")JobAdvertFilter jobAdvertFilter,Pageable pageable);
	
}
