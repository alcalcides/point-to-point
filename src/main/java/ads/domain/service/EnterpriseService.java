package ads.domain.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ads.domain.exception.BusinessException;
import ads.domain.model.Enterprises;
import ads.domain.repository.EnterpriseRepository;

@Service
public class EnterpriseService {

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	public List<Enterprises> getAll() {
		return enterpriseRepository.findAll();
	}

	public Enterprises create(@Valid Enterprises enterprise) {
		List<Enterprises> enterprisesWithSameCnpj = searchByCnpj(enterprise.getCnpj());

		if (!enterprisesWithSameCnpj.isEmpty()) {
			throw new BusinessException("There is already a enterprise with same cnpj");
		}

		return enterpriseRepository.save(enterprise);
	}

	public List<Enterprises> searchByCnpj(String cnpj) {
		return enterpriseRepository.findByCnpj(cnpj);
	}

}
