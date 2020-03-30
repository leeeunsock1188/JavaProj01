package project2.ver02;

public class HighCreditAccount extends Account implements CustomSpecialRate{

	int interest ;
	String credit;
	public HighCreditAccount(String name, String accountNumber, int balace , int interest, String credit) {

		super(accountNumber,name, balace);
		this.interest = interest;
		this.credit = credit;

	}

	@Override
	public void showaccountInfo() {
		super.showaccountInfo();

		System.out.println("이자:"+ interest);
		System.out.println("신용신뢰등급:"+ credit);
	}

	@Override
	public int valus(int plus) {
		int num1 =0 ;
		switch(credit) {
		case "A": 
			num1 = A; //7
			break;
		case "B":
			num1 = B;//4
			break;
		case "C": 
			num1 = C;//2
			break;

		}
		return balace+(balace*interest)/100+(balace*num1)/100+plus; 
	}

}


