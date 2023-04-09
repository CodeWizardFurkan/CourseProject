package Kodlama.io.courseProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.courseProject.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.courseProject.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.courseProject.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.courseProject.core.utilities.mapper.ModelMapperService;
import Kodlama.io.courseProject.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.courseProject.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);

		this.languageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		this.languageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		
		List<GetAllProgrammingLanguagesResponse> languageResponses = languages.stream()
				.map(language->this.modelMapperService.forResponse().map(language, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
		
		return languageResponses;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {

		ProgrammingLanguage programmingLanguage = languageRepository.findById(id).orElseThrow();

		GetByIdProgrammingLanguageResponse response = this.modelMapperService.forResponse().map(programmingLanguage,
				GetByIdProgrammingLanguageResponse.class);

		return response;
	}

}
