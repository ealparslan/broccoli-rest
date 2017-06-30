package api.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by deniz on 6/29/17.
 */
public class BroccoliNotFoundException extends BroccoliException {
    public BroccoliNotFoundException(){
        super("", HttpStatus.NOT_FOUND);
    }
}
