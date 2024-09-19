package com.tp.marketplace.aop;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tp.marketplace.exception.ErrorResponse;
import com.tp.marketplace.exception.TpCropPriceException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	public static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(TpCropPriceException.class)
	public ResponseEntity<ErrorResponse> tpCropPriceExceptionHandler(TpCropPriceException exception){
		
		String errorCode = exception.getMessage();
        String errorMessage = environment.getProperty(exception.getMessage());
		ErrorResponse errorInfo = new ErrorResponse(errorCode,errorMessage);
		LOGGER.error(errorCode+" "+errorMessage);
		return new ResponseEntity<ErrorResponse>(errorInfo,HttpStatus.ALREADY_REPORTED);
	}
	
}
