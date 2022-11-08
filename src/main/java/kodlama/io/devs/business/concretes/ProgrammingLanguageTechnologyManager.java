package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository,ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void create(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		if(createProgrammingLanguageTechnologyRequest.getTechnologyName().isBlank()) {
			throw new Exception("Boş değer girilemez!");
		} else if(isExistTechnologyName(createProgrammingLanguageTechnologyRequest.getTechnologyName())){
			throw new Exception("Sistem de böyle bir kayıt mevcuttur!");
		}
		
		ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(createProgrammingLanguageTechnologyRequest.getProgrammingLanguageId()).get();
		programmingLanguageTechnology.setTechnologyName(createProgrammingLanguageTechnologyRequest.getTechnologyName());
		programmingLanguageTechnology.setProgrammingLanguage(programmingLanguage);
		
		this.programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
	}
	
	@Override
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		if(updateProgrammingLanguageTechnologyRequest.getTechnologyName().isBlank()) {
			throw new Exception("Boş değer girilemez!");
		} else if (isExistTechnologyName(updateProgrammingLanguageTechnologyRequest.getTechnologyName())) {
			throw new Exception("Sistem de böyle bir kayıt mevcuttur!");
		}
		
		ProgrammingLanguageTechnology programmingLanguageTechnology = this.programmingLanguageTechnologyRepository.findById(updateProgrammingLanguageTechnologyRequest.getTechnologyId()).get();
		programmingLanguageTechnology.setTechnologyName(updateProgrammingLanguageTechnologyRequest.getTechnologyName());
		this.programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
	}

	
	@Override
	public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
		this.programmingLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getTechnologyId());
	}
	
	@Override
	public GetByIdProgrammingLanguageTechnologyRequest getById(int id) {
		ProgrammingLanguageTechnology programmingLanguageTechnology = this.programmingLanguageTechnologyRepository.findById(id).get();
		GetByIdProgrammingLanguageTechnologyRequest response = new GetByIdProgrammingLanguageTechnologyRequest();
		response.setTechnologyId(programmingLanguageTechnology.getTechonologyId());
		response.setTechnologyName(programmingLanguageTechnology.getTechnologyName());
		response.setProgrammingLanguageName(programmingLanguageTechnology.getProgrammingLanguage().getProgrammingLanguageName());
		return response;
	}

	@Override
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = this.programmingLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologyResponse> getAllProgrammingLanguageTechnologyResponses = new ArrayList<GetAllProgrammingLanguageTechnologyResponse>();

		for (ProgrammingLanguageTechnology languageTechnology : programmingLanguageTechnologies) {
			GetAllProgrammingLanguageTechnologyResponse responseItem = new GetAllProgrammingLanguageTechnologyResponse();
			responseItem.setTechnologyId(languageTechnology.getTechonologyId());
			responseItem.setTechnologyName(languageTechnology.getTechnologyName());
			responseItem.setProgrammingLanguageName(languageTechnology.getProgrammingLanguage().getProgrammingLanguageName());
			getAllProgrammingLanguageTechnologyResponses.add(responseItem);
		}
		return getAllProgrammingLanguageTechnologyResponses;
	}
	
	private boolean isExistTechnologyName(String name) {
		for(ProgrammingLanguageTechnology languageTechnology:programmingLanguageTechnologyRepository.findAll()) {
			if(languageTechnology.getTechnologyName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
