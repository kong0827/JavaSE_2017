package com.hsd.singleton;

/**
 * 
 * ����ʽ
 *
 */
public class Bank {
	private static Bank bank = new Bank();
	
	private Bank(){
		
	}
	
	public static Bank getInstance(){
		return bank;
	}

}
