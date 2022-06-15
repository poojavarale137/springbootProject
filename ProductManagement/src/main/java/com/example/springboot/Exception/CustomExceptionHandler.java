package com.example.springboot.Exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler({OfferNotValidException.class , CurrencyNotValidException.class})
	ResponseEntity<?>  offerNotValidHandler(Exception e,ServletWebRequest request){
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setPathUrl(request.getDescription(true));
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(Arrays.asList( e.getMessage()));
		return new ResponseEntity(apiError, new HttpHeaders(),apiError.getStatus());
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		
		List<FieldError> fieldsErrors = ex.getBindingResult().getFieldErrors();
		List<String> errors = fieldsErrors.stream()
				.map(err -> err.getField() +":" + err.getDefaultMessage())
				.collect(Collectors.toList());
		
		
		APIError apierror = new APIError();
		apierror.setStatus(HttpStatus.BAD_REQUEST);
		apierror.setTimeStamp(LocalDateTime.now());
		apierror.setPathUrl(request.getDescription(true));
		apierror.setErrors(errors);
		
		return new ResponseEntity<>(apierror, headers,apierror.getStatus());
	}
}
