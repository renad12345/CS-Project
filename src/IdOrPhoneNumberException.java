
public class IdOrPhoneNumberException extends Exception{
	public IdOrPhoneNumberException() {
		this("Something that");
	}

	IdOrPhoneNumberException(String s){
		System.out.println(s + " is incorrict!");
	}
}
