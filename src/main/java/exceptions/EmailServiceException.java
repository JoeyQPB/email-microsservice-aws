package exceptions;

public class EmailServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailServiceException(String msg, String errorMsg) {
		super(msg + " - " + errorMsg);
	}
	
	public EmailServiceException(String msg, String errorMsg, Throwable cause) {
		super(msg + " - " + errorMsg, cause);
	}
}
