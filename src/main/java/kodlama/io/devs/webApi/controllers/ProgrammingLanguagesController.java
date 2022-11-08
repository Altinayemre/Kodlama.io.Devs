package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguageWithTechnologyResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("/create")
	void create(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.create(createProgrammingLanguageRequest);
		System.out.println("Eklendi -> " + createProgrammingLanguageRequest.getProgrammingLanguageName());
	}

	@PutMapping("/update")
	void update(@RequestBody UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception {
		this.programmingLanguageService.update(updateProgramingLanguageRequest);
		System.out.println("Güncellendi -> " + updateProgramingLanguageRequest.getProgrammingLanguageName());
	}

	@DeleteMapping("/delete")
	void delete(@RequestBody DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}

	@GetMapping("/getall")
	List<GetAllProgrammingLanguageResponse> getAll() {
		return this.programmingLanguageService.getAll();
	}

	@GetMapping("{id}")
	GetByIdProgrammingLanguageResponse getById(@PathVariable int id) {
		return this.programmingLanguageService.getById(id);
	}
	
	@GetMapping("/getallwithtechnology")
	public List<GetAllProgrammingLanguageWithTechnologyResponse> getAllWithTechnologyName(){
		return this.programmingLanguageService.getAllWithTechnologyName();
	}

}
