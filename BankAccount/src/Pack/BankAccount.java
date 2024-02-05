package Pack;

public class BankAccount {

		// 은행 계좌의 소유주 이름과 잔액을 멤버 변수로 가지며
		// 생성자를 통해 초기 소유주 이름과 초기 잔액을 설정하는 BankAccount 클래스를 만들어주세요.
		// BankAccount 클래스는 입금(deposit), 출금(withdraw), 잔액 조회(checkBalance) 메서드를 포함하게 만들어주세요.
		// 입금 메서드는 입금을, 출금 메서드는 출금을, 잔액 조회 메서드는 현재 잔액을 출력합니다.
		// Main 클래스에서 BankAccount 객체를 생성하고, 입금과 출금, 잔액 조회를 수행해주세요.

		// field
		private String name;
		private int balance;

		// 생성자
		public BankAccount(String name, int balance) {
			this.name = name;
			this.balance = balance;
		}
		
		// method
		// === 입금 === //
		public void deposit(int deposit_num) {
			if(deposit_num > 0) {
				balance += deposit_num;		// (기존)잔액 + 입금할 잔액 = (새로운)잔액
				System.out.println("\n" + deposit_num + "원이 입금되었습니다.\n현재잔액 => " + balance + "원\n");
			} else {	// 0 이하일 경우
				System.out.println("0원 이상이어야 입금이 가능합니다.\n");
			}	// end of if~else
		}	// end of public void deposit(int deposit_num)--------------

		// === 출금 === //
		public void withdraw(int withdraw_num) {
			if(withdraw_num > 0) {	
				if(balance >= withdraw_num)	{	// 현재잔액이 출금할 잔액보다 많은 경우
					balance -= withdraw_num;		// (기존)잔액 - 출금할 잔액 = (새로운)잔액
					System.out.println("\n" + withdraw_num + "원이 출금되었습니다.\n"
							+ "현재잔액 => " + balance + "원\n");
				} else
					System.out.println("\n =>현재잔액은 " + balance + "원입니다.\n"
							+ withdraw_num + "원을 출금하실 수 없습니다.\n");
			} else {	// 0 이하일 경우
				System.out.println("0원 이상이어야 출금이 가능합니다.\n");
			}	// end of if~else
		}	// end of public void withdraw(int withdraw_num)-----------

		// === 잔액조회 === //
		public void checkBalance() {
			System.out.println("=> " + name + " 님의 잔액은 " + balance + "원 입니다.\n");
		}	// end of public void checkBalance()-----------

}
