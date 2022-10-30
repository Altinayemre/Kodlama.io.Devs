package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	void add(ProgrammingLanguage programmingLanguage) throws Exception;

	void delete(int id) throws Exception;

	void update(ProgrammingLanguage programmingLanguage) throws Exception;

	ProgrammingLanguage getById(int id) throws Exception;

	List<ProgrammingLanguage> getAll();
}
