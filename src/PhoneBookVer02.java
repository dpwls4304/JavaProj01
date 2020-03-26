import java.util.Scanner;

import ver02.PhoneInfo;

public class PhoneBookVer02 {
	
	public static void menuShow() {
		
		System.out.println("[메뉴를 선택하세요]");
		System.out.println("[1]데이터 입력");
		System.out.println("[2]프로그램 종료");
	}
	
	
	public static void main(String[] args) {
	
		Scanner scan1 = new Scanner(System.in);//메뉴받을 스캐너
		Scanner scan2 = new Scanner(System.in);//정보받을 스캐너
		int userNum;//1 or 2선택
		String name, phone, birth;
		
		while(true) {
			menuShow();
			System.out.print("번호입력:");
			userNum = scan1.nextInt();

			switch (userNum) {
			case 1:
				System.out.print("이름:");
				name = scan2.nextLine();
				System.out.print("전화번호:");
				phone = scan2.nextLine();
				System.out.print("생년월일:");
				birth = scan2.nextLine();
				
				//birth에 아무것도 입력되지 않을시 null로 처리
				if(birth.equals(""))
					birth = null;
				
				PhoneInfo ph = new PhoneInfo(name, phone, birth);
				ph.showPhoneInfo();		
				break;
				
			case 2: 
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
