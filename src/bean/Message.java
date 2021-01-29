package bean;

public class Message implements Bean {
	private String message;

	public Message() {}

	public void setMessage(String message){
		this.message=message;
	}

	public String getMessage(){
		return message;
	}
}
