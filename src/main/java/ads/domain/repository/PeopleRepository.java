package ads.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ads.domain.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
