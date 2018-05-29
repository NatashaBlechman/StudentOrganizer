package com.myschooljournal.repo;

import com.myschooljournal.dao.TaskDao;
import com.myschooljournal.entity.Task;
import com.myschooljournal.workservice.DateWorkService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao{
	
	private static Map<Long,Task> taskRepo=new HashMap<>();//отображение БД
	private static Long idGen=1L;

	@Override
	public Task save(Task task) {
		if(task==null){
			return null;
		}
		task.setId(idGen);
		taskRepo.put(idGen,task);
		return taskRepo.get(idGen++);
	}

	@Override
	public Task getById(Long id) {
		return taskRepo.get(id);
	}

	@Override
	public Task remove(Long id) {
		return taskRepo.remove(id);
	}

	@Override
	public Collection<Task> getAll() {
		return taskRepo.values();
	}

	@Override
	public Task update(Long id, Task task) {
		task.setId(id);
		return taskRepo.put(id, task);
	}

	@Override
	public List<Task> getByDeadLine(LocalDate deadLine,LocalDate from) {
		return tasksFilterByDate(deadLine, from)
				.collect(Collectors.toList());
	}

	@Override
	public List<Task> getByDeadLine(LocalDate deadLine,LocalDate from, boolean done) {
		return tasksFilterByDate(deadLine, from)
		.filter(t->t.isDone()==done).collect(Collectors.toList());
	}
	
	private Stream<Task> tasksFilterByDate(LocalDate deadLine,LocalDate from){
		return taskRepo.values().stream()
		.filter(task->DateWorkService.isDateInInterval(from, deadLine, task.getDeadLine()));
	}

	public static void clean(){
		taskRepo=new HashMap<>();
		idGen=1L;
	}

}
