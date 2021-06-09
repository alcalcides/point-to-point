package ads.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		List<People> allPeople = peopleRepository.findAll();

		if (allPeople.size() > 0) {
			return ResponseEntity.ok(allPeople);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{peopleId}")
	public ResponseEntity<People> findById(@Valid @PathVariable Long peopleId) {
		Optional<People> person = peopleRepository.findById(peopleId);

		if (person.isPresent()) {
			return ResponseEntity.ok(person.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public People create(@Valid @RequestBody People people) {
		return peopleRepository.save(people);
	}

	@PutMapping("/{peopleId}")
	public ResponseEntity<People> update(@Valid @PathVariable Long peopleId, @Valid @RequestBody People people) {

		Boolean peopleExists = peopleRepository.existsById(peopleId);
		if (!peopleExists) {
			return ResponseEntity.notFound().build();
		} else {
			people.setId(peopleId);
			peopleRepository.save(people);

			return ResponseEntity.ok().build();
		}

	}

	@DeleteMapping("/{peopleId}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long peopleId) {
		Boolean peopleExists = peopleRepository.existsById(peopleId);
		if (!peopleExists) {
			return ResponseEntity.notFound().build();
		} else {
			peopleRepository.deleteById(peopleId);
			return ResponseEntity.noContent().build();
		}

	}

}
