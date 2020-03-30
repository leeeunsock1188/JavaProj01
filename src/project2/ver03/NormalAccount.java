package project2.ver03;

public class NormalAccount extends Account {
	int  interest; //==================일반계좌 이자방식 ============
	
	public NormalAccount(String name, String accountNumber, int balace, int interest) {
		super(accountNumber,name , balace);
		this.interest = interest;
	}
	
	@Override
	public void showaccountInfo() {
		super.showaccountInfo();
		System.out.println("이자:"+ interest);
	}
	
	@Override
	public int valus(int num) {
		
		return balace = balace + (balace * interest)/100 + num;
			// 내가 스캐너로 보낸 잔고 + (잔고 * 이자율)/100 + 입금할금액)
	}
}

