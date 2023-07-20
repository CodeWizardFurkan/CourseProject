package Kodlama.io.courseProject.business.abstracts;

import java.util.List;

import Kodlama.io.courseProject.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	
	void delete(int id);
	
	

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	
	GetByIdProgrammingLanguageResponse getById(int id);
}
