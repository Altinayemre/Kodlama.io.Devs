package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	void add(ProgrammingLanguage programmingLanguage);

	void delete(int id);

	void update(ProgrammingLanguage programmingLanguage);

	ProgrammingLanguage getById(int id);

	List<ProgrammingLanguage> getAll();
}
