package nice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nice.controllers.CreateTaskRequest;
import nice.models.Task;
import nice.models.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	public Iterable<Task> findAll() {
		return taskRepository.findAll();
	}


	@Transactional
	public Task findByIdOrTaskName(String idOrTaskName) {
		Task task;

		try {
			Long id = new Long(idOrTaskName);

			Optional<Task> optional = taskRepository.findById(id);            
			task = optional.get(); 		

		} catch (Exception e) {
			task = null;
		}

		if (task == null) {
			task = taskRepository.findByTaskName(idOrTaskName);
		}

		return task;
	}

	@Transactional
	public Task createTask(CreateTaskRequest request) {
		
		Task task = new Task(request.getTaskName(), request.getDescription(), request.getStatus(), request.getAssignedUser());
		return taskRepository.save(task);
	}

	@Transactional
	public Task updateTask(Long id, CreateTaskRequest request) {
		
		try {
			Optional<Task> optional = taskRepository.findById(id);            
			Task  task = optional.get(); 		

			task.setAssignedUser(request.getAssignedUser());
			task.setDescription(request.getDescription());
			task.setStatus(request.getStatus());
			
			return taskRepository.save(task);
		} catch (Exception e) {
			return null;
		}
	}



	
}