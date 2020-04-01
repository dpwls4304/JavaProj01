package ver02;

public class PhoneInfo {

	//멤버변수
	String name;
	String phoneNumber; 
	String birthday;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("\n<입력된 정보 출력>");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		if(birthday == null) {
			System.out.println("생년월일:입력되지 않음");
		}
		else {
			System.out.println("생년월일:"+ birthday);
		}
	}
}
