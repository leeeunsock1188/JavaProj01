package project;

import java.util.Scanner;

import project_ver02.PhoneInfo;

public class PhoneBookVar2 {

	public static void startaddress() {

		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("이름을 입력하세요.");
			String name =scan.nextLine();
			System.out.println("번호를 입력하시오:");
			String phone = scan.nextLine();
			System.out.println("생년월일을 입력하시오:");
			String birth = scan.nextLine();


			System.out.println();

			PhoneInfo p1 = new PhoneInfo(name, phone,
					birth);
			PhoneInfo p2 = new PhoneInfo("브루스배너","010-2222-2222");

			p1.showPhoneInfo();
			p2.showPhoneInfo();//생년월일 입력되지않음.
			int restart ;
			System.out.println("1.데이터입력, 0.프로그램 종료");
			restart= scan.nextInt();

			if(restart == 0) {
				break;
			}
			else if(restart == 1) {
				startaddress();
			}
			else if(!(restart==0)) {
				System.out.println("잘못입력했음 1번 과 0번만 입력하시오.");
			}

		}//while문

	}
	public static void main(String[] args) {

		startaddress();
		





	}
}

