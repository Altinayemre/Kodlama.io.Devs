package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Repository
public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer>{

}
