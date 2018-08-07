package nice.models;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);
	Optional<User> findById(Long id);
	
	//Collection<User> findAll();

}