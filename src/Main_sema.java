import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_sema {
	public static void main(String[] args) throws InterruptedException {

		Movie_sema Lucy = new Movie_sema("Lucy", 10, 150, 1, "15:30");
		Movie_sema Godzilla = new Movie_sema("Godzilla", 10, 120, 2, "18:00");
		Movie_sema Extraction = new Movie_sema("Extraction", 10, 200, 5, "17:00");
		Lucy.initialize();
		Godzilla.initialize();
		Extraction.initialize();
		System.out.println("Welcome to the ticket booking counter..");
		System.out.println();
		ExecutorService service = Executors.newFixedThreadPool(5);
		Callable<String> customer1 = new Customer_sema("John doe", 6, Lucy);
		Callable<String> customer2 = new Customer_sema("Lily owens", 2, Lucy);
		Callable<String> customer3 = new Customer_sema("Percy Jackson", 3, Lucy);
		Callable<String> customer4 = new Customer_sema("Amy Winehouse", 2, Godzilla);
		Callable<String> customer5 = new Customer_sema("Bertha Stewart", 5, Godzilla);
		Callable<String> customer6 = new Customer_sema("Emma Watson", 3, Godzilla);
		Callable<String> customer7 = new Customer_sema("Jack Nicholson", 7, Extraction);
		Callable<String> customer8 = new Customer_sema("Christopher Nolan", 2, Extraction);
		Callable<String> customer9 = new Customer_sema("Timothée Chalamet", 1, Extraction);
		Callable<String> customer10 = new Customer_sema("Siorse Ronan", 3, Extraction);

		service.invokeAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10));
		service.shutdown();
		

	}
}
