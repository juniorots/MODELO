package com.modelo;

public class LivroException extends Exception {

	private static final long serialVersionUID = -577859972644079674L;
	
	public LivroException() {
		super();
	}
	public LivroException(String msg) {
		super(msg);
	}
	public LivroException(String msg, Throwable t) {
		super(msg, t);
	}
}
