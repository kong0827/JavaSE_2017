package com.hsd.singleton;
/**
 * ±¥ººÊ½
 * 
 */
public class Bank2 {
	private static Bank2 bank;
	private Bank2(){
		
	}
	
	public static Bank2 getInstance(){
		if(bank==null){
			bank = new Bank2();
			return bank;
		}
		return bank;
	}

}
