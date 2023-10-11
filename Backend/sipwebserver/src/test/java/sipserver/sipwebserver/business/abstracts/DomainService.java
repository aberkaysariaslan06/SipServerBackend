package sipserver.sipwebserver.business.abstracts;

import java.util.List;

import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.concretes.Domain;

public interface DomainService {
	
	DataResult<List<Domain>> getAllDomains(); //getAll()
	DataResult<Domain> getByDomainName(String domainName); //tamam
	DataResult<Domain> getByDomainId(int domainId);	
	Result add(Domain domain);
}
