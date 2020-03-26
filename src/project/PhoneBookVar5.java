package project;


import java.util.Scanner;

import project_ver05.Menultem;
import project_ver05.PhoneBookManager;



	public class PhoneBookVar5 {




		public static void printMenu() {


			System.out.println("1.데이터 입력:");
			System.out.println("2.데이터 검색:");
			System.out.println("3.데이터 삭제:");
			System.out.println("4.주소록 출력:");
			System.out.println("5.프로그램 종료:");
		}


		public static void main(String[] args) {

			PhoneBookManager manage = new PhoneBookManager(100);// 100개를 저장할수있는거

		

			while(true) {
				printMenu();//메뉴를 계속 출력하게함 

				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch(choice) {
				case Menultem.INPUT: 
					System.out.println("데이터 입력을 시작합니다.\n"
							+"1.일반, 2.동창, 3.회사1");
						Scanner scan =new Scanner(System.in);
				int num = scan.nextInt();
					manage.dateInput1(num); //입력
					break;
				case Menultem.SEARCH:  
					manage.dataSearch();//검색
					break;
				case Menultem.DELETE:
					manage.deleteInfo();//삭제
					break;
				case Menultem.SHOW: 
					manage.dataAllShow();//전체 검색 
					break;
				case Menultem.BYE: 
					System.out.println("프로그램을 종료합니다.");
				return;
					
				}


			}

		}

	}

