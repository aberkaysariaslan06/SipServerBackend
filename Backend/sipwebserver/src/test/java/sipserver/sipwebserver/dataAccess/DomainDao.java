package sipserver.sipwebserver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sipserver.sipwebserver.entities.concretes.Domain;

public interface DomainDao extends JpaRepository<Domain, Integer> {
	Domain getByDomainName(String domainName);

	Domain getByDomainId(int domainId);

}
