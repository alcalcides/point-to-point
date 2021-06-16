package ads.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ads.domain.exception.BusinessException;
import ads.domain.model.People;
import ads.domain.repository.PeopleRepository;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository peopleRepository;

	public People create(People people) {
		List<People> peopleWithSameEmail = searchByEmail(people.getEmail());
		if (!peopleWithSameEmail.isEmpty()) {
			throw new BusinessException("There is already a person with same email");
		}

		return peopleRepository.save(people);
	}

	public People update(People people) {
		String email = people.getEmail();
		List<People> peopleWithSameEmail = searchByEmail(email);

		Boolean isThereOnlyOnePerson = peopleWithSameEmail.size() == 1;

		if (!isThereOnlyOnePerson) {
			throw new BusinessException("Profile not found");
		} else {
			People peopleTarget = peopleWithSameEmail.get(0);
			Boolean isTheSamePerson = peopleTarget.getId() == people.getId();
			if (!isTheSamePerson) {
				throw new BusinessException("That is not possible to update different profiles");
			} else {
				return peopleRepository.save(people);
			}
		}

	}

	public void delete(Long peopleId) {
		peopleRepository.deleteById(peopleId);
	}

	public List<People> getAll() {
		return peopleRepository.findAll();
	}

	public Optional<People> searchById(Long peopleId) {
		return peopleRepository.findById(peopleId);
	}

	public Boolean isThere(Long peopleId) {
		return peopleRepository.existsById(peopleId);
	}

	public List<People> searchByEmail(String email) {
		return peopleRepository.findByEmail(email);
	}

}
