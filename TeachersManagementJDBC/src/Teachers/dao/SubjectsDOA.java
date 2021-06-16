package Teachers.dao;

import java.util.ArrayList;

import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.utility.myException;

public interface SubjectsDOA {
	public String addSubjects(Subject[] subject) throws myException;

	public ArrayList<Teacher> fetchDetails() throws myException;

	public ArrayList<Subject> getSubjects() throws myException;

	public int getSubjectCount(String teacherName2);
}
