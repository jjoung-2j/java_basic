package Pack;

public class Memory1 {
	public static void main(String[] args) {
		/*
		System.out.println(3); // 숫자
		System.out.println('바'); // 문자 (싱글 쿼테이션)
		System.out.println("강아지"); // 문자열 (더블 쿼테이션)
		System.out.println("1000"); // 문자열 (더블 쿼테이션)
		
		System.out.println(3+7); // 숫자 + 숫자 (산술 연산)
		System.out.println(3+"강아지" ); // 숫자 + 문자열(문자열 연결 - 결과적으로 문자열로 취급)
		System.out.println("강아지"+3); // 문자열 + 숫자 (문자열 연결 - 결과적으로 문자열로 취급)
		System.out.println("강아지" + "토끼"); // 문자열 + 문자열(문자열 연결 - 결과적으로 문자열로 취급)
	
		System.out.println(3+"강아지"+7); // (숫자+문자열)+숫자=문자열+숫자=문자열
		System.out.println(3+7+"강아지"); // (숫자+숫자)+문자열=숫자+문자열=문자열
		System.out.println("강아지"+3+7); //(문자열+숫자)+숫자=문자열+숫자=문자열
		System.out.println(3+" "+7); // 숫자 두개를 한 라인에 출력하고 싶을 때 사용
		*/
		
		// 정수 메모리 할당(1, 2, 4, 8)byte - (byte, short, int, long)
		byte apple; // 1byte: " 컴퓨터야 1바이트 줘, 그 메모리를 apple로 할게
		apple = 100; // = 대입 연산 : 메모리에 숫자를 기억시키는 것
		System.out.println(apple); // Apple을 변수로, 변수명을 지칭해서 메모리에 값을 저장할 수 있는 것을 변수
		System.out.println(Byte.MIN_VALUE); // byte가 가질 수 있는 최솟값을 알려줌
		System.out.println(Byte.MAX_VALUE); // byte가 가질 수 있는 최댓값을 알려줌
	
		// short apple;
		short banana;
		banana = -30000;
		System.out.println(banana);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		int tomato;
		tomato = -2000000000;
		System.out.println(tomato);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		long melon;
		melon = 0;
		System.out.println(melon);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		boolean puppy; // true or false만 담는 것
		puppy = true;
		System.out.println(puppy);
		
		char cat; // 2byte, char는 유일하게 음수를 사용할 수 없음
		cat ='냥';
		System.out.println(cat);
		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
	
		float tiger; // 4byte
		tiger=3.14f; // 반드시 f를 넣어야 함
		System.out.println(tiger);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		
		double lion; // 8byte
		lion=3.14; // f가 없으니까 double을 가리킴
		System.out.println(lion);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
	}
}
