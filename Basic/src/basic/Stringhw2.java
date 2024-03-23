package basic;
import java.util.Scanner;
// hw1228
public class Stringhw2 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("정수를 입력하세요: ");
	int intValue = scanner.nextInt();
	
	// 정수를 실수로 변환 (명시적 타입 캐스팅)
	double doubleValue = (double) intValue;
	
	System.out.println("입력된 정수: " + intValue);
	System.out.println("실수로 변환: " + doubleValue);
	
	scanner.close();
	}
}
