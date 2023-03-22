package model_system;

import java.util.Date;

public class Employee {
	private String id;
	private String name;
	private Date birthDate;
	private String numberPhone;
	private String address;
	private double baseSalary;
	private Date dateStart;

	public Employee(String id, String name, Date birthDate, String numberPhone, String address, double baseSalary,
			Date dateStart) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.numberPhone = numberPhone;
		this.address = address;
		this.baseSalary = baseSalary;
		this.dateStart = dateStart;
	}

}