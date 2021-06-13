package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.HowWork;

public interface HowWorkDao extends JpaRepository<HowWork, Integer>{

}
