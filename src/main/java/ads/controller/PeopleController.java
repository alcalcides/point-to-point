package ads.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<People>> list() {
		if (peopleRepository.findAll().size() > 0) {
			return ResponseEntity.ok(peopleRepository.findAll());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/people/{peopleId}")
	public ResponseEntity<People> findById(@PathVariable Long peopleId) {
		Optional<People> person = peopleRepository.findById(peopleId);
		if (person.isPresent()) {
			return ResponseEntity.ok(person.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
