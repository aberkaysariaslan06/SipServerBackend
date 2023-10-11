package sipserver.sipwebserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sipserver.sipwebserver.business.abstracts.CallService;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.entities.concretes.Call;
import sipserver.sipwebserver.entities.dtos.CallWithDomainDto;

@RestController
@RequestMapping("/api/calls")
@CrossOrigin
public class CallsController {
	
	
	private CallService callService;
	@Autowired
	public CallsController(CallService callService) {
		super();
		this.callService = callService;
	}
	@GetMapping("/{callId}")
	public DataResult<Call> getByCallId(@PathVariable int callId){
		return this.callService.getByCallId(callId);		

	}
	@DeleteMapping("/{callId}")
	public Result deleteByCallId(@PathVariable int callId) {
		return callService.deleteByCallId(callId);
	}


	@GetMapping("/getall")
	public DataResult<List<Call>> getAllCalls(){  //@RP: bize gelen requestleri parse(ayir) et ve sagindaki degiskenin icine yerlestir
		return this.callService.getAllCalls();
	}	

	@PostMapping("/add")
	public Result add(@RequestBody Call call) {
		return this.callService.add(call);
	}
	
	@GetMapping("/getByCallName")
	public DataResult<Call> getByCallName(@RequestParam String callName) {
		return this.callService.getByCallName(callName);
	}
	
	@GetMapping("/getByCallNameAndDomainId")
	public DataResult<Call> getByCallNameAndDomainId(@RequestParam("callName") String callName, @RequestParam ("domainId") int domainId) {
		System.out.println(callName);
		System.out.println(domainId);
		return this.callService.getByCallNameAndDomainId(callName, domainId);
	} 	
	
	@GetMapping("/getByCallNameContains")
	public DataResult<List<Call>> getByCallNameContains(@RequestParam String callName){
		return this.callService.getByCallNameContains(callName);

	}
	@GetMapping("/getByCallNameAndCallStatus")
	public DataResult<List<Call>> getByCallNameAndCallStatus(@RequestParam String callName, @RequestParam String callStatus) {
		return this.callService.getByCallNameAndCallStatus(callName, callStatus);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Call>> getAllByPage(int pageNo, int pageSize) { 
		return this.callService.getAllByPage(pageNo, pageSize);
	}

	@GetMapping("/getAllSorted")
	public DataResult<List<Call>> getAllSorted() {
		return this.callService.getAllSorted();

	}
	/*
	@GetMapping("/getCallWithDomainDetails")
	public DataResult<List<CallWithDomainDto>> getCallWithDomainDetails() {
		return this.callService.getCallWithDomainDetails();
		
	} */
	

}

