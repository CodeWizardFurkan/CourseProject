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

import Kodlama.io.courseProject.business.abstracts.TechnologyService;
import Kodlama.io.courseProject.business.requests.CreateTechnologyRequest;
import Kodlama.io.courseProject.business.requests.UpdateTechnologyRequest;
import Kodlama.io.courseProject.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {

	@Autowired
	private TechnologyService technologyService;

	@GetMapping("/getall")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllTechnologiesResponse> getAll() {
		List<GetAllTechnologiesResponse> result = technologyService.getAll();
		return result;
	}

	@GetMapping("/getbyid{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetByIdTechnologyResponse getById(@PathVariable int id) {
		GetByIdTechnologyResponse result = technologyService.getById(id);
		return result;
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);

	}
	
	@PostMapping("/update")
	@ResponseStatus(code = HttpStatus.OK)
	public void add(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);

	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable int id){
		technologyService.delete(id);
	}
}
