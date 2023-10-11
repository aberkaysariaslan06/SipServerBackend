package sipserver.sipwebserver.controllers;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sipserver.sipwebserver.business.abstracts.DomainService;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.entities.concretes.Domain;





@RestController	
@RequestMapping("/api/domains")
@CrossOrigin
public class DomainController {
	private DomainService domainService;
	
	

}
