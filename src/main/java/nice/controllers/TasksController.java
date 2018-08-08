package nice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nice.models.Task;
import nice.services.TaskService;


@Controller
@EnableAutoConfiguration
public class TasksController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value="/tasks", method=RequestMethod.GET)
	@ResponseBody
	Iterable<Task> getAllTasks() {
		return taskService.findAll();
	}

	@RequestMapping(value = "/tasks/{id}", method=RequestMethod.GET)
	@ResponseBody
	Task getTaskByIdOrTaskName(@PathVariable("id") String idOrTaskName) {
		return taskService.findByIdOrTaskName(idOrTaskName);
	}

	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	@ResponseBody
	Task createTask(@RequestBody CreateTaskRequest request) {
		return taskService.createTask(request);
	}

	@RequestMapping(value="/tasks/{id}", method=RequestMethod.PUT)
	@ResponseBody
	Task updateTask(@PathVariable("id") Long id, @RequestBody CreateTaskRequest request) {
		return taskService.updateTask(id, request);
	}
	
	
	@RequestMapping(value = "/tasks/status/{status}", method=RequestMethod.GET)
	@ResponseBody
	Iterable<Task> getTaskByStatus(@PathVariable("status") String status) {
		return taskService.findByTaskStatus(status);
	}
	
	
}