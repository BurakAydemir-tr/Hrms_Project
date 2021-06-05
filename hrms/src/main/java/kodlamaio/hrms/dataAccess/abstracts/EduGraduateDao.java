package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EduGraduate;

public interface EduGraduateDao extends JpaRepository<EduGraduate, Integer>{

}
