package dau_gia_san_pham;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && this.getClass() == obj.getClass()) {
			Date that = (Date) obj;
			return this.day == that.day && this.month == that.month && this.year == that.year;
		}
		
		return false;
	}
	
	public boolean checkTime(Date start, Date end) {
		java.util.Date date1 = new java.util.Date(start.getYear(), start.getMonth(), start.getDay());
		java.util.Date date2 = new java.util.Date(end.getYear(), end.getMonth(), end.getDay());
		java.util.Date date3 = new java.util.Date(this.getYear(), this.getMonth(), this.getDay());
		
		return date3.before(date2) && date3.after(date1);
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	
}