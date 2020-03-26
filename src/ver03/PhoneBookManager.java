package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	//멤버변수
	private ver03.PhoneInfo[] dataSave;
	private int numOfSaving;
	
	//생성자 : 객체배열의 크기를 알 수 있는 매개변수 받기
	public PhoneBookManager(int num) {
		dataSave = new PhoneInfo[num];
		numOfSaving = 0; //Q:이거 초기화 위에 멤버변수에서 해도 상관없나?
	}
	
	/*멤버메소드*/
	//메뉴출력
	public void printMenu() {
		System.out.println("[메뉴를 선택하세요]");
		System.out.println("[1]데이터 입력");
		System.out.println("[2]데이터 검색");
		System.out.println("[3]데이터 삭제");
		System.out.println("[4]주소록 출력");
		System.out.println("[5]프로그램 종료");
	}
	
	//입력
	public void dataInput() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름:");
		String name = scan.nextLine();
		System.out.print("전화번호:");
		String phone = scan.nextLine();
		System.out.print("생년월일:");
		String birth = scan.nextLine();
		if(birth.equals(""))
			birth = null;
		PhoneInfo ph = new PhoneInfo(name, phone, birth);
		dataSave[numOfSaving++] = ph;
	}
	
	//검색
	public void dataSearch() {
		
	}
	
	//삭제
	public void dataDelete() {
		
	}
	
	//주소록전체출력
	public void dataAllShow() {
		for(int i=0; i<numOfSaving; i++)
			dataSave[i].showPhoneInfo();
	}
}
