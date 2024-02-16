package cz.firstpf.exchangerates.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handling exceptions.
 * Handler methods define behaviour for particular exception types.
 *
 * @author Jiri Jasonek
 **/

@Slf4j
@RestControllerAdvice
public final class ExchangeRatesExceptionHandler {

    //TODO Maybe not exception at all
//    @ExceptionHandler(value = {DuplicateEntityException.class})
//    public ResponseEntity<> handleDuplicateEntityException() {
//        return new ResponseEntity(HttpStatus.ACCEPTED);
//    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
