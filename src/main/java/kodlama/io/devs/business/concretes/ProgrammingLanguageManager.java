package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		IsProgrammingLanguageBlank(programmingLanguage);
		if (IsExistId(programmingLanguage.getId())) throw new Exception("Giridğiniz id sistemde kayıtlı!");
		this.programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {
		if (!IsExistId(id)) throw new Exception("İd bulunamadı!");
		this.programmingLanguageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		IsProgrammingLanguageBlank(programmingLanguage);
		if (!IsExistId(programmingLanguage.getId())) throw new Exception("İd bulunamadı!");
		this.programmingLanguageRepository.update(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if (!IsExistId(id)) throw new Exception("İd bulunamadı!");
		return this.programmingLanguageRepository.getById(id);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageRepository.getAll();
	}

	private void IsProgrammingLanguageBlank(ProgrammingLanguage programmingLanguage) throws Exception {

		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}

		for (ProgrammingLanguage language : getAll()) {
			if (language.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Tanımladığınız programlama dili zaten mevcut!");
			}
		}
	}

	private boolean IsExistId(int id) {
		for (ProgrammingLanguage programmingLanguage : getAll()) {
			if (programmingLanguage.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
