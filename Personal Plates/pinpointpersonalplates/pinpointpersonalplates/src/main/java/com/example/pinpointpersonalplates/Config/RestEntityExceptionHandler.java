package com.example.pinpointpersonalplates.Config;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {NumberFormatException.class})
    protected ResponseEntity<Object> numberFormatExceptionHandler(RuntimeException ex, WebRequest webRequest)
    {
        String bodytext = "Conversion failed - please specify a number";
        return handleExceptionInternal(ex, bodytext, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }
}
