package Pack;

import java.util.Scanner;

public class BankAccount_main {

	public static void main(String[] args) {
		// BankAccount 클래스는 입금(deposit), 출금(withdraw), 잔액 조회(checkBalance) 메서드를 포함하게 만들어주세요.
		// Main 클래스에서 BankAccount 객체를 생성하고, 입금과 출금, 잔액 조회를 수행해주세요.
		// 계좌 소유주, 초기잔액 입력
		
		Scanner sc = new Scanner(System.in);

		boolean answer = true;
		String name = "";	// 초기화
		
		do {
			answer = true;		// 틀리고 반복될 경우 true 로 시작해야 되기 때문
			System.out.print("계좌 소유주 : ");
			name = sc.nextLine();
			
			if(name == null || name.isBlank()) {
				answer = false;
				System.out.println("[경고] 공백이 아닌 이름을 입력해주세요.");
			}
		}while(!answer);	// end of do~while-----------
		
		int balance = 0;	// 초기화
		do {
			answer = true;		// 틀리고 반복될 경우 true 로 시작해야 되기 때문
			System.out.print("초기 잔액 : ");
			try {
				balance = Integer.parseInt(sc.nextLine());
				if(balance <= 0) {
					answer = false;
					System.out.println("[경고] 초기잔액은 0원 이상이어야 합니다.");
				} else
					answer = true;
			} catch(NumberFormatException e) {
				answer = false;
				System.out.println("[경고] 숫자만 입력해주세요.");
			}	// end of try~catch------------
		} while(!answer);
		
		// === BankAccount 객체 생성 === //
		BankAccount bank_account = new BankAccount(name, balance);
		// BankAccount 클래스에 있는 객체 사용하기 -> 호출 bank_account
			
		String input_num;
		do {	
			// === 입금, 출금, 잔액 조회 선택하기 === //
			System.out.println("=== " + name + "님의 은행 메뉴얼 ===\n"
					+ "1. 입금 2. 출금 3. 잔액 조회 4. 프로그램 종료");
			System.out.print("진행할 메뉴번호 => ");
			input_num = sc.nextLine();
			try {
				switch (input_num) {
				case "1":	// 입금
					System.out.print("입금 금액 => ");
					int deposit_num = Integer.parseInt(sc.nextLine());
					bank_account.deposit(deposit_num);
					break;
				case "2":	// 출금
					System.out.print("출금 금액 => ");
					int withdraw_num = Integer.parseInt(sc.nextLine());
					bank_account.withdraw(withdraw_num);
					break;
				case "3":	// 잔액 조회
					bank_account.checkBalance();
					break;
				case "4":	// 프로그램 종료
					System.out.println("프로그램을 종료합니다.\n");
					sc.close();
					break;
				default:	// 메뉴에 없는 번호
					System.out.println("[경고] 메뉴에 없는 번호입니다.\n");
					break;
				}	// end of switch---------
			} catch(NumberFormatException e) {
				System.out.println("[경고] 숫자만 입력해주세요.\n");
			}	// end of try~catch-------------
		} while (!("4".equals(input_num)));	// end of do~while------------------
	}	// end of public static void main(String[] args)--------------

}
