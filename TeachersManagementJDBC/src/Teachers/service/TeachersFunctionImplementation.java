package Teachers.service;

import java.util.ArrayList;

import Teachers.dao.SubjectsDOAImplementation;
import Teachers.dao.TeachersDOAImplementation;
import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.utility.myException;

public class TeachersFunctionImplementation implements TeachersFunction {
	TeachersDOAImplementation dl = new TeachersDOAImplementation();
	SubjectsDOAImplementation sl = new SubjectsDOAImplementation();
	static ArrayList<Teacher> ls = new ArrayList<Teacher>();

	@Override
	public String addTeacherDetails(Teacher teacher) {
		// TODO Auto-generated method stub
		ls.add(teacher);
		String str = null;
		try {
			str = dl.addTeacherDAO(ls);
		} catch (myException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public ArrayList<Teacher> displayTeachers() throws myException {
		// TODO Auto-generated method stub
		ArrayList<Teacher> ls2 = sl.fetchDetails();
		return ls2;
	}

	@Override
	public ArrayList<Subject> displaySubjects() throws myException {
		// TODO Auto-generated method stub
		ArrayList<Subject> ls3 = sl.getSubjects();
		return ls3;
	}

	@Override
	public String deleteTeacher(String teacherName) {
		// TODO Auto-generated method stub

		String message = null;
		try {
			message = dl.deleteTeacherByName(teacherName);
		} catch (myException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public ArrayList<Teacher> sortTeachers() {
		// TODO Auto-generated method stub
		ArrayList<Teacher> resList = null;
		String message2 = null;
		try {
			resList = dl.sortTeachersByName();

		} catch (myException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resList;
	}

	@Override
	public int getSubjectHandledBy(String teacherName2) {
		// TODO Auto-generated method stub
		int res = 0;
		res = sl.getSubjectCount(teacherName2);
		return res;
	}

}
