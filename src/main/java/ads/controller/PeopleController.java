package ads.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.domain.model.People;

@RestController
public class PeopleController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/people")
	public List<People> list() {
		return entityManager.createQuery("from People", People.class).getResultList();
	}

}
