package Pack;
import java.util.Scanner;

public class IfEx1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요: ");
		int number = scanner.nextInt();
		
		// if 문을 사용해 숫자가 양수, 음수, or 0인지 판별
		if(number > 0) {
			System.out.println("입력한 숫자는 양수입니다.");
		}
		else if(number < 0) {
			System.out.println("입력한 숫자는 음수입니다.");
		}
		else {
			System.out.println("입력한 숫자는 0입니다.");
		}
		
		scanner.close();
	}
}
