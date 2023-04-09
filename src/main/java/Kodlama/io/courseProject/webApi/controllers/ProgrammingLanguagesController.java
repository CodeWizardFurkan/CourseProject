package Kodlama.io.courseProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.courseProject.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.courseProject.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programminglanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {
	
	@Autowired
	private ProgrammingLanguageService programmingLanguageService;
	
	@GetMapping("/getall")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		List<GetAllProgrammingLanguagesResponse> result = programmingLanguageService.getAll();
		return result;
	}
	
	@GetMapping("/getbyid{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetByIdProgrammingLanguageResponse getById(int id) {
		GetByIdProgrammingLanguageResponse result = programmingLanguageService.getById(id);
		return result;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		programmingLanguageService.add(createProgrammingLanguageRequest);
		
	}
	
	@PostMapping("/update")
	@ResponseStatus(code=HttpStatus.OK)
	public void add(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
		programmingLanguageService.update(updateProgrammingLanguageRequest);
		
	}
	
	@DeleteMapping("/delete{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable int id){
		programmingLanguageService.delete(id);
		
	}
}
