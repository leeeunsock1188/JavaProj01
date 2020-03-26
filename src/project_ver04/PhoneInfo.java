package project_ver04;

public class PhoneInfo {
	//멤버변수
	String name; //이름
	String phoneNumber; //전화번호 
	String address; //주소
	//생성자 
	public PhoneInfo(String name, String phoneNumber, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	
	//정보 출력용 메소드 
	public void  showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		System.out.println("생년월일:"+address);
		
		
	}
	public void showPhoneInfo1() {}
	
	
}
