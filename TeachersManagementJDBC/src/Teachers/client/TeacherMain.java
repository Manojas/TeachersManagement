package Teachers.client;

import java.util.*;
import Teachers.model.Subject;
import Teachers.model.Teacher;
import Teachers.service.TeachersFunction;
import Teachers.service.TeachersFunctionImplementation;
import Teachers.utility.myException;

public class TeacherMain {
	static Scanner in = new Scanner(System.in);
	static int count = 0;
	static TeachersFunctionImplementation ts = new TeachersFunctionImplementation();

	public static void main(String[] args) throws myException {
		// TeachersFunctionImplementation ts=new TeachersFunctionImplementation();
		int choice = 0;
		boolean flag = true;
		do {
			System.out.println("Enter the choices");
			System.out.println("1.Add the teacher details");
			System.out.println("2.display teacher details");
			System.out.println("3.delete teacher details");
			System.out.println("4.sort tacher details by name");
			System.out.println("5.Get number of subjects handled by teacher ");
			System.out.println("6.Exit");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				String str = addTeacher();
				System.out.println(str);
				break;
			case 2:
				ArrayList<Teacher> ls = ts.displayTeachers();
				for (Teacher tc : ls) {
					System.out.println(tc.toString());
				}
				System.out.println("------------***********-------------");
				ArrayList<Subject> subList = ts.displaySubjects();
				for (Subject sc : subList) {
					System.out.println(sc.toString());
				}
				break;
			case 3:
				System.out.println("Enter the teacher name to be deleted");
				String teacherName = in.next();
				String str4 = ts.deleteTeacher(teacherName);
				System.out.println(str4);
				break;
			case 4:
				ArrayList<Teacher> sortedList = ts.sortTeachers();
				display(sortedList);
				break;
			case 5:
				System.out.println("Enter the teacher name");
				String teacherName2 = in.next();
				int number = ts.getSubjectHandledBy(teacherName2);
				System.out.println(teacherName2 + "  will handle " + number + " Subjects");
				break;
			case 6:
				System.out.println("You are exited");
				flag = false;
				break;
			default:
				System.out.println("Wrong choice");
				flag=true;
				break;
			}
	
		} while (flag);
	}

	private static void display(ArrayList<Teacher> sortedList) {
		// TODO Auto-generated method stub
		for (Teacher t : sortedList) {
			System.out.println(t.toString());
		}
	}

	private static String addTeacher() {
		// TODO Auto-generated method stub
		System.out.println("Enter the teachers name");
		String name = in.next();
		System.out.println("Enter the teachers id");
		short id = in.nextShort();
		System.out.println("Enter the teachers experience");
		short yOE = in.nextShort();
		System.out.println("Enter the number of subjects ");
		int number = in.nextInt();
		Subject[] subject = new Subject[number];
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the subject id");
			short subjectId = in.nextShort();
			System.out.println("Enter the subject name");
			String subjectName = in.next();
			Subject sub = new Subject(subjectId, subjectName, name);
			subject[i] = sub;
		}
		Teacher teacher = new Teacher(name, id, yOE, subject);
		System.out.println(teacher.toString());
		String str = ts.addTeacherDetails(teacher);
		return str;
	}
}
