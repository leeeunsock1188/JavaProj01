package project2.ver03;

import java.util.Scanner;

public class Account {
	String name;
	String accountNumber;
	int balace; 
	
	public Account(String name, String accountNumber, int balace) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balace = balace;
	}


	public void showaccountInfo() {
		System.out.println("계좌번호:" +accountNumber);
		System.out.println("이름:" +name);
		System.out.println("잔액:" +balace);
	}
	
	public void value(int num ) {
	}


	public int valus(int plus) {
		// TODO Auto-generated method stub
		return 0;
	}

}
