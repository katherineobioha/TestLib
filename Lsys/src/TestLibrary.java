import java.io.IOException;

import java.time.LocalDate;

/**
 * This program tests the functionality of the LibrarySystem and CheckoutMenu through user input
 * @author 
 * 
 */

public class TestLibrary
{
	private static final String file ="books.txt";
	public static void main(String[] args) throws IOException
	{ 
		  LocalDate currentDate = LocalDate.now();
	      LibrarySystem system = new LibrarySystem(currentDate);
	      system.load(file);
	      CheckoutMenu menu = new CheckoutMenu(currentDate);
	      menu.run(system);
	 }
}
