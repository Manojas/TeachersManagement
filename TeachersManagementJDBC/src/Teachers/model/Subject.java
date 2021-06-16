package Teachers.model;

public class Subject {

	private short subjectId;
	private String subjectName;
	private String teacherName;

	public Subject() {
		super();

	}

	public Subject(short subjectId, String subjectName, String teacherName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", teacherName=" + teacherName
				+ "]";
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public short getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(short subjectId) {
		this.subjectId = subjectId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
