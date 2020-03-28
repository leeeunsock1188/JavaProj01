package project_ver07;

public class PhoneSchoolInfo extends PhoneInfo{
	
	String major ; //전공
	int school; //학년
	
	public PhoneSchoolInfo(String name, String phoneNumber,
			String address,String major,int school) {
		super(name, phoneNumber, address);
		this.major=major; //전공
		this.school=school; //학번 
			
		
	}
	@Override
	public void showPhoneInfo() {
		
		System.out.println("==동창정보(전체정보)");
		super.showPhoneInfo();
		System.out.println("전공:"+major);
		System.out.println("학년:"+school);
	}

	@Override
	public String toString() {
		
		return super.toString()+ "\n전공:"+ major+"\n학년:"+school;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + school;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneSchoolInfo other = (PhoneSchoolInfo) obj;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (school != other.school)
			return false;
		return true;
	}

	
}
