package com.myschooljournal.repo;

import com.myschooljournal.dao.TeacherDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao {

    private static Map<Long, Teacher> teacherRepo = new HashMap<>();
    private static Long idGen = 1L;

    @Override
    public Teacher save(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        teacher.setId(idGen);
        teacherRepo.put(idGen, teacher);
        return teacherRepo.get(idGen++);
    }

    @Override
    public Teacher getById(Long id) {

        return id==null?null:teacherRepo.get(id);
    }

    @Override
    public Teacher remove(Long id) {

        return id==null?null:teacherRepo.remove(id);
    }

    @Override
    public Collection<Teacher> getAll() {

        return teacherRepo.values();
    }

    @Override
    public Teacher update(Long id, Teacher teacher) {
        teacher.setId(id);
        teacherRepo.put(id, teacher);
        return teacherRepo.get(id);

    }


    @Override
    public Teacher getByName(String name) {

        return teacherRepo.values()
                .stream().filter(t -> t.getName().equals(name))
                .findAny()
                .get();
    }

    @Override
    public Teacher getByEmail(String email) {

        return teacherRepo.values()
                .stream().filter(t -> t.getEmail().equals(email))
                .findAny()
                .get();
    }

    @Override
    public Teacher getByLesson(Lesson lesson) {

        return teacherRepo.values()
                .stream().filter(t -> t.getLessons().stream().filter(les -> les.equals(lesson)).findAny().isPresent())
                .findAny()
                .get();
    }

    public static void clean() {
        teacherRepo = new HashMap<>();
        idGen=1L;
    }

}
