package Teachers.model;

import java.util.Arrays;

public class Teacher {
	private String teacherName;
	private short teacherId;
	private short yearOfExperience;
    private Subject[] subject;
	public Teacher() {
		super();

	}

	public Teacher(String teacherName, short teacherId, short yearOfExperience,Subject[] subject) {
		super();
		this.teacherName = teacherName;
		this.teacherId = teacherId;
		this.yearOfExperience = yearOfExperience;
		this.subject=subject;
	}



	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", teacherId=" + teacherId + ", yearOfExperience="
				+ yearOfExperience  + "]";
	}

	public Subject[] getSubject() {
		return subject;
	}

	public void setSubject(Subject[] subject) {
		this.subject = subject;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public short getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(short teacherId) {
		this.teacherId = teacherId;
	}

	public short getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(short yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

}
