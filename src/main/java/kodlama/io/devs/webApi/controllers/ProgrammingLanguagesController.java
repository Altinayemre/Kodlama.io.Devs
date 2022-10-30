package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageService.getAll();
	}

	@GetMapping("/getbyid")
	ProgrammingLanguage getById(@RequestParam int id) throws Exception {
		return this.programmingLanguageService.getById(id);
	}

	@PostMapping("/add")
	void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.add(programmingLanguage);
		System.out.println("Eklendi -> " + programmingLanguage.getName());
	}

	@DeleteMapping("/delete")
	void delete(@RequestParam int id) throws Exception {
		this.programmingLanguageService.delete(id);
		System.out.println("Silidi");
	}

	@PutMapping("/update")
	void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.update(programmingLanguage);
		System.out.println("Güncellendi -> " + programmingLanguage.getName());
	}
}
