import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

class Customer_sema implements Callable<String> {
	String name;
	int seatsRequired;
	Movie_sema watch;

	public Customer_sema(String name, int seats, Movie_sema watch) {
		this.name = name;
		seatsRequired = seats;
		this.watch = watch;
	}

	private static Semaphore mutex = new Semaphore(1);

	public synchronized String call() {

		try {
			mutex.acquire();
			if (watch.seats < seatsRequired) {
				if (watch.seats == 0) {
					System.out.println("Sorry "+name+", Housefull!");
					System.out.println();
				mutex.release();
					return "no";
				}
				if (watch.seats == 1) {
					
					System.out.println("Sorry " + name + ", only 1 seat available.("+(seatsRequired)+")");
					System.out.println();
					mutex.release();
					return "no";
				}

				System.out.println("Sorry " + name + ", only " + watch.seats + " seats available.("+(seatsRequired)+")");
				System.out.println();
				mutex.release();
				return "no";
			}

			ArrayList<String> seats_assingned = assign();
			watch.seats = watch.seats - seatsRequired;
			System.out.println("Hey " + name + "!" + seatsRequired + " seats booked successfully!");
			System.out.println(watch.name+" playing at screen : "+watch.screen+" at "+watch.time+" Hrs.");
			System.out.print("Your seats are :");
			for (String string : seats_assingned) {
				System.out.print(string + " ");
			}
			System.out.println();
			System.out.println("Amount to be paid = "+(watch.cost*seatsRequired)+" Rs.");
			System.out.println();
			System.out.println();
            
			mutex.release();
			return "yes";
		} catch (InterruptedException e) {
			System.out.println("Error\n");
			return "not";
		}

	}

	public synchronized ArrayList<String> assign() {
		ArrayList<String> finalised_seats = new ArrayList<String>();
		int size = 0, i = 0;
		while (size != seatsRequired) {
			finalised_seats.add(watch.seatsinfo.get(i));
			watch.seatsinfo.remove(i);
			size++;
		}
		return finalised_seats;

	}
}