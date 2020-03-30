package project_ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable {
	
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
	
	@Override
	public String toString() {
	
		return "이름: " +name+ "전화번호:" +
		phoneNumber + "생년월일:"+ address ;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneInfo other = (PhoneInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}


	public void showPhoneInfo1() {}
	
	
}
