package VideoRental;

import java.util.Date;

public class RentItem {
	private Date startDate;
	private Movie movie;
	public RentItem(Date startDate, Movie movie) {
		super();
		this.startDate = startDate;
		this.movie = movie;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public int getRentDays() {
		Date now = new Date();
		long duration = now.getTime() - startDate.getTime();
		long rentedDays = duration / (24 * 3600000);
		if (duration % (24 * 3600000) > 2 * 3600000)
		rentedDays++;
		return (int) rentedDays;
	}
	
	public double getCharge() {
		return this.movie.getCharge(getRentDays());
	}
	
	public int getFrequentRenterPoints() {
		return this.movie.getFrequentRenterPoints(getRentDays());
	}
}
