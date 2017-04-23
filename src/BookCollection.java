import java.time.LocalDate;
import java.util.HashMap;

/**
 * This class stores the Book Collection HashMap and a few methods developed with it.
 * @author 
 *
 */
public class BookCollection
{
	HashMap<String, Book> bookList = new HashMap<String, Book>();
	

	/**
	 * Returns the Book List HashMap
	 * @return HashMap
	 */
	public HashMap<String, Book> getBookList()
	{
		return bookList;
	}
	
	/**
	 * Sets the due date when a book is taken out of the library.
	 * @param callNumber
	 * @param currentDate
	 */
	public void setDueDate(String callNumber, LocalDate currentDate)
	{
		bookList.get(callNumber).setDueDate(currentDate);
	}
	
	/**
	 * Returns the due date back to NULL when book is returned.
	 * @param callNumber
	 */
	public void clearDueDate(String callNumber)
	{
		bookList.get(callNumber).clearDueDate();
	}
}