package ads.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ads.domain.model.Enterprises;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprises, Long> {

	List<Enterprises> findByCnpj(String cnpj);

}
