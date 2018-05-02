package com.myschooljournal.repo;


import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.myschooljournal.workservice.Validator.idValidation;

public class LessonDaoImpl implements LessonDao {
	/**
	 * 
	 */
	
	private static Map<Long,Lesson> lessonRepo=new HashMap<>();//отображение БД
	private static Long idGen=1L;

	public Lesson save(Lesson lesson) {
		if(lesson==null){
			return null;
		}
		lesson.setId(idGen);
		lessonRepo.put(idGen,lesson);
		return lessonRepo.get(idGen++);
		
		}

	public Lesson getById(Long id) {
		idValidation(id);
		return lessonRepo.get(id);
		
	}

	public Lesson remove(Long id) {
		
		return lessonRepo.remove(id);
	}

	public Collection<Lesson> getAll() {
		return lessonRepo.values();
		
	}

	public Lesson update(Long id, Lesson lesson) {
		lesson.setId(id);
		lessonRepo.put(id, lesson);
		return lessonRepo.get(id);
	}

	@Override
	public List<Lesson> getByTeacher(Teacher teacher) {
		return lessonRepo.values().stream()
				.filter(lesson->teacher.equals(lesson.getTeacher()))
				.collect(Collectors.toList());		
	}
 
	@Override
	public Lesson getByName(String name) {
		
		return lessonRepo.values()
				.stream()
				.filter(lesson->name.equals(name))
				.findAny().get();
	}

	public static void clean(){
		lessonRepo=new HashMap<>();
		idGen=1L;

	}


}
