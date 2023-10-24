package libraryproject;

public class Staff implements Book{

	@Override
	public String barrowBook() {
		
		return "book barrowed by staff";
	}

	@Override
	public String returnBook() {
		// TODO Auto-generated method stub
		return "book returned by staff";
	}

}
