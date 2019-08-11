package lk.autostreet.services.core.controller;

import lk.autostreet.services.core.exception.AlreadyRegisteredException;
import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.exception.BadRequestException;
import lk.autostreet.services.core.exception.TransformException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler({
            BadRequestException.class,
            MissingServletRequestParameterException.class,
            IllegalArgumentException.class,
            AppGenericException.class,
            HttpMessageNotReadableException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle400Exception(Exception ex) {
        log.error(" request related error occurred [{}] ", ex.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return response;
    }


//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public Map<String, String> handleInvalidRequestBodyException(Exception ex) {
//        log.error(" request related error occurred [{}] ", ex.getMessage());
//        Map<String, String> response = new HashMap<>();
//        response.put("message", ex.getMessage());
//        return response;
//    }


    @ExceptionHandler({AlreadyRegisteredException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handle409Exception(AlreadyRegisteredException ex) {
        log.error(" request related error occurred [{}] ", ex.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return response;
    }


    @ExceptionHandler({TransformException.class, Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handle500Exception(Exception ex) {
        log.error(" internal server error occurred while processing the request [{}] ", ex.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Something went wrong! Please try again shortly");
        return response;
    }
}
