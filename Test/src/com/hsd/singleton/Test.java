package com.hsd.singleton;

public class Test {
	public static void main(String[] args) {
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		if(bank1==bank2){
			System.out.println("������ͬһ��,ûɶ��һ��");
		}else{
			System.out.println("���ǲ�һ������һ��");
		}
		
		Bank2 bank3 = Bank2.getInstance();
		Bank2 bank4 = Bank2.getInstance();
		if(bank3==bank4){
			System.out.println("������ͬһ��,ûɶ��һ��");
		}else{
			System.out.println("���ǲ�һ������һ��");
		}
	}

}
