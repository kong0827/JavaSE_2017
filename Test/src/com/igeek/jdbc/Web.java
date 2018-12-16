package com.igeek.jdbc;

import org.junit.Test;

public class Web {
	Account a1= new Account();
	Account a2 = new Account();
	Service service = new Service();
	
	@Test
	public void test(){
		a1.setId(1);
		a1.setName("jack");
		a1.setMoney(10000);
		
		a2.setId(2);
		a2.setName("rose");
		a2.setMoney(10000);
		
		boolean transfer = service.transfer(a1,a2);
		
		if(transfer){
			
			System.out.println("转账成功");
		}else{
			System.out.println("转账失败");
		}
		
		
	}

}
