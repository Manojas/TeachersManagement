package Teachers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.utility.GetConnection;
import Teachers.utility.myException;

public class TeachersDOAImplementation implements TeachersDAO {

	@Override
	public String addTeacherDAO(ArrayList<Teacher> ls) throws myException {
		// TODO Auto-generated method stub
		SubjectsDOAImplementation sb = new SubjectsDOAImplementation();
		boolean flag = false;
		String str = null;
		Connection con = GetConnection.getConnection();
		PreparedStatement st = null;
		Teacher teacher = ls.get(0);
		System.out.println(teacher.toString());
		String query = "insert into teacher values(?,?,?)";
		// String query2 = "insert into subject values(?,?,?)";
		try {
			st = con.prepareStatement(query);
			st.setString(1, teacher.getTeacherName());
			st.setShort(2, teacher.getTeacherId());
			st.setShort(3, teacher.getYearOfExperience());
			st.executeUpdate();
			// for(int i=0;i<teacher.getSubject().length;i++)
			{
				String str2 = sb.addSubjects(teacher.getSubject());
			}
			str = "added successfully";
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new myException(e.getMessage());
		} finally {
			try {
				GetConnection.closeConnection(st);
				GetConnection.closeConnection(con);
			} catch (Exception e) {
				throw new myException(e.getMessage());
			}
		}
		return str;

	}

	@Override
	public String deleteTeacherByName(String teacherName) throws myException {
		// TODO Auto-generated method stub
		Connection con = GetConnection.getConnection();
		PreparedStatement st = null;
		String result = null;
		String query = "delete from teacher where teacherName=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, teacherName);
			st.executeUpdate();
			result = "deleted successfully";
		} catch (Exception e) {
			throw new myException(e.getMessage());
		}

		return result;
	}

	public ArrayList<Teacher> sortTeachersByName() throws myException {
		// TODO Auto-generated method stub
		Connection con = GetConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from teacher order by teacherName Asc";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		ArrayList<Teacher> ls3 = new ArrayList<Teacher>();
		try {
			while (rs.next()) {
				// Teacher teacher = new Teacher();
				String name = rs.getString("teacherName");
				Short id = rs.getShort("teacherId");
				Short yoe = rs.getShort("yOE");
				Subject[] subject = null;// getSubjects(name);
				Teacher teacher = new Teacher(name, id, yoe, subject);
				ls3.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new myException(e.getMessage());
		}
		return ls3;

	}

}
