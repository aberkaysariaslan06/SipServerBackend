package sipserver.sipwebserver.business.abstracts;

import java.util.List;

import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.dtos.CallWithDomainDto;

public interface CallService {	
	
	DataResult<List<Call>> getAllCalls(); //getAll()
	DataResult<List<Call>> getAllSorted(); //getAll()
	DataResult<List<Call>> getAllByPage(int pageNo, int pageSize); //siralama ve sayf
	Result add(Call call);
	DataResult<Call> getByCallName(String callName); //tamam
	DataResult<Call> getByCallId(int callId);		//tamam
	DataResult<Call> getByCallNameAndDomainId(String callName, int domainId); //tamam
	Result deleteByCallId(int callId);
	
	DataResult<List<Call>> getByCallNameAndCallStatus(String callName, String callStatus); //tamam
	DataResult<List<Call>> getByCallNameContains(String callName); //tamam
	DataResult<List<Call>> getByNameAndDomain(String callName, int domainId);
	//DataResult<List<CallWithDomainDto>> getCallWithDomainDetails();

}

