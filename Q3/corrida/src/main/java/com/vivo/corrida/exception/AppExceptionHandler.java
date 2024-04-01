package com.vivo.corrida.exception;

import com.vivo.corrida.model.ErrorMessageResponse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ObjectNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex, WebRequest request) {

        return handleExceptionInternal(ex, new ErrorMessageResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Não foram encontradas informações para essa pesquisa."), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {

        return handleExceptionInternal(ex, new ErrorMessageResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Não foi encontrado nenhum serviço para esta URI."), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({CustomException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Object> handleGenericException(CustomException ex, WebRequest request) {

        return handleExceptionInternal(ex, new ErrorMessageResponse(new Date(), HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }


}
