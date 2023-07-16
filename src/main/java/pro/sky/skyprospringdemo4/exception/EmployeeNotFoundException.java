package pro.sky.skyprospringdemo4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeNotFoundException extends HttpStatusCodeException {

    public EmployeeNotFoundException(String massage){
        super(HttpStatus.NOT_FOUND, massage);
    }
}


