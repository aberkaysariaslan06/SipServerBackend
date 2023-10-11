package sipserver.sipwebserver.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sipserver.sipwebserver.business.abstracts.CallService;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.ErrorResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.core.results.SuccessDataResult;
import sipserver.sipwebserver.core.results.SuccessResult;
import sipserver.sipwebserver.dataAccess.CallDao;
import sipserver.sipwebserver.entities.concretes.Call;


@Service
public class CallManager implements CallService {
	
	private CallDao callDao;
	
	@Autowired
	public CallManager(CallDao callDao) {
		super();
		this.callDao = callDao;

	}

	@Override
	public DataResult<List<Call>> getAllCalls() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Call>>(this.callDao.findAll(),"Call Data listelendi");
	}

	@Override
	public DataResult<List<Call>> getAllSorted() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.ASC, "callName");
		return new SuccessDataResult<List<Call>>(this.callDao.findAll(sort),"Sort operasyonu basarili");
	}

	

	@Override
	public Result add(Call call) {
		this.callDao.save(call);
		return new SuccessResult("Call eklendi");
	}

	@Override
	public DataResult<Call> getByCallName(String callName) {
		return new SuccessDataResult<Call>(this.callDao.getByCallName(callName),"Call Data listelendi");
		
	}

	@Override
	public DataResult<Call> getByCallId(int callId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Call>(this.callDao.getByCallId(callId),"Call Data listelendi");
	}
	
	@Override
	public DataResult<Call> getByCallNameAndDomainId(String callName, int domainId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Call>(this.callDao.getByCallNameAndDomain_DomainId(callName,domainId)," Call Data listelendi");
	} 

	@Override
	public DataResult<List<Call>> getByCallNameAndCallStatus(String callName, String callStatus) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Call>>(this.callDao.getByCallNameAndCallStatus(callName, callStatus ),"Call Data listelendi");
	}

	@Override
	public DataResult<List<Call>> getByCallNameContains(String callName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Call>>(this.callDao.getByCallNameContains(callName),"Call Data listelendi");
	}

	@Override
	public DataResult<List<Call>> getByNameAndDomain(String callName, int domainId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Call>>(this.callDao.getByNameAndDomain(callName, domainId),"Call Data listelendi");
	}
	@Override
	public DataResult<List<Call>> getAllByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Call>>(this.callDao.findAll(pageable).getContent());
	}
	/*
	@Override
	public DataResult<List<CallWithDomainDto>> getCallWithDomainDetails() {
		return new SuccessDataResult<List<CallWithDomainDto>>(this.callDao.getCallWithDomainDetails(),"Call Data listelendi");
	}
	*/

	@Override
	public Result deleteByCallId(int callId) {
		// TODO Auto-generated method stub
		Call existingCall = this.callDao.getByCallId(callId);
		   if (existingCall == null) {
		        return new ErrorResult("Belirtilen Call bulunamadı");
		    }
		   this.callDao.delete(existingCall);
		return new SuccessResult("Call silme islemi basarili");
	}
	}




 
