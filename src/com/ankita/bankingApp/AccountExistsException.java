package com.ankita.bankingApp;

public class AccountExistsException extends Exception {
	static final long serialVersionUID = 1L;

	public AccountExistsException(String message) {
		super(message);
	}
}
