import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckoutMenu
{
	private LibrarySystem system;
	Scanner keyboard = new Scanner (System.in);
	
	/**
	 * Builds a constructor
	 * @param currentDate
	 */
    public CheckoutMenu(LocalDate currentDate)
    {
    	DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
    	String formattedDate = currentDate.format(format);
    	 
    	System.out.println("Welcome to the Very Nice Checkout System");
    	System.out.println("Today's date is " + formattedDate);
    	System.out.println();
    }
    
    /**
     * Starts the system up
     * @param system
     */
    public void run(LibrarySystem system)
    {
    	this.system = system;
    	String choice = displayMenu();
    	while (!choice.equals("Q"))
    	{
    		doAction(choice);
    		choice = displayMenu();
    	}
    	
    	System.out.println("Bye!");
    }
    
    /**
     * Depending on what the user inputs, does an action
     * @param choice
     */
	private void doAction(String choice)
	{
		if (choice.equals("C"))
			checkOutBook();
		
		else if (choice.equals("R"))
			returnBook();
		
		else if (choice.equals("LC"))
			display("LC");	
		
		else if (choice.equals("LT"))
			display("LT");
	}

	/**
	 * Displays the menu commands
	 * @return the display menu
	 */
	public String displayMenu()
	{
		System.out.println("Please enter a command");
		System.out.println("C: check out a book");
		System.out.println("R: return a book");
		System.out.println("LC: list the books checked out by a user, sorted by call number");
		System.out.println("LT: list the books checked out by a user, sorted by title");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");
		
		String choice = keyboard.nextLine();
		
		
		return choice;
	}

	/**
	 * Takes in user input and checks out a book accordingly.
	 */
	private void checkOutBook()
	{
		System.out.println("Enter the user name");
		String userName = keyboard.nextLine();
		
		System.out.println("Enter the call number");
		String callNumber = keyboard.nextLine();
		
		system.addUser(userName);
		System.out.println(system.checkOutBook(callNumber, userName));
		
		System.out.println();
	}
	
	/**
	 * Takes in user input and returns a book accordingly.
	 */
	private void returnBook()
	{
		System.out.println("Enter the user name");
		String userName = keyboard.nextLine();
		System.out.println("Enter the call number");
		String callNumber = keyboard.nextLine();
		
		System.out.println(system.returnBook(userName, callNumber));
		System.out.println();
	}
	
	/**
	 * Takes in user input and displays a specific sorted User List.
	 */
	private void display(String choice)
	{
		System.out.println("Enter the user name");
		String userName = keyboard.nextLine();
		System.out.println("Checked out books for " + userName);
		System.out.println();
		
		System.out.println(system.displayUserList(userName, choice));
		System.out.println();
	}
}