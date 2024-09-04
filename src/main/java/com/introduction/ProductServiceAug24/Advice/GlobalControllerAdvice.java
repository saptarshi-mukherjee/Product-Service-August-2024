package com.introduction.ProductServiceAug24.Advice;


import com.introduction.ProductServiceAug24.Exceptions.InvalidSortingException;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductNotFoundExceptions.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundExceptions except) {
        return new ResponseEntity<String>(except.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(ProductLimitOutOfBoundsException.class)
    public ResponseEntity<String> getProductLimitOutOfBoundsException(ProductLimitOutOfBoundsException excp) {
        return new ResponseEntity<String>(excp.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(InvalidSortingException.class)
    public ResponseEntity<String> getInvalidSortingException(InvalidSortingException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatusCode.valueOf(400));
    }
}
