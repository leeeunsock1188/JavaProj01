package project_ver07;

public class PhoneCompanyInfo extends PhoneInfo{
	
	String mdSystem;//회사이름 
	
	public PhoneCompanyInfo(String name, String phoneNumber, String address,String mdSystem) {
		super(name, phoneNumber, address);
		this.mdSystem=mdSystem;
		
	}
		@Override
		public void showPhoneInfo() {
			System.out.println("==회사정보 (전체정보)====");
			super.showPhoneInfo();
			System.out.println("회사이름:"+mdSystem);
		}

	
}
