package quan_ly_diem;

import java.util.HashMap;
import java.util.List;

public class Student {
	private String name;
	private Date dateOfBirth;
	private Lecturer assistant;
	private List<Register> coureRegs;

	public Student(String name, Date dateOfBirth, Lecturer assistant, List<Register> coureRegs) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.assistant = assistant;
		this.coureRegs = coureRegs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Lecturer getAssistant() {
		return assistant;
	}

	public void setAssistant(Lecturer assistant) {
		this.assistant = assistant;
	}

	public List<Register> getCoureRegs() {
		return coureRegs;
	}

	public void setCoureRegs(List<Register> coureRegs) {
		this.coureRegs = coureRegs;
	}

	/**
	 * Phương thức sẽ kiểm tra xem môn học đó đã được sinh viên này đăng kí chưa.
	 * 
	 * @param course
	 * @return true nếu môn học đó đã được đăng kí, ngược lại thì false;
	 */
	public boolean haveCourse(Course course) {
		for (Register register : this.coureRegs) {
			if (register.checkCourse(course)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Phương thức getRegister sẽ lấy 1 đăng kí từ môn học đữa vào
	 * @param course
	 * @return Register
	 */
	public Register getRegister(Course course) {
		for (Register register : this.coureRegs) {
			if (register.checkCourse(course)) {
				return register;
			}
		}

		return null;
	}

	/**
	 * Đăng kí môn học Nếu môn học đó đã tồn tại thì hệ thống sẽ hiện thông báo:
	 * "Môn học đã được đăng kí!"; Nếu môn học đó chưa đăng kí và tồn tại môn học đó
	 * thì hệ thống thông báo: "Đâng kí môn học thành công!"; Nếu môn học đó thông
	 * tồn tại thì hệ thống sẽ thông báo: "Môn học không tồn tại!"
	 * 
	 * @param c
	 * @param system
	 */
	public void register(MyITCenter system, Course c) {
		List<Course> listCourses = system.getCoures();

		if (listCourses.contains(c)) {
			if (this.haveCourse(c)) {
				System.out.println("Môn học đã được đăng kí!");
			} else {
				Register register = new Register(c, 0);
				this.coureRegs.add(register);
				System.out.println("Đâng kí môn học thành công!");
			}
		} else {
			System.out.println("Môn học không tồn tại!");
		}
	}

	public void updateGrade(Course c, float grade) {
		Register register = this.getRegister(c);
		if (register == null) {
			System.out.println("Sinh viên chưa đănh kí môn học này!");
		} else {
			register.setGrade(grade);
			System.out.println("Đã cập nhật điểm thành công cho môn học: " + register.getCourse().getName() + ": "
					+ register.getGrade());
		}
	}
	
	
	/**
	 * phương thức avergeOfGrade sẽ tính điểm trung bình của một học sinh
	 * Công thức: Σ(Điểm môn i * Số tín chỉ môn i) / Tổng số tín chỉ các môn học
	 * @return
	 */
	public float averageOfGrade() {
		float countCredits = 0;
		float countGrade = 0;
		for(Register register : this.coureRegs) {
			countGrade += register.getGrade()*register.getCourse().getCredits();
			countCredits += register.getCourse().getCredits();
		}
		
		return countGrade/countCredits;
	}
	
	/**
	 * Phương thức rank sẽ xét xem sinh viên đó sẽ được xếp loại gì dựa vào điểm trung bình môn học
	 * @return "Xuất sắc" nếu sinh viên đó có điểm TB >= 9
	 * @return "Giỏi" Nếu sinh viên đó có điểm TB < 9 && >= 8
	 * @return "Khá" nếu  sinh viên có điểm TB < 8 && >= 7
	 * @return "Trung bình khá" nếu sinh viên có điểm TB < 7 && >= 6
	 * @return "Trung bình" nếu sinh viên có điểm TB < 6 && >= 5
	 * @return "Không tốt nghiệp" nếu sinh viên có điểm TB < 5
	 */
	public String rank() {
		float averageOfGrade = this.averageOfGrade();
		if(averageOfGrade >= 9) {
			return "Xuất sắc";
		}
		
		if(averageOfGrade < 9 && averageOfGrade >= 8) {
			return "Giỏi";
		}
		
		if(averageOfGrade < 8 && averageOfGrade >= 7) {
			return "Khá";
		}
		
		if(averageOfGrade < 7 && averageOfGrade >= 6) {
			return "Trung bình khá";
		}
		
		if(averageOfGrade < 6 && averageOfGrade >= 5) {
			return "Trung bình";
		}
		
		return "Không được tốt nghiệp";
	}
	
	public void printGradeReport() {
		System.out.println("Name: " + this.name);
		System.out.println("Ngày sinh: " + this.dateOfBirth);
		System.out.println("STT\t\tMôn\t\tĐiểm");
		for(int i = 0; i < this.coureRegs.size(); i++) {
			if(coureRegs.get(i).getCourse().getName().length() < 16) {
				System.out.println(i + 1 + "\t" + coureRegs.get(i).getCourse().getName() + "\t\t" + coureRegs.get(i).getGrade());
			}else {
				System.out.println(i + 1 + "\t" + coureRegs.get(i).getCourse().getName() + "\t" + coureRegs.get(i).getGrade());
			}
		}
		System.out.println("Điểm TB: " + this.averageOfGrade());
		System.out.println("Xếp loại: " + this.rank());
		"Cái gì đố".hashCode();
	}
}
