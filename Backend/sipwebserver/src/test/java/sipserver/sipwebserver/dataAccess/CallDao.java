package sipserver.sipwebserver.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.dtos.CallWithDomainDto;




public interface CallDao extends JpaRepository<Call,Integer>{
	/*
	 * SQL Queryde ne yapmak istiyorsak aslinda ona gore yazip cizdik
	 * List olarak yaptıgımızda birden fazla dondurur.
	 */

	
	
	Call getByCallName(String callName);

	Call getByCallId(int callId);

	Call getByCallNameAndDomain_DomainId(String callName, int domainId);

	List<Call> getByCallNameAndCallStatus(String callName, String callStatus);

	List<Call> getByCallNameContains(String callName);

	
	@Query("From Call where callName=:callName and domain.domainId=:domainId" )
	List<Call> getByNameAndDomain(String callName, int domainId);

	void deleteByCallId(int callId);
	
	//@Query("Select ")
	//List<CallWithDomainDto> getCallWithDomainDetails();


	/* 
	 * JPQLq
	 * select * from calls where call_name=bisey and domain_id=bisey
	 */

	//List<Call> findByUserId(Long userId); //findby ile usera ait olan islemler burada birlestirilebilir. findByUserHostName...
}
