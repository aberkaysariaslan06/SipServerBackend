package sipserver.sipwebserver.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sipserver.sipwebserver.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String mail);

}
