package ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem {
	HashSet<PhoneInfo> phoneInfo;
	int menuCount, saveCnt, grade;
	String major, company;
	boolean tOrF;
	Scanner scan1;
	Scanner scan2;
	
	//생성자
	public PhoneBookManager(int num) {
		phoneInfo = new HashSet<PhoneInfo>();
		menuCount = 1;
		saveCnt = 0;
		grade = 0;
		major = null;
		company = null;
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
		int subChoice = scan1.nextInt();
		
		//<입력시작>
		System.out.print("이름:");
		String name = scan2.nextLine();
		System.out.print("전화번호:");
		String phoneNumber = scan2.nextLine();
		if(subChoice == SCHOOL) {
			System.out.print("전공:");
			String major = scan2.nextLine();
			System.out.print("학년:");
			int grade = scan2.nextInt();
			phoneInfo.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
		}
		if(subChoice == COMPANY) {
			System.out.println("회사:");
			String company = scan2.nextLine();
			phoneInfo.add(new PhoneCompanyInfo(name, phoneNumber, company));
		}
		
		PhoneInfo info = new PhoneInfo(name, phoneNumber);
		if(phoneInfo.add(info) == false) {
			System.out.println("==아래 정보와 동일한 이름이 존재합니다. 덮어쓰기 하시겠습니까?==");
			Iterator<PhoneInfo> itr = phoneInfo.iterator();
			PhoneInfo pI = itr.next();
			if(name.equals(pI.getName())) {
				System.out.println("========================");
				pI.showPhoneInfo();
				System.out.println("========================");
			}
			System.out.print("[1]예, [2]아니오>>");
			int userCh = scan1.nextInt();
			
			if(userCh == 1) {
				if(subChoice == BASIC) {
					phoneInfo.remove(info);
					phoneInfo.add(info);
				}
				if(subChoice == SCHOOL) {
					phoneInfo.remove(info);
					phoneInfo.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				}
				if(subChoice == COMPANY) {
					phoneInfo.remove(info);
					phoneInfo.add(new PhoneCompanyInfo(name, phoneNumber, company));
				}
			}
			else {
				
			}
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
			if(info.getName().equals(searching)) {
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
			if(info.getName().equals(delete)) {
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
