package libraryproject;

public class Library {
	private Book bk;

	public Library(Book bk) {
		super();
		this.bk = bk;
	}
	public String showBorrow()
	{
		return bk.barrowBook();
	}
	public String showReturn()
	{
		return bk.returnBook();
	}
	
	
	
	

}
