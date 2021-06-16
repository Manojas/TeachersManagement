package Teachers.service;

import java.util.ArrayList;

import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.utility.myException;

public interface TeachersFunction {
	public String addTeacherDetails(Teacher teacher);

	public ArrayList<Teacher> displayTeachers() throws myException;

	public ArrayList<Subject> displaySubjects() throws myException;

	public String deleteTeacher(String teacherName);

	public ArrayList<Teacher> sortTeachers();

	public int getSubjectHandledBy(String teacherName2);
}
