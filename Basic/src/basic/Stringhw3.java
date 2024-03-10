package basic;
import java.util.Scanner;
// hw1228
public class Stringhw3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("0을 입력하면 루프가 종료된다.");
		
		while(true) {
			System.out.print("숫자를 입력하세요: ");
			int number = scanner.nextInt();
			
			if(number == 0) {
				System.out.println("입력이 종료됐다.");
				break; // 0 입력 -> 루프 종료
			}
			
			sum += number;
		}
		
		System.out.println("입력된 숫자 합: " + sum);
		
		scanner.close();
	}
}
