import java.util.Scanner;

import ver09.PhoneInfo;
import ver09.PhoneBookManager;

public class PhoneBookVer09 {
	
	//생성자
	
	public static void main(String[] args) {
		PhoneBookManager pBM = new PhoneBookManager(100);
		Scanner scan = new Scanner(System.in);//메뉴받을 스캐너
		
		while(true) {
			pBM.printMenu();
			System.out.print("번호입력:");
			int userNum = scan.nextInt();

			switch(userNum) {
			case 1:
				pBM.dataInput(); break;
			case 2:
				pBM.dataSearch(); break;
			case 3:
				pBM.dataDelete(); break;
			case 4:
				pBM.dataAllShow(); break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("\n번호를 다시 확인하세요\n");
			}
		}
	}
}