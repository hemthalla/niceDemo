package nice.models;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {

	Task findByTaskName(String taskName);
	Collection<Task> findByStatus(String status);
	Collection<Task> findByAssignedUser(String assignedUser);
	
	Optional<Task> findById(Long id);
	
	Collection<Task> findAll();

}