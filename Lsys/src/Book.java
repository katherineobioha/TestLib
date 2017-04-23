import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Book a user takes out and returns
 * @author 
 *
 */
public class Book
{
	private String title;
	private String callNumber;
	private LocalDate dueDate;
	
	
	public Book()
	{
		
	}
	
	/**
	 * Creates a specialized constructor
	 * @param title
	 * @param callNumber
	 * @param currentDate
	 */
	public Book(String title, String callNumber, LocalDate currentDate)
	{
		this.title = title;
		this.callNumber = callNumber;
		setDueDate(currentDate);
	}
	
	/**
	 * Sets the title of the Book
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Gets the title of the Book
	 * @return the title of the Book
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets the Call Number of the Book
	 * @param callNumber
	 */
	public void setCallNumber(String callNumber)
	{
		this.callNumber = callNumber;
	}
	
	/**
	 * Sets the Due Date of the Book
	 * @param currentDate
	 */
	public void setDueDate(LocalDate currentDate)
	{
		dueDate = currentDate.plusDays(14);
	}
	
	/**
	 * Sets the due date of the book back to NULL when returned.
	 */
	public void clearDueDate()
	{
		dueDate = null;
	}
	
	/**
	 * Gets the Due Date
	 * @return the Due Date of the Book
	 */
	public String getDueDate()
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
    	String formattedDueDate = dueDate.format(format);
    	
		return formattedDueDate;
	}
	
	public LocalDate getLocalDate()
	{
		return dueDate;
	}
	
	/**
	 * Gets the Call Number of the Book
	 * @return the Call Number of the Book
	 */
	public String getCallNumber()
	{
		return callNumber;
	}
	
	public String toString()
	{
		return "Title: " + title + "Call Number: " + callNumber;
	}
}
