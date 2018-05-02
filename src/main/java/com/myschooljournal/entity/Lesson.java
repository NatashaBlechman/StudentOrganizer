package com.myschooljournal.entity;

import java.util.Objects;

public class Lesson extends EntityObject{
	
	private String name;
	private Teacher teacher;
	private String numClass;
	
	
	public Lesson(String name) {
		super();
		this.name = name;
	}
	public Lesson() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getNumClass() {
		return numClass;
	}
	public void setNumClass(String numClass) {
		this.numClass = numClass;
	}
	@Override
	public String toString() {
		return "Lesson [name=" + name + ", teacher=" + teacher + ", numClass=" + numClass + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Lesson)) return false;
		Lesson lesson = (Lesson) o;
		return Objects.equals(getName(), lesson.getName()) &&
				Objects.equals(getTeacher(), lesson.getTeacher()) &&
				Objects.equals(getNumClass(), lesson.getNumClass());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getName(), getTeacher(), getNumClass());
	}
}
