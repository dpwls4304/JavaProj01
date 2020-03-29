import java.util.InputMismatchException;
import java.util.Scanner;
import ver06.PhoneBookManager;
import ver06.MenuItem;
import ver06.MenuSelectException;


public class PhoneBookVer06 implements MenuItem{
	
	public static void main(String[] args) {
		PhoneBookManager pBM = new PhoneBookManager(100);
		
		while(true) {
			pBM.printMenu();
			int userNum=0;
			Scanner scan = new Scanner(System.in);
			try {
				userNum = scan.nextInt();
				if(userNum<1 || userNum>5) {
					MenuSelectException mSE = new MenuSelectException();
					throw mSE;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("==숫자만 입력하세요==");
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			
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
				System.out.println("==프로그램을 종료합니다.==");
				System.exit(0);
			}
		}
	}
}