package com.example.CaseStudyCart.CartManagement.controller;

@SuppressWarnings("serial")
public class CartNotFoundException extends RuntimeException 
{
	public CartNotFoundException(String message)
	{
		super(message);
	}
}
