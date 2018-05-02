package com.myschooljournal.repo;

import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;
import com.myschooljournal.workservice.DateWorkService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarkDaoImpl implements MarkDao{
	
	private static Map<Long,Mark> markRepo=new HashMap<>();
	private static Long idGen=1L;

	@Override
	public Mark save(Mark mark) {
		if(mark==null){
			return null;
		}
		mark.setId(idGen);
		 markRepo.put(idGen, mark);
		 return markRepo.get(idGen++);
	}

	@Override
	public Mark getById(Long id) {
		return markRepo.get(id);
	}

	@Override
	public Mark remove(Long id) {
		return markRepo.remove(id);
	}

	@Override
	public Collection<Mark> getAll() {
		return markRepo.values();
	}

	@Override
	public Mark update(Long id, Mark mark) {
		mark.setId(id);
		 markRepo.put(id, mark);
		 return markRepo.get(id);
		
	}

	@Override
	public List<Mark> getByLesson(Lesson lesson) {
		
		return markRepo.values().stream()
				.filter(mark->lesson.equals(mark.getLesson()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Mark> getByLessonOnInterval(LocalDate from, LocalDate to, Lesson lesson) {
		
		return markRepo.values().stream()
				.filter(mark->DateWorkService.isDateInInterval(from, to, mark.getDate())&&lesson.equals(mark.getLesson()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Mark> getBadMarks(LocalDate from, LocalDate to,Long level) {
		
		return tasksFilterByDate(from, to)
				.filter(m->m.getMark()<=level)
				.collect(Collectors.toList());
	}

	@Override
	public Double getAverageMarkByLesson(LocalDate from, LocalDate to, Lesson lesson) {
		
		List<Long> list= tasksFilterByDate(from, to)
				.filter(l->l.getLesson().getName().equals(lesson.getName()))
				.map(Mark::getMark).collect(Collectors.toList());
		if(list==null) return null;
		long sum=0L;
		for (Long mark:list) {
			sum+=mark;
		}
		return 1.0*sum/list.size();
	}
	
	private Stream<Mark> tasksFilterByDate(LocalDate from,LocalDate to){
		return markRepo.values()
		.stream()
		.filter(mark->DateWorkService.isDateInInterval(from, to,mark.getDate()));
	}

	public static void clean(){
		markRepo=new HashMap<>();
		idGen=1L;
	}

}
