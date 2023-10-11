package sipserver.sipwebserver.business.abstracts;

 

import sipserver.sipwebserver.core.entities.User;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;

public interface UserService {
	
	Result add(User user);	
	DataResult<User> getByEmail(String email); //tamam

}
 