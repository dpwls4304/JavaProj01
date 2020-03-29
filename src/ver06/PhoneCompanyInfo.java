package ver06;

public class PhoneCompanyInfo extends PhoneInfo{
	
	//멤버변수
	private String company;
	
	//생성자
	public PhoneCompanyInfo(String name, String phoneNumber,
			String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사:" + company);
	}

}
