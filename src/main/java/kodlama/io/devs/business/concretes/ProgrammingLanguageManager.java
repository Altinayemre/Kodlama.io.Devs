package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageWithTechnologyResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetOnlyProgrammingTechnologyNameResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
	}


	@Override
	public void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if (createProgrammingLanguageRequest.getProgrammingLanguageName().isBlank()) {
			throw new Exception("Boş değer girilemez!");
		} else if (isExistProgrammingLanguage(createProgrammingLanguageRequest.getProgrammingLanguageName())) {
			throw new Exception("Sistem de böyle bir kayıt mevcuttur!");
		}

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setProgrammingLanguageName(createProgrammingLanguageRequest.getProgrammingLanguageName());
		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception {
		if (updateProgramingLanguageRequest.getProgrammingLanguageName().isBlank()) {
			throw new Exception("Boş değer girilemez!");
		} else if (isExistProgrammingLanguage(updateProgramingLanguageRequest.getProgrammingLanguageName())) {
			throw new Exception("Sistem de böyle bir kayıt mevcuttur!");
		}

		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(updateProgramingLanguageRequest.getProgrammingLanguageId()).get();
		programmingLanguage.setProgrammingLanguageName(updateProgramingLanguageRequest.getProgrammingLanguageName());
		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		this.programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getProgrammingLanguageId());

	}
	
	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguages = this.programmingLanguageRepository.findById(id).get();
		GetByIdProgrammingLanguageResponse responseItem = new GetByIdProgrammingLanguageResponse();
		responseItem.setProgrammingLanguageId(programmingLanguages.getProgrammingLanguageId());
		responseItem.setProgrammingLanguageName(programmingLanguages.getProgrammingLanguageName());
		return responseItem;

	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<GetAllProgrammingLanguageResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setProgrammingLanguageId(programmingLanguage.getProgrammingLanguageId());
			responseItem.setProgrammingLanguageName(programmingLanguage.getProgrammingLanguageName());
			programmingLanguageResponses.add(responseItem);
		}
		return programmingLanguageResponses;
	}
	
	@Override
	public List<GetAllProgrammingLanguageWithTechnologyResponse> getAllWithTechnologyName() {
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies =this.programmingLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageWithTechnologyResponse> getAllWithTechnologyResponses = new ArrayList<GetAllProgrammingLanguageWithTechnologyResponse>();
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			GetAllProgrammingLanguageWithTechnologyResponse response = new GetAllProgrammingLanguageWithTechnologyResponse();
			response.setProgrammingLanguageId(programmingLanguage.getProgrammingLanguageId());
			response.setProgrammingLanguageName(programmingLanguage.getProgrammingLanguageName());
		
			List<GetOnlyProgrammingTechnologyNameResponse> getOnlyTechnologyNameResponses = new ArrayList<GetOnlyProgrammingTechnologyNameResponse>();
			for(ProgrammingLanguageTechnology programmingLanguageTechnology:programmingLanguageTechnologies) {
				if(programmingLanguageTechnology.getProgrammingLanguage().getProgrammingLanguageId()==programmingLanguage.getProgrammingLanguageId()) {
					GetOnlyProgrammingTechnologyNameResponse technologyResponse = new GetOnlyProgrammingTechnologyNameResponse();
					technologyResponse.setTechnologyName(programmingLanguageTechnology.getTechnologyName());
					getOnlyTechnologyNameResponses.add(technologyResponse);
				}
			}
			response.setTechnologyNames(getOnlyTechnologyNameResponses);
			getAllWithTechnologyResponses.add(response);
		}
		return getAllWithTechnologyResponses;
	}
	
	private boolean isExistProgrammingLanguage(String name) {
		for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
			if (language.getProgrammingLanguageName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
