package ads.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ads.domain.model.Enterprises;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprises, Long> {

}
