package pro.sky.skyprospringdemo4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeAlreadyAddedException extends HttpStatusCodeException {

    public EmployeeAlreadyAddedException(String massage){
        super(HttpStatus.BAD_REQUEST, massage);
    }
}
