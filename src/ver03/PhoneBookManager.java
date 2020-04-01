package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	//멤버변수
	private PhoneInfo[] dataSave;
	private int numOfSaving;
	int Menucount=1;//메뉴공백
	
	//생성자 : 객체배열의 크기를 알 수 있는 매개변수 받기
	public PhoneBookManager(int num) {
		dataSave = new PhoneInfo[num];
		numOfSaving = 0;
	}
	
	/*멤버메소드*/
	//메뉴출력
	public void printMenu() {
		if(Menucount>=2)
			System.out.println();
	
		System.out.println("[메뉴를 선택하세요]");
		System.out.println("[1]데이터 입력");
		System.out.println("[2]데이터 검색");
		System.out.println("[3]데이터 삭제");
		System.out.println("[4]주소록 출력");
		System.out.println("[5]프로그램 종료");
		
		Menucount++;
	}
	
	//입력
	public void dataInput() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==데이터 입력을 시작합니다.==");
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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==데이터 검색을 시작합니다.==");
		System.out.print("검색할 이름:");
		String user = scan.nextLine();
		
		//이름을 기준으로 배열에서 하나씩 비교
		for(int i=0; i<numOfSaving; i++) {
			if(user.compareTo(dataSave[i].name)==0) {
				
				dataSave[i].showPhoneInfo();//출력형식 다름,하는중
				System.out.println("==데이터 검색이 완료되었습니다.==");
			}
		}
	}
	
	//삭제
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름:");
		String user = scan.nextLine();
		
		System.out.println("==데이터 삭제==");
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfSaving; i++) {//Q:dataSave.length는 안되나
			if(user.compareTo(dataSave[i].name)==0) {
				dataSave[i]=null;
				deleteIndex = i;
				numOfSaving--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("==삭제할 데이터를 찾지 못했습니다.==");
		}
		else {
			for(int i=deleteIndex; i<numOfSaving; i++) {
				dataSave[i] = dataSave[i+1];
			}
			System.out.println("==데이터 삭제가 완료되었습니다.==");
		}
	}
	
	//주소록전체출력
	public void dataAllShow() {
		if(numOfSaving == 0) {
			System.out.println("==출력할 데이터가 없습니다.==");
		}
		for(int i=0; i<numOfSaving; i++) {
			System.out.println("\n<" +(i+1) + "번 데이터 출력>");
			dataSave[i].showPhoneInfo();
		}
	}
}
