package project_ver08;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project_ver08.PhoneSchoolInfo;

public class PhoneBookManager{
	Scanner scan = new Scanner(System.in, "EUC-KR");
	int numOfinfo;
	HashSet<PhoneInfo> hash;

	public PhoneBookManager() {

		hash = new HashSet<PhoneInfo>();
	}





	//=============================1번 데이터 입력 ============================
	public void dateInput1(int choice) { //switch 값을 넣어줌 

		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAdder,major,company; //이름,폰,주소,학과?,회사,정보지
		int school; //학교정보 지정 

		//공통사항 입력받기 
		System.out.println("이름:");iName= scan.nextLine(); //위에 선언한 String타입의 변수에 값을 넣음
		System.out.println("전화번호:");iPhone =scan.nextLine();//넣고 바로 System.out.print로 
		System.out.println("주소:");iAdder= scan.nextLine();// 불름 

		if(choice==SubMenultem.BASIC) { //1번 일반정보 저장하는곳 
			PhoneInfo phone= new PhoneInfo(iName, iPhone, iAdder);
			hash.add(phone);
			System.out.println("데이터 입력이 완료되었습니다.");

		}
		else if(choice==SubMenultem.SCHOOL) {//2번 동창정보 저장하는곳
			System.out.print("전공:"); major=scan.nextLine(); //전공정보 지정
			System.out.print("학번:"); school=scan.nextInt(); //학번정보 지정 
			PhoneSchoolInfo sch = new PhoneSchoolInfo(iName, iPhone, iPhone, major, school);
			hash.add(sch);
			System.out.println("동창친구정보가 입력이 완료되었습니다.");

		}
		else if(choice==SubMenultem.COMPANY) {//3번 회사정보 저장하는곳 
			System.out.print("회사:"); company = scan.nextLine();
			PhoneCompanyInfo com = new PhoneCompanyInfo(iName, iPhone,
					iAdder, company);
			hash.add(com);
			System.out.println("회사정보가 입력이 완료됬습니다.");


		}
	}


	//===================데이터 검색 검색22=================================== 
	public void dataSearch() {
		System.out.println("검색할 이름을 입력하세요:");
		System.out.println("몇개인지확인:"+hash.size());
		String searchName =scan.nextLine();
		//		boolean find =false;
		Iterator<PhoneInfo> itr = hash.iterator();


		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(pi.name.equals(searchName)) {
				System.out.println("**귀하가 요청하는 정보를 찾았습니다**"+pi.name);
				pi.showPhoneInfo();
				//				find = true;

			}else {
				System.out.println("정보가 없습니다.");
			}
		}
		//		if(find=false) {
		//			NullPointerException ex = new NullPointerException();
		//			throw ex;
		//		}



	}////end of searchInfo

	//				dataSearch()===================-========3번 데이터 삭제 =================================

	public void deleteInfo() {

		System.out.println("삭제할 이름을 입력하세요.");
		String deleteName = scan.nextLine();

		/*
		for(PhoneInfo pi : hash) {
			if(pi.name.equals(deleteName)) {
				hash.remove(pi);
				System.out.println(deleteName+"의 정보가 삭제되었습니다.");
			}
		}
		 * Exception in thread "main" java.util.
		 * ConcurrentModificationException 에러 현출
		 *  데이터를 hashset에  담아서 작업 도중 유효성 검사 등을 통해서 조건에 맞지 않는것을 삭제하려고 한다.
		 * 루프(loop)를 돌면서 유효성을 체크해서 삭제를 하는데 , 일반적인 for루프를 사용 하면 예외가 발생
		 * 하거나 원하는 결과를 얻지 못할 수 있다. 
		 * 
		 * 삭제를 해버리면 내부적으로 루핑을 돌기 위해 사용하는 list의 크기와 처리해야할 항목을 가리키는
		 * 인덱스의 불일치 떄문에 에러 또는 논리적인 오류가 발생한다. 
		 * 
		 */

		Iterator<PhoneInfo> iter = hash.iterator();
		while (iter.hasNext()) {	
			PhoneInfo s= iter.next();
			if(s.name.equals(deleteName)) {

				System.out.println("**정상적으로 삭제가 완료 되었습니다**");
				iter.remove();
			}

		}


	}
	public void dataAllShow() {

		Iterator<PhoneInfo> iter =hash.iterator();
		while(iter.hasNext()) {
			PhoneInfo info = iter.next();
			System.out.println("***주소록을 (전부) 출력합니다***");

			info.showPhoneInfo();
			/*	System.out.print(info.showPhoneInfo()); --[에러발생] 

			The method println(boolean) in the type PrintStream is not 
			applicable for the arguments (void)
			showPhoneInfo 는 반환형이 void 이기떄문에 아무것도 반환하지 않는다고 
			정의했음. 즉아무것도 인쇄 할 수없음. 그냥 info.showPhoneInfo로 호출해야한다.
			 */
		}
	}




	public void printMenu() {

		extractPhoneBook();


		while(true) {

			try {
				System.out.println("1.데이터 입력:");
				System.out.println("2.데이터 검색:");
				System.out.println("3.데이터 삭제:");
				System.out.println("4.주소록 출력:");
				System.out.println("5.프로그램 종료:");

				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt(); //choice에 입력할수있게 해주고 
				if(choice < 1 || choice > 5) {  //1 ~5 까지만 넣을수있게끔 조건을 줌 
					MenuSelectException mse =new MenuSelectException(); // 예외 발생시킴 1~5까지만 올수있는데 6을 주면
					throw mse; // 사용자 정의로만든 클래스에 드로우 던진다 거기서 해결하게끔  5이상 나오면 멍청이라는 익셉션이 발동함
				} // if end...  1~5 를 맞게 넣었다면 아래 스위치문 실행 


				switch(choice) { //switch 문에 숫자가 들어가면 1~5 에 해당하는 숫자가 case에 들어간다 
				case Menultem.INPUT: // 1 입력 Input(1)
					System.out.println("데이터 입력을 시작합니다.\n"
							+"1.일반, 2.동창, 3.회사");

					Scanner scan =new Scanner(System.in);
					int num = scan.nextInt();
					if(!(num<1 || num >3)) { //1~3이 들어가지 않으면 else로 이동해서 다시입력이라는 콘솔이 나오면서  printMenu()를 다시 호출함. 
						dateInput1(num); //입력  1 입력시 dateInput(1)매개변수에 1이들어가면서 일반정보 저장하는곳으로 들어감
						break;
					}
					else { System.out.println("=======다시 입력 (1)~(3)==1======");
					printMenu();
					}
				case Menultem.SEARCH:  // 2 검색 SEARCH(2)
					dataSearch();//검색
					break;
				case Menultem.DELETE: // 3 삭제 DELETE(3)
					deleteInfo();//삭제
					break;
				case Menultem.SHOW: // 4 출력 SHOW (4)
					dataAllShow();//전체 검색 
					break;
				case Menultem.BYE:  // 5 ALL종료  BYE (5)
					System.out.println("프로그램을 종료합니다.");
					savePhoneBook();
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

	public void savePhoneBook() {		
		try {
			FileOutputStream fout = new FileOutputStream
					("src/project_ver08/PhoneBook.obj");
			ObjectOutputStream out = new ObjectOutputStream(fout);

			//			BufferedWriter writer = new BufferedWriter(
			//					new OutputStreamWriter(new FileOutputStream("src/project_ver08/test1.txt"), "UTF-8"));

			//			ObjectOutputStream out = 
			//					new ObjectOutputStream(
			//							new FileOutputStream
			//								("src/ver08/PhoneBook.obj")
			//					);
			
			Iterator<PhoneInfo> itr = hash.iterator();
			while(itr.hasNext()) {
				// set에있는 첫번쨰 객체를 가져옴
				PhoneInfo phone = itr.next();
				// 해당 첫번쨰 객체를 파일에 넣음
				out.writeObject(phone);
				// 로그출력
				System.out.print(phone.toString() + " 내용이 저장되었습니다.");
			}
			//			writer.write(hash.toString());
			
			out.flush();
			out.close();
		}
		catch (IOException e) {
			System.out.println("파일이 저장되지 않았습니다.");
			e.printStackTrace();
		}

	}
	public void extractPhoneBook() {	
		try {

			FileInputStream fint = new FileInputStream("src/project_ver08/PhoneBook.obj");
			ObjectInputStream in = new ObjectInputStream(fint);
			
			Object read;	// while문안에서 read안에다가 값을 저장할 수 있게 while문 밖에서 선언
			
//			while(true) {
//				// while문을 끝내기 위한 조건문
//				if(		// read라는 위에서 선언한 Object변수에 inputStream에서 읽어온( readObject)
//						// 값을 Object단위로 넣어준다.
//						(read = in.readObject())
//						== null ) {
//					break;
//				}
//				System.out.println(read.toString());
//			}
			
			while(
					( read = in.readObject() )  != null) { // null이 아니면 아래 hash문 실행 
				hash.add((PhoneInfo)read);
				System.out.println(read.toString());
			}
			
			in.close();
			
		} catch (Exception e) {
//			System.out.println("파일을 불러올 수 없습니다.");
//			e.printStackTrace();
		}
		
	}
}// method end..

