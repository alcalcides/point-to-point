package ads.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.domain.model.PeopleEntity;

@RestController
public class PeopleController {

	@GetMapping("/people")
	public List<PeopleEntity> createPeople() {
		var p1 = new PeopleEntity();
		p1.setId(1L);
		p1.setName("Alcides");
		p1.setEmail("alcalcides@hotmail.com");

		var p2 = new PeopleEntity();
		p2.setId(2L);
		p2.setName("Isabela");
		p2.setEmail("isabela_costa12@hotmail.com");

		return Arrays.asList(p1, p2);
	}

}
