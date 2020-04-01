import java.util.InputMismatchException;
import java.util.Scanner;
import ver08.MenuItem;
import ver08.PhoneBookManager;


public class PhoneBookVer08 implements MenuItem{
	
	public static void main(String[] args) {
		PhoneBookManager pBM = new PhoneBookManager();
		
		while(true) {
			pBM.printMenu();
			int Menuchoice=0;
			Scanner scan = new Scanner(System.in);
			try {
				Menuchoice = scan.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("==숫자가 아닙니다.==");
			}
			
			switch(Menuchoice) {
			case INPUT:
				pBM.dataInput(); break;
			case SEARCH:
				pBM.dataSearch();break;
			case DELETE:
				pBM.dataDelete(); break;
			case SHOWALL:
				pBM.dataAllShow(); break;
			case EXIT:
				System.out.println("==프로그램을 종료합니다.==");
				pBM.dataSave();
				System.exit(0);
			}
		}
	}
}