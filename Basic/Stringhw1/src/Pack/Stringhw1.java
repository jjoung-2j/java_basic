package Pack;
import java.util.Scanner;
// hw1228
public class Stringhw1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열 개수를 입력하세요: ");
		int size = scanner.nextInt();
		
		// 입력된 개수만큼 문자열을 저장할 배열 선언
		String[] stringArray = new String[size];
		
		// 사용자로부터 문자열 입력 받아 배열에 저장
		for(int i = 0; i < size; i++) {
			System.out.print("문자열을 입력하세요: ");
			stringArray[i] = scanner.next();
		}
		
		// 배열에 저장된 문자열 출력
		System.out.println("\n입력된 문자열들: ");
		// a : b => a~b까지
		for(String str : stringArray) {
			System.out.println(str);
		}
		
		scanner.close();
	}
}
