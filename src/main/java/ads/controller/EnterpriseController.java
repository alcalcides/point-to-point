package ads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.domain.model.Enterprises;
import ads.domain.service.EnterpriseService;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping
	public ResponseEntity<List<Enterprises>> list() {
		List<Enterprises> allEnterprise = enterpriseService.getAll();

		if (allEnterprise.size() > 0) {
			return ResponseEntity.ok(allEnterprise);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
