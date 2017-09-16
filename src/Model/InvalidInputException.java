package Model;

public class InvalidInputException extends Exception {

	InvalidInputException(){
		super("Invalid Entry");
	}
	
	InvalidInputException(String s){
		super(s);
	}
}
