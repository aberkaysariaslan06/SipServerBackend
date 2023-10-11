package sipserver.sipwebserver.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import sipserver.sipwebserver.business.abstracts.DomainService;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.core.results.SuccessDataResult;
import sipserver.sipwebserver.core.results.SuccessResult;
import sipserver.sipwebserver.dataAccess.DomainDao;
import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.concretes.Domain;

@Service
public class DomainManager implements DomainService{
	
	private DomainDao domainDao;
	
	public DomainManager(DomainDao domainDao) {
		super();
		this.domainDao = domainDao;
	}

	@Override
	public DataResult<List<Domain>> getAllDomains() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Domain>>(this.domainDao.findAll(),"Domain Data listelendi");
	}

	@Override
	public DataResult<Domain> getByDomainName(String domainName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Domain>(this.domainDao.getByDomainName(domainName),"Domain Data listelendi");
	}

	@Override
	public DataResult<Domain> getByDomainId(int domainId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Domain>(this.domainDao.getByDomainId(domainId),"Domain Data listelendi");
	}
	public Result add(Domain domain) {
		this.domainDao.save(domain);
		return new SuccessResult("Domain eklendi");
	}

}
