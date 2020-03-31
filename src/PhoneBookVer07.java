import java.util.InputMismatchException;
import java.util.Scanner;
import ver07.PhoneBookManager;
import ver07.MenuItem;


public class PhoneBookVer07 implements MenuItem{
	
	public static void main(String[] args) {
		PhoneBookManager pBM = new PhoneBookManager(100);
		
		while(true) {
			pBM.printMenu();
			int userNum=0;
			Scanner scan = new Scanner(System.in);
			try {
				userNum = scan.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("==숫자가 아닙니다.==");
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