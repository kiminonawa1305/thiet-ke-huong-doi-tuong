package quan_ly_diem;

public class Register {
	private Course course;
	private float grade;

	public Register(Course course, float grade) {
		super();
		this.course = course;
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	/**
	 * Phương thức này nhận vào một môn học bất kì
	 * phần đăng kí sẽ kiểm tra xem là môn học này có phải là môn học đăng kí không
	 * @param course
	 * @return true nếu đăng kí này là cái đăng kí môn học đưa vào, ngược lại thì false.
	 */
	public boolean checkCourse(Course course) {
		return this.course.equals(course);
	}

	@Override
	public String toString() {
		return this.course + ", với điểm số: "  + this.grade + " điểm";
	}
	
	
}