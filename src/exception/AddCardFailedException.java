package exception;

//01.29 移行 大川
public class AddCardFailedException extends IntegrationException{
    public AddCardFailedException (String mess,Throwable cause){
        super(mess,cause);
    }
}
