import java.util.Scanner;

import ver05.PhoneBookManager;
import ver05.MenuItem;

public class PhoneBookVer05 implements MenuItem{
	
	public static void main(String[] args) {
		PhoneBookManager pBM = new PhoneBookManager(100);
		Scanner scan = new Scanner(System.in);//메뉴받을 스캐너
		
		while(true) {
			pBM.printMenu();
			System.out.print("번호입력:");
			int userNum = scan.nextInt();

			switch(userNum) {
			case INPUT:
				pBM.dataInput(); break;
			case SEARCH:
				pBM.dataSearch(); break;
			case DELETE:
				pBM.dataDelete(); break;
			case SHOWALL:
				pBM.dataAllShow(); break;
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("\n번호를 다시 확인하세요\n");
			}
		}
	}
}