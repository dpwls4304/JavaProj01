package ver07;

public class PhoneInfo {
	//멤버변수
	private String name;
	private String phoneNumber; 
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo isSame = (PhoneInfo)obj;
		if(isSame.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}