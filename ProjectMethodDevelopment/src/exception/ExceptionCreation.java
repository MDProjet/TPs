package exception;

public class ExceptionCreation extends Exception {
	
	private String message;

	public ExceptionCreation(String s){
		super(s);
		this.message=s;
	}

	public String toString() {
		return "Impossible de creer type : " + this.message ;
	}
	
	
	
}
