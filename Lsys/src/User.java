import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents a User who ta`kes out and returns books
 * @author
 *
 */
public class User
{
	private String userName;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	/**
	 * Adds a Book to a User's Book List
	 * @param aBook
	 */
	public void addBook(Book aBook)
	{
		  bookList.add(aBook);
	}
	
	/**
	 * Returns a Book from a User's Book List
	 * @param callNumber
	 * @return ReturnStatus Enum
	 */
	public ReturnStatus returnBook(String callNumber)
	{
		for(Book aBook : bookList)
		{
			if(callNumber.equals(aBook.getCallNumber()))
			{
				bookList.remove(aBook);
				return ReturnStatus.SUCCESS;
			}
		}
		
		return ReturnStatus.NOT_CHECKEDOUT;
	}
	
	/**
	 * Displays a User's Book List and sorts it based on user input.
	 * @param choice
	 * @return the sorted display
	 */
	public String displayBookList(String choice)
	{
		String display = "";
		
		if (choice.equals("LC"))
		{
			Collections.sort(bookList, new SortByCallNumber());
		}
		
		else
			Collections.sort(bookList, new SortByTitle());
		
		for(Book aBook : bookList)
		{
			display = display + "Title: " + aBook.getTitle() + "\n" +
								"Call Number: " + aBook.getCallNumber() + "\n" +
								"Due on " + aBook.getDueDate() + "\n" + "\n";
		}
		
		return display;
	}
	
	/**
	 * Sets a User's name
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * Gets a User's name
	 * @return the User name
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * This is a comparator class that will sort the books based on call number.
	 * @author mandr09a
	 *
	 */
	class SortByCallNumber implements Comparator<Book>
	{
		/**
		 * Sorts books based on call number
		 * @param two books
		 * @return -1, 0, or 1 based on which call number goes first.
		 */
		public int compare(Book unsortedBookA, Book unsortedBookB)
		{
			String callNumberBookA = unsortedBookA.getCallNumber();
			String callNumberBookB = unsortedBookB.getCallNumber();
			
			int answer = callNumberBookA.compareTo(callNumberBookB);
			
			return answer;
		}
	}
		
	class SortByTitle implements Comparator<Book>
	{
		/**
		 * Sorts books based on title
		 * @param two books
		 * @return -1, 0, or 1 based on which title is alphabetically first.
		 */
		public int compare(Book unsortedBookA, Book unsortedBookB)
		{
			String titleBookA = unsortedBookA.getTitle();
			String titleBookB = unsortedBookB.getTitle();
				
			int answer = titleBookA.compareTo(titleBookB);
				
			return answer;
		}
	}	
}