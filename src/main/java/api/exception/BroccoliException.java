package api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * Created by deniz on 6/29/17.
 */
public class BroccoliException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private HttpStatus errorCode;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        logger.error("HTTP ERROR " + errorCode + ": " + errorMessage);
    }
    public BroccoliException() {
        super();
    }
}