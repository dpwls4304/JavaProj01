package ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem {
	 HashSet<PhoneInfo> phoneInfo;
	int menuCount;//출력 메뉴용 공백
	Scanner scan1;
	Scanner scan2;
	boolean tOrF;
	
	//생성자
	public PhoneBookManager(int num) {
		phoneInfo = new HashSet<PhoneInfo>();
		menuCount = 1;
	}
	
	//메뉴출력
	public void printMenu() {
		if(menuCount>=2)
			System.out.println();
	
		System.out.println("[메뉴선택]");
		System.out.println("[1]데이터 입력");
		System.out.println("[2]데이터 검색");
		System.out.println("[3]데이터 삭제");
		System.out.println("[4]주소록 출력");
		System.out.println("[5]프로그램 종료");
		System.out.print("번호입력:");
		
		menuCount++;
	}
	
	//1.입력
	public void dataInput() {
		scan1 = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		
		System.out.println("==데이터 입력을 시작합니다.==");
		System.out.println("[1]일반, [2]동창, [3]회사");
		System.out.print("선택>>");
		int subMenu = scan1.nextInt();
		
		switch(subMenu) {
		case BASIC:
			System.out.print("이름:");
			String name1 = scan2.nextLine();
			System.out.print("전화번호:");
			String phone1 = scan2.nextLine();
			phoneInfo.add(new PhoneInfo(name1, phone1));
			Iterator<PhoneInfo> itr = phoneInfo.iterator();
			while(itr.hasNext()) {
				PhoneInfo data = itr.next();
				if(data.name.equals(name1)) {
					System.out.println("==중복된 값이 존재합니다. 덮어쓰기하시겠습니까?==");
					System.out.print("[1]예, [2]아니오>>");
					int dOrs = scan1.nextInt();
					if(dOrs == 1) {
						phoneInfo.remove(data);
						phoneInfo.add(new PhoneInfo(name1, phone1));
						break;
					}
					if(dOrs == 2) {
						break;
					}
				}
			}
			
		case SCHOOL:
			System.out.print("이름:");
			String name2 = scan2.nextLine();
			System.out.print("전화번호:");
			String phone2 = scan2.nextLine();
			System.out.print("전공:");
			String major = scan2.nextLine();
			System.out.print("학년(숫자만가능):");
			int grade = scan2.nextInt();
			phoneInfo.add(new PhoneSchoolInfo(name2, phone2, major, grade));
			break;
			
		case COMPANY:
			System.out.print("이름:");
			String name3 = scan2.nextLine();
			System.out.print("전화번호:");
			String phone3 = scan2.nextLine();
			System.out.print("회사:");
			String company = scan2.nextLine();
			phoneInfo.add(new PhoneCompanyInfo(name3, phone3, company));
			break;
		}
	}
	
	//2.검색
	public void dataSearch() {
		scan1 = new Scanner(System.in);
		tOrF = false;
		System.out.println("==데이터 검색을 시작합니다.==");
		System.out.print("검색할 이름:");
		String searching = scan1.nextLine();
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.name.equals(searching)) {
				tOrF = true;
				info.showPhoneInfo();
				System.out.println("==데이터 검색을 왼료했습니다.==");
				break;
			}
		}
		if(tOrF == false) {
			System.out.println("==검색할 데이터가 존재하지 않습니다.==");
		}
	}
	
	//3.삭제
	public void dataDelete() {
		scan1 = new Scanner(System.in);
		tOrF = false;
		System.out.println("==데이터 삭제를 시작합니다.==");
		System.out.println("삭제할 이름:");
		String delete = scan1.nextLine();
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.name.equals(delete)) {
				tOrF = true;
				phoneInfo.remove(info);
				System.out.println("==데이터 삭제가 완료되었습니다.==");
				break;
			}
		}
		if(tOrF == false) {
			System.out.println("==삭제할 데이터가 존재하지 않습니다.==");
		}
	}
	
	//4.주소록전체출력
	public void dataAllShow() {
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			info.showPhoneInfo();
		}
	}
}
