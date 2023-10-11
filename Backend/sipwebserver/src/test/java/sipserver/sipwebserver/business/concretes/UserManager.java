package sipserver.sipwebserver.business.concretes;

import org.springframework.stereotype.Service;

import sipserver.sipwebserver.business.abstracts.UserService;
import sipserver.sipwebserver.core.dataAccess.UserDao;
import sipserver.sipwebserver.core.entities.User;
import sipserver.sipwebserver.core.results.DataResult;
import sipserver.sipwebserver.core.results.Result;
import sipserver.sipwebserver.core.results.SuccessDataResult;
import sipserver.sipwebserver.core.results.SuccessResult;



@Service
public class UserManager implements UserService {
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Kullanici eklendi ! ");
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email),"Kullanici bulundu");

	
	}

}
