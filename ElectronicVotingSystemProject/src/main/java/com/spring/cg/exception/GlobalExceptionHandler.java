package com.spring.cg.exception;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.exception.InvalidUserDetails;
import com.spring.cg.exception.ErrorMessage;
import com.spring.cg.exception.UserNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	

	@ExceptionHandler(value = {InvalidDataException.class})
	public ResponseEntity<ErrorMessage> handleInvalidDataException(
	InvalidDataException ex) {
		String error = "Data is Inavalid";
		
		ErrorMessage errorMessage =
		     new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		   return new ResponseEntity<ErrorMessage>(
		    errorMessage, new HttpHeaders(), errorMessage.getStatus());
	
	}
	
	@ExceptionHandler(value = {InvalidUserDetails.class})
	public ResponseEntity<ErrorMessage> handleInvalidUserDetails(
			InvalidUserDetails ex) {
		String error = ex.getLocalizedMessage();
		ErrorMessage errorMessage =
		     new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		logger.info(errorMessage);

		   return new ResponseEntity<ErrorMessage>(
		    errorMessage, new HttpHeaders(), errorMessage.getStatus());
	
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorMessage> handleInvalidUserDetails(
			Exception ex) {
		String error = ex.getLocalizedMessage();
		ErrorMessage errorMessage =
		     new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		logger.info(errorMessage);

		   return new ResponseEntity<ErrorMessage>(
		    errorMessage, new HttpHeaders(), errorMessage.getStatus());
	
	}

	
	
	
	
	

	@ExceptionHandler(value = {RecordNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleNullValueFoundException(
			RecordNotFoundException ex) {
		String error = "Record not found";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	

	@ExceptionHandler(value = {ResultNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleResultNotFoundException(
			ResultNotFoundException ex) {
		String error = "Result not found";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	
	@ExceptionHandler(value = {CandidateNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCandidateNotFoundException(
			CandidateNotFoundException ex) {
		String error = "candidate is not found";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	
	@ExceptionHandler(value = {ElectionNotFoundException.class})
	public ResponseEntity<ErrorMessage> ElectionNotFoundException(ElectionNotFoundException ex){
		
		String error = "No such Election exist";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(),error);
		return  new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value=RequestNotApproved.class)
	public ResponseEntity<ErrorMessage> handleRequestNotApprovedException(RequestNotApproved ex){
		String error = "Request Not Approved";
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}
	
	
	@ExceptionHandler(value = {InvalidStateException.class})
	public ResponseEntity<ErrorMessage> InvalidStateExceptionException(InvalidStateException ex){
		
		String error = "Invalid State entered";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(),error);
		return  new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}
	

	@ExceptionHandler(value = {ScheduleNotFound.class})
	public ResponseEntity<ErrorMessage> handleScheduleNotFoundException(ScheduleNotFound ex){
		
		String error = "No schedule found";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),error);
		return  new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {AlreadyVotedException.class})
	public ResponseEntity<ErrorMessage> handleNullValueFoundException(
			AlreadyVotedException ex) {
		String error = "Already Voted! Cannot Vote Again!";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.toString(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@ExceptionHandler(value= {UserNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleUserException(
			UserNotFoundException ex){
		    String error="Not Found";
			ErrorMessage errorMessage= new ErrorMessage(HttpStatus.BAD_REQUEST,ex.toString(),error);
			return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(),errorMessage.getStatus());
		}
	
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){
		
		List<String> errors = new ArrayList<String>();
		
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors())
			errors.add(fieldError.getField() + "-" + fieldError.getDefaultMessage());
		for(ObjectError objectError : ex.getBindingResult().getGlobalErrors())
			errors.add(objectError.getObjectName() + "-" +objectError.getDefaultMessage());
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),errors);
		return handleExceptionInternal(ex, errorMessage, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
}