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

import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologyRequest;

@RestController
@RequestMapping("/api/programmingLanguageTechnologies")
public class ProgrammingLanguageTechnologiesController {
	
	private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;
	
	@Autowired
	public ProgrammingLanguageTechnologiesController(ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
		this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
	}
	
	@PostMapping("/create")
	public void create(@RequestBody CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		this.programmingLanguageTechnologyService.create(createProgrammingLanguageTechnologyRequest);
	}
	
	@PutMapping("update")
	public void update(@RequestBody UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception{
		this.programmingLanguageTechnologyService.update(updateProgrammingLanguageTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
		this.programmingLanguageTechnologyService.delete(deleteProgrammingLanguageTechnologyRequest);
	}
	
	@GetMapping("{id}")
	GetByIdProgrammingLanguageTechnologyRequest getById(@PathVariable int id) {
		return this.programmingLanguageTechnologyService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll(){
		return this.programmingLanguageTechnologyService.getAll();
	}
}
