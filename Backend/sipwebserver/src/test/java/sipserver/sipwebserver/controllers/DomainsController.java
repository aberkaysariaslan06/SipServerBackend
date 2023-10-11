package sipserver.sipwebserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import sipserver.sipwebserver.business.abstracts.DomainService;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.concretes.Domain;

@RestController
@RequestMapping("/api/domains")
@CrossOrigin
public class DomainsController {
	
	private DomainService domainService;
	
	@Autowired
	public DomainsController(DomainService domainService) {
		super();
		this.domainService = domainService;
		}
	
	@GetMapping("/{domainId}")
	public DataResult<Domain> getByDomainId(@PathVariable int domainId){
		return this.domainService.getByDomainId(domainId);
		}
	
	@GetMapping("/getall")
	public DataResult<List<Domain>> getAllDomains(){  //@RP: bize gelen requestleri parse(ayir) et ve sagindaki degiskenin icine yerlestir
		return this.domainService.getAllDomains();
	}	
	
	@GetMapping("/getByDomainName")
	public DataResult<Domain> getByDomainName(@RequestParam String domainName) {
		return this.domainService.getByDomainName(domainName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Domain domain) {
		return this.domainService.add(domain);
	}
	
}
