package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageWithTechnologyResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	GetByIdProgrammingLanguageResponse getById(int id);
	List<GetAllProgrammingLanguageWithTechnologyResponse> getAllWithTechnologyName();
	List<GetAllProgrammingLanguageResponse> getAll();
}
