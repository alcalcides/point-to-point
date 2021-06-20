package ads.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ads.domain.model.Enterprises;
import ads.domain.repository.EnterpriseRepository;

@Service
public class EnterpriseService {

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	public List<Enterprises> getAll() {
		return enterpriseRepository.findAll();
	}

}
