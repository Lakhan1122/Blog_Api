package com.masai.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFundException.class)
	public ResponseEntity<ErrorDetails> handleStudentException(ResourceNotFundException exp,WebRequest req){
		String message=exp.getMessage();
	ErrorDetails err=new ErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

	return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> res=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			res.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
		
	}
	

}
