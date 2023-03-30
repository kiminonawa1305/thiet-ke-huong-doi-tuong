package quan_ly_diem;

public class Lecturer {
	private String name, degree;
	private Date dateOfBirth;

	public Lecturer(String name, String degree, Date dateOfBirth) {
		super();
		this.name = name;
		this.degree = degree;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
