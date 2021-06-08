package ads.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ads.domain.model.People;
import ads.domain.repository.PeopleRepository;

@RestController
@RequestMapping("/people")
public class PeopleController {

	@Autowired
	private PeopleRepository peopleRepository;

	@GetMapping
	public ResponseEntity<List<People>> list() {
		if (peopleRepository.findAll().size() > 0) {
			return ResponseEntity.ok(peopleRepository.findAll());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{peopleId}")
	public ResponseEntity<People> findById(@PathVariable Long peopleId) {
		Optional<People> person = peopleRepository.findById(peopleId);
		if (person.isPresent()) {
			return ResponseEntity.ok(person.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public People create(@RequestBody People people) {
		return peopleRepository.save(people);
	}

}
