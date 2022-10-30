package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		this.programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Pyhton"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		var programmingLanguage = getById(id);
		if (programmingLanguage != null) {
			this.programmingLanguages.remove(programmingLanguage);
		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == programmingLanguage.getId()) {
				language.setName(programmingLanguage.getName());
				break;
			}
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

}
