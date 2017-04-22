import java.io.FileNotFoundException;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Holds the methods that the CheckoutMenu uses
 * @author 
 * 
 */ 
public class LibrarySystem
{
	
	private ArrayList<User> userList = new ArrayList<User>();
	private BookCollection bookList = new BookCollection();
	private User userName;
	private Book newBook;
	private LocalDate currentDate;
	
	public LibrarySystem(LocalDate currentDate)
	{
		this.currentDate = currentDate;
	}
	
	/**
	* Adds a user to the User List
	* @param aUser
	*/
	public void addUser(String aUser)
	{
		userName = new User();
		boolean userFind = false;
		userName.setUserName(aUser);
		
		for (User user: userList)
		{
			if(aUser.equals(user.getUserName()))
				userFind = true;
		}
		
		if(!userFind)
			userList.add(userName);
	}
	
	/**
	 * Adds a book to a specific User List
	 * @param callNumber
	 * @param userName
	 * @return CheckoutStatus Enum
	 */
	public CheckoutStatus checkOutBook(String callNumber, String userName)
	{
		
		newBook = bookList.getBookList().get(callNumber);
		
		if(newBook != null)
			{	
				if (newBook.getLocalDate() == null)
				{
					for (User  aUser : userList)
					{
						if(userName.equals(aUser.getUserName()))
						{
							newBook.setDueDate(currentDate);
							aUser.addBook(newBook);
							return CheckoutStatus.SUCCESS;
						}
					}	
				}
				else
					return CheckoutStatus.IS_CHECKEDOUT;
			}
		return CheckoutStatus.NOT_IN_LIBRARY;
	}
	
	/**
	 * Returns a book from a User List based on Call Number
	 * @param userName
	 * @param callNumber
	 * @return ReturnStatus Enum
	 */
	public ReturnStatus returnBook(String userName, String callNumber)
	{
		for (User aUser : userList)
		{
			if(userName.equals(aUser.getUserName()))
			{
				switch (aUser.returnBook(callNumber))
				{
				case SUCCESS: bookList.clearDueDate(callNumber); return ReturnStatus.SUCCESS;
				
				default: return ReturnStatus.NOT_CHECKEDOUT;
				}
			}
		}
		
		return ReturnStatus.NO_SUCH_USER;
	}
	
	/**
	 * Displays the contents of a certain User List
	 * @param userName
	 * @return an error message if applicable
	 */
	public String displayUserList(String userName, String choice)
	{	
		for (User aUser : userList)
		{
			if(userName.equals(aUser.getUserName()))
				return aUser.displayBookList(choice);
		}
		
		return "ERROR: This user is not in our system";
	}
	
	/**
	 * Loads the books into the HashMap from a txt file.
	 * @param X
	 * @throws FileNotFoundException
	 */
	public void load(String X) throws FileNotFoundException
	{
		HashMap<String, Book> temp;
		
		FileReader file = new FileReader(X);
		Scanner text = new Scanner(file);
		
		text.useDelimiter(",");
		
		while(text.hasNext())
		{
			String callNumber = text.next();
			String title = text.next();
			
	
			newBook = new Book(title, callNumber, currentDate);
			newBook.clearDueDate();
			 
			temp = bookList.getBookList();
			temp.put(callNumber, newBook);
			
		}
		text.close();
	}
}