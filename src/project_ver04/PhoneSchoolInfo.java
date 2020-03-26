package project_ver04;

public class PhoneSchoolInfo extends PhoneInfo{
	
	String major ; //전공
	int school; //학년
	
	public PhoneSchoolInfo(String name, String phoneNumber,
			String address,String major,int school) {
		super(name, phoneNumber, address);
		this.major=major;
		this.school=school;
			
		
	}
	@Override
	public void showPhoneInfo() {
		System.out.println("==동창정보(전체정보)");
		showPhoneInfo();
		System.out.println("전공:"+major);
		System.out.println("학년:"+school);
	}

	

}
