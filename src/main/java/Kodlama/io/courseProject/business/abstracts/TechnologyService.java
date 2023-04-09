package Kodlama.io.courseProject.business.abstracts;

import java.util.List;

import Kodlama.io.courseProject.business.requests.CreateTechnologyRequest;
import Kodlama.io.courseProject.business.requests.UpdateTechnologyRequest;
import Kodlama.io.courseProject.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdTechnologyResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	
	void delete(int id);
	
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	
	List<GetAllTechnologiesResponse> getAll();
	
	GetByIdTechnologyResponse getById(int id);
}
