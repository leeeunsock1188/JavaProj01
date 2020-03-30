package project2.ver03;

import java.util.Scanner;


public class AccountManager {

	String accountNumber,name,credit;//계좌번호 
	int balance,interest;//잔액 
	public Account[] count;
	public int numOfcount;

	Scanner scan = new Scanner(System.in);

	public AccountManager(int num) {
		//		final String ACCOUNT_NUMBER; //이름,계좌 번호 

		count = new Account[num];
		numOfcount =0;
	}

	public void printMenu() {

		while(true) {

			System.out.println("1. 계좌개설:");
			System.out.println("2. 입	금:");
			System.out.println("3. 출	금:");
			System.out.println("4. 계좌정보출력:");
			System.out.println("5. 프로그램 종료:");

			int choice = scan.nextInt();  // 메뉴선택
			scan.nextLine(); // 버퍼 날림 

			if(!(choice<1 || choice >5)) {
				switch(choice) {
				case MenuChoice.MAKE:  //1 

					makeAccount();//계좌계설 (1)
					break;
				case MenuChoice.DEPOSIT:
					depositMoney();//입금 (2)
					break;
				case MenuChoice.WITHDRAW:
					withdrawMoney();//출금 (3)
					break;
				case MenuChoice.INQUIRE: //전체 정보 출력하기 (4)
					showAccInfo();
					break;

				case MenuChoice.EXIT://종료(5)
					System.out.println("system을 종료합니다.");
					return;

				}
			}
			else { 
				System.out.println("(1)~(5) 숫자만 입력하세요:");
			}
		}
	}
	//===============1계좌계설=================
	public void makeAccount()  {


		System.out.println("***신규계좌개설***");
				
		System.out.println("---계좌선택---");
		System.out.println("1보통계좌");
		System.out.println("2신용신뢰계좌");
		
		int choice = scan.nextInt();
		scan.nextLine(); //버퍼날림
		switch(choice) {
		case 1: 
			System.out.println("***신규계좌개설***");
			System.out.println("계좌번호:"); accountNumber = scan.nextLine();
			System.out.println("이름:"); name = scan.nextLine();
			System.out.println("잔액:"); balance= scan.nextInt();
					scan.nextLine();
			System.out.println("이자:"); interest= scan.nextInt();
					scan.nextLine();
			NormalAccount normal = new NormalAccount(accountNumber, name, balance, interest);
			count[numOfcount++] =  normal;
			System.out.println("계좌계설이 완료되었습니다.");
			break;
		case 2: 
			System.out.println("***신규계좌개설***");
			System.out.println("계좌번호:"); accountNumber = scan.nextLine();
			System.out.println("이름:"); name = scan.nextLine();
			System.out.println("잔액:"); balance= scan.nextInt();
			scan.nextLine();
			System.out.println("이자:"); interest= scan.nextInt();
			scan.nextLine();
			System.out.println("신용등급:"); credit= scan.nextLine();
			
			HighCreditAccount hight = new HighCreditAccount(accountNumber, name, balance, interest, credit);
			count[numOfcount++] =  hight;
			break;
		}
		/*for(int i=0; i<numOfcount; i++) {

			if(accountNumber.compareTo(count[i].accountNumber)==0) {
				System.out.println("같은계좌가 있습니다. 다른계좌를 설정해주새요");
				
			} 
			
		}*/
		

	}
	//===============2번 입금 ===============
	public void depositMoney() {
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.println("계좌번호:");
		String number = scan.nextLine();
		System.out.println("입금액:");
		int plus = scan.nextInt();

		for(int i=0; i<numOfcount; i++) {

			//내가 지금 입력한 계좌번호 하고 정보를 저장하는  class CountInfo객체를 포함하는 
			// 1번 눌렀을떄 저장한 객체중에 accountNumber(계좌번호가 같은것을 비교) 
			if(number.compareTo(count[i].accountNumber)==0) {
				count[i].balace = count[i].valus(plus);
				System.out.println("입금이 완료되었습니다.");
			}
		}


	}
	//===============3번 출금 ===============
	public void withdrawMoney() {
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.println("계좌번호:");
		String number = scan.nextLine();
		System.out.println("출금액:");
		int plus = scan.nextInt();

		for(int i=0; i<numOfcount; i++) {

			//내가 지금 입력한 계좌번호 하고 정보를 저장하는  class CountInfo객체를 포함하는 
			// 1번 눌렀을떄 저장한 객체중에 accountNumber(계좌번호가 같은것을 비교) 
			if(number.compareTo(count[i].accountNumber)==0) {
				System.out.println("출금이 완료되었습니다.");
				count[i].balace -= plus;
			}
		}
	}
	//===============4번 전체계좌정보 출력 ======
	public void showAccInfo() {

		for(int i=0; i<numOfcount; i++) {
			count[i].showaccountInfo(); 
		}
		System.out.println("==[전체정보]가 출력되었습니다==");
		
	}




}

