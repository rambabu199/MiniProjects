package libraryproject;

public class Student implements Book{

	@Override
	public String barrowBook() {
		
		return " book borrowed by student";
	}

	@Override
	public String returnBook() {
		
		
		return "book returned by student";
	}

}
