package ads.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ads.domain.model.People;
import ads.domain.repository.PeopleRepository;

@RestController
public class PeopleController {

	@Autowired
	private PeopleRepository peopleRepository;

	@GetMapping("/people")
	public List<People> list() {
		return peopleRepository.findAll();
	}

	@GetMapping("/people/{peopleId}")
	public People findById(@PathVariable Long peopleId) {
		Optional<People> person = peopleRepository.findById(peopleId);
		return person.orElse(null);
	}

}
