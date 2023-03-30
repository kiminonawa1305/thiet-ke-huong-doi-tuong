 package quan_ly_diem;

public class Course {
	private String name;
	private int credits;
	private Lecturer lecture;
	private float grade;
	public Course(String name, int credits, Lecturer lecture) {
		super();
		this.name = name;
		this.credits = credits;
		this.lecture = lecture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Lecturer getLecture() {
		return lecture;
	}
	public void setLecture(Lecturer lecture) {
		this.lecture = lecture;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}else {
			Course that = (Course)obj;
			return this.name.equalsIgnoreCase(that.name) && this.credits == that.credits;
		}
	}
	@Override
	public String toString() {
		return "Môn " + this.name + ", có số tín chỉ là: " + this.credits;
	}
	
	
}
