import ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		PhoneInfo p1 = new PhoneInfo("박예진", "010-2210-0000", "96-04-14");
		PhoneInfo p2 = new PhoneInfo("박용문", "010-7579-0000");
		
		p1.showPhoneInfo(); //인자 3개 인포 호출
		p2.showPhoneInfo(); //인자 2개 인포 호출
	}

}
