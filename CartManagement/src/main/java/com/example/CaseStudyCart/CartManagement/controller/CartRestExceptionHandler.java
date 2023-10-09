package com.example.CaseStudyCart.CartManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class CartRestExceptionHandler 
	{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@ExceptionHandler
		public ResponseEntity<CartErrorResponse> handleException(CartNotFoundException enfe)
		{
			CartErrorResponse err = new CartErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											enfe.getMessage(),
											System.currentTimeMillis());
			
			return new ResponseEntity(err,HttpStatus.NOT_FOUND);
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@ExceptionHandler
		public ResponseEntity<CartErrorResponse> handleException(Exception e)
		{
			CartErrorResponse err = new CartErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											e.getMessage(),
											System.currentTimeMillis());
			
			return new ResponseEntity(err,HttpStatus.NOT_FOUND);
		}

	}

