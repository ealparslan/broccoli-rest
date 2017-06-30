package api.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by deniz on 6/29/17.
 */
public class BroccoliException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private HttpStatus errorCode;

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public BroccoliException(String errorMessage, HttpStatus errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    public BroccoliException() {
        super();
    }
}