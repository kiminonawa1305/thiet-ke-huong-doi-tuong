package quan_ly_diem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyITCenter {
	private List<Lecturer> lecturers;
	private List<Student> students;
	private List<Course> courses;

	public MyITCenter(List<Lecturer> lecturers, List<Student> students, List<Course> courses) {
		super();
		this.lecturers = lecturers;
		this.students = students;
		this.courses = courses;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCoures() {
		return courses;
	}

	public void setCoures(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * Phương thức getStudentOfCourse sẽ lấy thông tin các sinh viên có đăng kí môn học c
	 * @param c
	 */
	public void getStudentOfCourse(Course c) {
		for (Student student : this.students) {
			if(student.haveCourse(c)) {
				student.printGradeReport();
				System.out.println("=====================================");
			}
		}
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}

	public static void main(String[] args) throws IOException {
		List<Course> courses = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		List<Lecturer> lecturers = new ArrayList<>();
		List<Register> lamCourses = new ArrayList<>();
		MyITCenter test = new MyITCenter(lecturers, students, courses);

		BufferedReader read = new BufferedReader(
				new FileReader("D:\\Tai_lieu_hoc_tap\\ThietKeHuongDoiTuong\\Code\\QuanLyDiem\\src\\FileCourse.txt"));
		String readLine = null;
		while (true) {
			readLine = read.readLine();

			readLine = read.readLine();
			if (readLine == null) {
				break;
			}

			Course course = new Course(readLine.split("\t")[0], Integer.parseInt(readLine.split("\t")[1]), null);
			courses.add(course);
		}

		read = new BufferedReader(new FileReader("D:\\Tai_lieu_hoc_tap\\ThietKeHuongDoiTuong\\Code\\QuanLyDiem\\src\\LamCourses"));
		while (true) {
			readLine = read.readLine();

			if (readLine == null) {
				break;
			}

			Course course = new Course(readLine.split("\t")[0], Integer.parseInt(readLine.split("\t")[1]), null);
			lamCourses.add(new Register(course, Float.parseFloat(readLine.split("\t")[2])));

		}

		Collections.shuffle(lecturers);

		Lecturer coTram = new Lecturer("Phương Trâm", "thạc sĩ", null);
		Student lam = new Student("Nguyễn Đình Lam", new Date(13, 05, 2003), coTram, lamCourses);
		lam.printGradeReport();
		test.addStudent(lam);
		test.getStudentOfCourse(new Course("Xác suất thống kê", 3, null));
	}
}
