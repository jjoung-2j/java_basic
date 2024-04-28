package Pack;
import java.util.Scanner;

public class LoopEx1 {
	public static void main (String[] args) {
		/*
		 // 1부터 5까지 숫자를 출력하는 for문
		 
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		// 중첩된 for문을 사용 -> 별(*)을 이용해 삼각형 출력하는 프로그램
		int numberOfRows = 5;
		
		// 삼각형을 출력하는 중첩된 for문
		for(int i = 1; i <= numberOfRows; i++) {
			
			//공백 출력 (오른쪽 정렬을 위해)
			for(int j = 1; j <= numberOfRows - i; j++) {
				System.out.print(" ");
			}
			
			// 별 출력
			for(int k = 1; k <= i*2 - 1; k++) {
				System.out.print("*");
			}
			
			// 행 변경
			System.out.println();
		}
		
		
		int i = 1;
		
		// while문을 사용해서 1부터 5까지 출력
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
		
		
		// 사용자로부터 입력받은 숫자까지의 소수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력하세요: ");
		int limit = scanner.nextInt();
		
		System.out.println(limit + "까지의 소수: ");
		
		int number = 2; // 2부터 시작하는 정수
		while(number <= limit) {
			if(isPrime(number)) {
				System.out.print(number + " ");
			}
			number++;
		}
		
		scanner.close();
	}
	
	// 주어진 숫자가 소수인지 확인하는 메서드
	private static boolean isPrime(int num) {
		if(num < 2) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
		*/
		/*
		Scanner scanner = new Scanner(System.in);
		
		// 프로그램 반복 실행
		while(true) {
			System.out.print("원하는 연산을 선택하세요 (0~4): ");
			
			System.out.println("사칙연산을 선택하세요: ");
			System.out.println("1. 덧셈");
			System.out.println("2. 뺄셈");
			System.out.println("3. 곱셈");
			System.out.println("4. 나눗셈");
			System.out.println("0. 종료");
			
			int choice = scanner.nextInt();
			
			if(choice == 0) {
				System.out.println("프로그램 종료");
				break; // 0을 선택하면 프로그램 종료
			}
			
			System.out.print("첫 번째 숫자를 입력하세요: ");
			double num1 = scanner.nextDouble();
			System.out.print("두 번째 숫자를 입력하세요: ");
			double num2 = scanner.nextDouble();
			
			// 선택된 연산 수행
			
			double result = 0;
			switch(choice) {
			case 1:
				result = num1 + num2;
				break;
			case 2:
				result = num1 - num2;
				break;
			case 3:
				result = num1 * num2;
				break;
			case 4:
				if(num2 != 0) {
					result = num1 / num2;
					}
				else {
					System.out.println("0으로 나눌 수 없습니다.");
				continue; // 0으로 나누면 다시 반복
				}
				break;
				default:
					System.out.println("잘못된 선택입니다.");
					continue; // 잘못된 선택이면 다시 반복
			}
			
			// 연산 결과 출력
			System.out.println("연산 결과: " + result);
			
		}
		
		scanner.close();
		*/
		
		/*
		// for문으로 팩토리얼 계산하기
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력하세요: ");
		int number = scanner.nextInt();
		
		// 입력된 숫자의 팩토리얼 계산
		long factorial = 1;
		for(int i =1; i<= number; i++) {
			factorial *= i;
		}
		
		System.out.println(number + "의 팩토리얼: " + factorial);
		
		scanner.close();
		*/
		
		/*
		// 피보나치 수열 출력하는 예제
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("피보나치 수열의 길이를 입력하세요: ");
		int length = scanner.nextInt();
		
		System.out.println("피보나치 수열: ");
		
		int first = 0, second = 1;
		
		// 입력된 길이만큼의 피보나치 수열 출력
		for(int i = 0; i < length; i++) {
			System.out.print(first + " ");
			
			int next = first + second;
			first = second;
			second = next;
		}
		
		scanner.close();
		*/
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삼각형 크기 입력 : ");
		int size = scanner.nextInt();
		
		for(int i = 1; i <= size; i++) { // 행
			for(int j = 1; j <= i; j++) { // 별의 개수
				System.out.print("* ");
			}
			System.out.println();
		}
		
		scanner.close();
	}
	
		
}
