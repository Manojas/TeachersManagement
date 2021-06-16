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

public class SubjectsDOAImplementation implements SubjectsDOA {

	@Override
	public String addSubjects(Subject[] subject) throws myException {
		// TODO Auto-generated method stub
		String str = null;
		Connection con = GetConnection.getConnection();
		PreparedStatement st = null;
		String query2 = "insert into subject values(?,?,?)";
		try {

			for (int i = 0; i < subject.length; i++) {
				st = con.prepareStatement(query2);
				st.setShort(1, subject[i].getSubjectId());
				st.setString(2, subject[i].getSubjectName());
				st.setString(3, subject[i].getTeacherName());
				st.execute();
			}
			str = "subjects added successfully";
		} catch (Exception e) {
			throw new myException(e.getMessage());
		}

		return str;
	}

	@Override
	public ArrayList<Teacher> fetchDetails() throws myException {
		// TODO Auto-generated method stub
		Connection con = GetConnection.getConnection();
		ResultSet rs = null;
		String query = "select * from teacher";
		Statement st = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			throw new myException(e.getMessage());
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

	public ArrayList<Subject> getSubjects() throws myException {
		// TODO Auto-generated method stub
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		// Subject[] sub = new Subject[5];
		Connection con = GetConnection.getConnection();
		ResultSet rs = null;
		String query = "select * from subject";
		Statement st = null;
		int i = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			throw new myException(e.getMessage());
		}
		try {
			while (rs.next()) {
				// if ((rs.getString("teacherName")).equals(name)) {
				Subject sub2 = new Subject(rs.getShort("subjectId"), rs.getString("subjectName"),
						rs.getString("teacherName"));
				subjectList.add(sub2);
				// }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectList;
	}

	@Override
	public int getSubjectCount(String teacherName2) {
		// TODO Auto-generated method stub
		int num = 0;
		Connection con = GetConnection.getConnection();
		ResultSet rs = null;
		String query = "select count(*) from subject where teacherName=?";
		PreparedStatement st = null;
		int i = 0;
		try {
			st = con.prepareStatement(query);
			st.setString(1, teacherName2);
			rs = st.executeQuery();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			while (rs.next()) {
				num = rs.getShort("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}
