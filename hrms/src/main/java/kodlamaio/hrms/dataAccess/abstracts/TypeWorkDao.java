package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TypeWork;

public interface TypeWorkDao extends JpaRepository<TypeWork, Integer>{

}
