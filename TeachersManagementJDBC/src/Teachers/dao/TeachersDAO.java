package Teachers.dao;

import java.util.ArrayList;

import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.utility.myException;

public interface TeachersDAO {
public String addTeacherDAO(ArrayList<Teacher> ls) throws myException;
public String deleteTeacherByName(String teacherName) throws myException;

public ArrayList<Teacher> sortTeachersByName() throws myException;
}
