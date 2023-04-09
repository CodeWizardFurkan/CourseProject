package Kodlama.io.courseProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.courseProject.business.abstracts.TechnologyService;
import Kodlama.io.courseProject.business.requests.CreateTechnologyRequest;
import Kodlama.io.courseProject.business.requests.UpdateTechnologyRequest;
import Kodlama.io.courseProject.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.courseProject.business.responses.GetByIdTechnologyResponse;
import Kodlama.io.courseProject.core.utilities.mapper.ModelMapperService;
import Kodlama.io.courseProject.dataAccess.abstracts.TechnolgyRepository;
import Kodlama.io.courseProject.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

	private TechnolgyRepository technologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);

		technologyRepository.save(technology);

	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);

		technologyRepository.save(technology);

	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();

		List<GetAllTechnologiesResponse> getAllTechnologiesResponses = technologies.stream()
				.map(technology -> modelMapperService.forResponse().map(technology, GetAllTechnologiesResponse.class))
				.toList();

		return getAllTechnologiesResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology =
				technologyRepository.findById(id).orElseThrow(() -> 
					new RuntimeException("Technology not found"));
		GetByIdTechnologyResponse getByIdTechnologyResponse =
				modelMapperService.forResponse().map(technology, GetByIdTechnologyResponse.class);
		
		return getByIdTechnologyResponse;
	}

}
