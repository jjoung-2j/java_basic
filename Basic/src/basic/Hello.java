package basic;

public class Hello {
	public static void main(String[] args) {
		/* 산술 연산자 (+, -, *, /, %)
		System.out.println(20 + 3);
		System.out.println(20 - 3);
		System.out.println(20 * 3);
		System.out.println(20 / 3);
		System.out.println(20 % 3);
		
		// 우선순위
		System.out.println(3+2*4);
		System.out.println((3+2)*4);
		
		
		// 관계 or 비교 연산
		System.out.println(5>3);
		System.out.println(5<3);
		System.out.println(5>=3);
		System.out.println(5<=3);
		System.out.println(5==3);
		System.out.println(5!=3);
		
		
		// 논리 연산자 (논리 and, 논리 or, 부정 연산자) - 총 4가지
		// OR : 논리 합 - 하나라도 참이면 참
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		
		// AND : 논리 곱 - 전부 참이어야 함
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(false && false);
		System.out.println(true && true);
		
		// 연습
		System.out.println(true && true && false);
		System.out.println(false || false || true);
		
		// 잘못된 코드 - 혼용 사용 시 주의
		// System.out.println(true&&true||false)
		// 올바른 코드
		System.out.println((true && true) || false);
		System.out.println(3>2 || false || 6<=3);
		
		// NOT : 논리 부정. 부정 연산자 - 그 결과에 대해서 부정
		System.out.println(!true);
		System.out.println(!(3>2));
		
		// XOR : 배타적 논리합.
		System.out.println(true ^ true);
		System.out.println(false ^ false);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		*/
		
		/*
		int a = 10; // int: 데이터 타입, a: 변수, =: 대입 연산자, 10: 정수 리터럴
		int b = 20;
		short c = 30;
		// 원칙을 어긴 예시 : b = c;
		
		// type casting : 강제 타입 변환
		b = (int)c; // 강제로 타입을 지시함 : type casting
		c = (short)a;
		
		int num = 10;
		num = num + 3;
		num += 3; // 복합 대입 연산자 num = num + 3;과 동일
		
		int a1 = 0, a2 = 0;
		a1 = a2 + 3; // 복합 대입 연산자와 아무 관련 없다!
		
		// 주의!
		int t = +1; // 단항 연산자, 구태역 연산자로 양수값을 가리킴
		int u = -1; // 이럴 때 구태역 연산자를 사용(의도적 자리 맞춤을 위해 양수도 구태역 연산자 사용)
		int k = 10;
		k+=3; // 복합 연산
		System.out.println(k);	// k = 13
		k=+3; // 대입 연산
		System.out.println(k); // k = 3
		
		int d = 0;
		d++;
		System.out.println(d); //1
		System.out.println(d); //1
		++d;
		System.out.println(d); //2
		System.out.println(d); //2
		d = d + 1; // 실행 속도가 느림
		System.out.println(d); //3
		d+=1; 
		System.out.println(d); //4
		*/
		
		int a = 10, b;
		b = a++; // 순서: 대입 ->  증가
		System.out.println(a+" "+b);
		
		int c = 10, d = 0;
		d = ++c; //순서: 증가 -> 대입
		System.out.println(d+" "+c);
		
		int a1 = 10, a2 = 10;
		System.out.println(a1++);
		System.out.println(++a2);
		System.out.println(a1);
		System.out.println(a2);
	}
}