import java.util.ArrayList;


public class Movie_sema {
	String name;
	int seats;
    int seamaphore = 0;
    int cost;
    int screen;
    String time;
	ArrayList<String> seatsinfo = new ArrayList<String>();
	public void initialize() {
	seatsinfo.add("A1");
	seatsinfo.add("A2");
	seatsinfo.add("A3");
	seatsinfo.add("B1");
	seatsinfo.add("B2");
	seatsinfo.add("B3");
	seatsinfo.add("C1");
	seatsinfo.add("C2");
	seatsinfo.add("C3");
	seatsinfo.add("D1");
	}
	 
	Movie_sema(String name, int seats, int cost, int screen, String time) {
		this.name = name;
		this.seats = seats;
		this.cost = cost;
		this.screen = screen;
		this.time = time;
	}
}