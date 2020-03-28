package project_ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

import project_ver06.PhoneSchoolInfo;

public class PhoneBookManager{

	public PhoneInfo[] info;
	public int numOfinfo;  


	public PhoneBookManager(int num) {
		info = new PhoneInfo[num];//info 변수에  PhoneInfo객체 100개를 넣음 
		numOfinfo = 0; // int형으로 선언함 값은 0 

	}





	//=============================1번 데이터 입력 ============================
	public void dateInput1(int choice) { //switch 값을 넣어줌 

		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAdder,major,company;
		int school;

		//공통사항 입력받기 
		System.out.println("이름:");iName= scan.nextLine(); //위에 선언한 String타입의 변수에 값을 넣음 
		System.out.println("전화번호:");iPhone =scan.nextLine();//넣고 바로 System.out.print로 
		System.out.println("주소:");iAdder= scan.nextLine();// 불름 




		if(choice==SubMenultem.BASIC) {
			PhoneInfo phone= new PhoneInfo(iName, iPhone, iAdder);
			info[numOfinfo++] = phone;
			System.out.println("데이터 입력이 완료되었습니다.");

		}
		else if(choice==SubMenultem.SCHOOL) {//동창정보 
			System.out.print("전공:"); major=scan.nextLine();
			System.out.print("학번:"); school=scan.nextInt();
			PhoneSchoolInfo sch = new PhoneSchoolInfo(iName, iPhone, iAdder,major,school);
			info[numOfinfo++] = sch;
			System.out.println("동창친구정보가 입력이 완료되었습니다.");

		}
		else if(choice==SubMenultem.COMPANY) {//회사정보 
			System.out.print("회사:"); company = scan.nextLine();
			PhoneCompanyInfo com = new PhoneCompanyInfo(iName, iPhone,
					iAdder, company);
			info[numOfinfo++] = com;
			System.out.println("회사정보가 입력이 완료됬습니다.");


		}
	}


	//===================데이터 검색 검색22=================================== 
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName =scan.nextLine();

		for(int i=0; i<numOfinfo; i++) {
			System.out.println("검색중인이름:"+info[i].name);

			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함.
			if(searchName.compareTo(info[i].name)==0) { //compareTo 비교 연산자 

				info[i].showPhoneInfo();

				System.out.println("**귀하가 요청하는 정보를 찾았습니다**");
			}else {
				System.out.println("**정보가 없습니다.**");
			}
		}
	}////end of searchInfo

	//				dataSearch()===================-========3번 데이터 삭제 =================================
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요.");
		String deleteName = scan.nextLine();

		/*
					 배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도로 변수 
					 요소를 삭제한후 빈자리를 채울때 사용할 예정임. 
		 */
		int deleteIndex = -1; 
		for(int i=0; i<numOfinfo; i++) {
			if(deleteName.compareTo(info[i].name)==0){
				//요소를 삭제하기 윟새 참조값을 null로 변경
				info[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체카운트 변수 -1 차감 
				numOfinfo--;
			}
		}

		if(deleteIndex==-1) {
			// 검색된 데이터가 없는경우... 
			System.out.println("===삭제된 데이터가 없습니다==");
		}
		else {
			/*
						 객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를 
						 핲으로 하나씩 교환한다.
			 */
			for(int i=deleteIndex; i<numOfinfo; i++) {
				info[i] = info[i+1];

			}
			System.out.println("===데이터("+deleteIndex+"번) 가 삭제되었습니다--");
		}
		//					
	}///end of deleteInfo

	///4번 주소록 출력: dataAllShow 검색 
	public void dataAllShow() {
		for(int i=0; i<numOfinfo ; i++ ) {
			info[i].showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}



	public void printMenu() {


		

		while(true) {

			System.out.println("1.데이터 입력:");
			System.out.println("2.데이터 검색:");
			System.out.println("3.데이터 삭제:");
			System.out.println("4.주소록 출력:");
			System.out.println("5.프로그램 종료:");

			try {
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				if(choice < 1 || choice > 5) { 
					MenuSelectException mse =new MenuSelectException();
					throw mse;
				} // if end...


				switch(choice) {
				case Menultem.INPUT: // 1 입력
					System.out.println("데이터 입력을 시작합니다.\n"
							+"1.일반, 2.동창, 3.회사");

					Scanner scan =new Scanner(System.in);
					int num = scan.nextInt();
					if(!(num<1 || num >3)) {
						dateInput1(num); //입력
						break;
					}
					else { System.out.println("=======다시 입력 (1)~(3)==1======");
					printMenu();
					}
					case Menultem.SEARCH:  // 2 검색
						dataSearch();//검색
						break;
					case Menultem.DELETE: // 3 삭제
						deleteInfo();//삭제
						break;
					case Menultem.SHOW: // 4 출력
						dataAllShow();//전체 검색 
						break;
					case Menultem.BYE:  // 5 ALL종료 
						System.out.println("프로그램을 종료합니다.");
					
						return;
					
					} // switch end...
				
			} 
			catch (MenuSelectException e) {
				System.out.println("[예외발생] :"+e.getMessage());
			} // catch end..
			catch (InputMismatchException e) {
				System.out.println("문자말고 숫자를 입력하시오.");
			}
			catch (NullPointerException e) {
				System.out.println("검색결과가 없습니다.");
			}
		}



	} // while end...
}// method end..

