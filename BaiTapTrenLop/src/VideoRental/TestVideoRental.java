package VideoRental;

import java.util.Date;

public class TestVideoRental {
	public static void main(String[] args) {
		Movie m1 = new ChildrenMovie("Harry Potter");
		Movie m2 = new RegularMovie("Pretty Woman");
		Movie m3 = new NewReleaseMovie("Gai nhay");
		Movie m4 = new RegularMovie("Nguoi Ha Noi");
		Movie m5 = new NewReleaseMovie("Lo lem he pho");
		
		Customer teo = new Customer("Teo");
		Customer ti = new Customer("Ti");
		
		teo.rent(m1, new Date(2023, 1, 12));
		teo.rent(m3, new Date(2023, 1,25));
		ti.rent(m2,new Date(2023, 1, 20));
		ti.rent(m4, new Date(2023, 2, 1));
		ti.rent(m5, new Date(2023, 2, 12));
		
		System.out.println(teo.statement());
		System.out.println("-----------------");
		
		System.out.println(ti.statement());
		System.out.println("-----------------");
		
		teo.returnMovie(m3);
		System.out.println(teo.statement());
	}
}
