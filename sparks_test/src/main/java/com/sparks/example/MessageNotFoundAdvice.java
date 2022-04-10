package com.sparks.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This helps Spring MVC render HTTP 404 error
 */
@ControllerAdvice
public class MessageNotFoundAdvice {
    // signals that this advice is rendered straight into the response body
    @ResponseBody
    // configures advice to only respond if MessageNotFoundException is thrown
    @ExceptionHandler(MessageNotFoundException.class)
    // says to issue HTTP 404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String messageNotFoundHandler(MessageNotFoundException ex) {
        return ex.getMessage();
    }
}
