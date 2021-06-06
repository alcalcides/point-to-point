package ads.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ads.domain.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
	Optional<People> findById(Long id);

	List<People> findByName(String name);

	List<People> findByEmail(String email);
}
