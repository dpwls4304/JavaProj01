package ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem {
	//1개 이상의 지역에서 사용할 변수 및 객체
	HashSet<PhoneInfo> save;
	Iterator<PhoneInfo> itr;
	int menuCount, showCount;
	boolean tOrF;
	Scanner scan;
	
	public PhoneBookManager() {
		save = new HashSet<PhoneInfo>();
		menuCount = 0; //메뉴 공백을 위한 카운트
		showCount = 0; //전체출력 갯수 형식을 위한 카운트
	}
	
	//메뉴출력
	public void printMenu() {
		if(menuCount>0)
			System.out.println();
		System.out.println("[메뉴선택]");
		System.out.println("[1]데이터 입력");
		System.out.println("[2]데이터 검색");
		System.out.println("[3]데이터 삭제");
		System.out.println("[4]주소록 출력");
		System.out.println("[5]프로그램 종료");
		System.out.print("번호입력:");
		menuCount=1;
	}
	
	//1.입력
	public void dataInput() {
		PhoneInfo pI = null;//입력정보 담을 변수
		scan = new Scanner(System.in);
		System.out.println("==데이터 입력을 시작합니다.==");
		System.out.println("[1]일반, [2]동창, [3]회사");
		System.out.print("선택>>");
		int subChoice = scan.nextInt();
		scan.nextLine();//버퍼날림
		
		//공통사항 이름, 전화번호
		System.out.print("이름:");
		String name = scan.nextLine();
		System.out.print("전화번호:");
		String phoneNumber = scan.nextLine();
		
		//서브메뉴 선택에 따라 추가입력 및 DTO 생성자 호출
		if(subChoice == BASIC) {
			pI = new PhoneInfo(name, phoneNumber);
		}
		else if(subChoice == SCHOOL) {
			System.out.print("전공:");
			String major = scan.nextLine();
			System.out.print("학년:");
			int grade = scan.nextInt();
			scan.nextLine();//버퍼날림
			pI = new PhoneSchoolInfo(name, phoneNumber, major, grade);
		}
		else if(subChoice == COMPANY) {
			System.out.print("회사:");
			String company = scan.nextLine();
			pI = new PhoneCompanyInfo(name, phoneNumber, company);
		}
		if(save.add(pI) == false) {
			System.out.println("==아래 정보와 이름이 동일합니다.");
			System.out.println("덮어쓰기 하시겠습니까?==");
			//==================중복객체(기존) 보여주는 용도==================
			itr = save.iterator();
			while(itr.hasNext()) {
				PhoneInfo show = itr.next();
				if(show.getName().equals(name)) {
					System.out.println("========================");
					show.showPhoneInfo();
					System.out.println("========================");
					}
				}
			//===================================================
			System.out.print("[1]예, [2]아니오>>");
			int tOrFCh = scan.nextInt();
			scan.nextLine();//버퍼날림
			if(tOrFCh == 1) {
				save.remove(pI);
				save.add(pI);
				System.out.println("==덮어쓰기가 완료되었습니다.==");
			}
			else {
				return;
			}
		}
	}
	
	//2.검색
	public void dataSearch() {
		tOrF = false;
		scan = new Scanner(System.in);
		System.out.println("==데이터 검색을 시작합니다.==");
		System.out.print("검색할 이름:");
		String searching = scan.nextLine();
		itr = save.iterator();
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.getName().equals(searching)) {
				tOrF = true;
				System.out.println("========================");
				info.showPhoneInfo();
				System.out.println("==데이터 검색이 완료되었습니다.==");
				break;
			}
		}
		if(tOrF == false) {
			System.out.println("==검색할 데이터가 존재하지 않습니다.==");
		}
	}
	
	//3.삭제
	public void dataDelete() {
		tOrF = false;
		scan = new Scanner(System.in);
		System.out.println("==데이터 삭제를 시작합니다.==");
		System.out.print("삭제할 이름:");
		String delete = scan.nextLine();
		itr = save.iterator();
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.getName().equals(delete)) {
				tOrF = true;
				System.out.println("========================");
				info.showPhoneInfo();
				save.remove(info);
				System.out.println("==상기의 데이터가 삭제되었습니다.==");
				break;
			}
		}
		if(tOrF == false) {
			System.out.println("==삭제할 데이터가 존재하지 않습니다.==");
		}
	}
	
	//4.주소록전체출력
	public void dataAllShow() {
		dataLoad();
		tOrF = false;
		itr = save.iterator();
		while(itr.hasNext()) {
			tOrF = true;
			if(showCount==0) {
				System.out.println("==" + save.size() + "개의 데이터를 출력합니다.==");
			}
			else if(showCount>0) {
				System.out.println("========================");
			}
			PhoneInfo info = itr.next();
			info.showPhoneInfo();
			showCount=1;
		}
		if(tOrF == true) {
			System.out.println("==데이터 출력이 완료되었습니다.==");
		}
		if(tOrF == false) {
			System.out.println("==출력할 데이터가 존재하지 않습니다.==");
		}
	}
	
	
	
	
	
	
	
	public void dataSave() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj"));
			out.writeObject(save);
			out.writeObject(null);
			System.out.println("==" +save.size() + "개의 데이터가 저장되었습니다.==");
			out.close();
		}
		catch(Exception e) {
			System.out.println("인출과정에서 오류 발생");
			e.printStackTrace();
		}
	}
	
	public void dataLoad() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("src/ver08/PhoneBook.obj"));
			save = (HashSet<PhoneInfo>)in.readObject();
			this.save = save;
//			itr = save.iterator();
//			while(itr.hasNext()) {
//				itr.next().showPhoneInfo();
//				}
			in.close();
		}
		catch(Exception e) {
			System.out.println("불러오는 과정에서 오류 발생");
			e.printStackTrace();
		}
	}
	
}//end of class
