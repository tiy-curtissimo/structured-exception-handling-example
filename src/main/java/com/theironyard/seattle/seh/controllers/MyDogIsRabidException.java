package com.theironyard.seattle.seh.controllers;

public class MyDogIsRabidException extends Exception {

	private String dogName;
	public MyDogIsRabidException(String dogName) {
		this.dogName = dogName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The rabid dog is " + getDogName();
	}
	
	public String getDogName() {
		return dogName;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
