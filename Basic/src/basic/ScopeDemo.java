package basic;

class C{
	int v = 10; // 전역변수
	
	void m() {
		int v = 20; // 지역변수
		System.out.println(v);
		System.out.println(this.v); // this: 인스턴스 자신
	}
}

public class ScopeDemo {
	public static void main(String[] args) {
		C c1 = new C();
		c1.m();
	}
	/*static int i; //전역 변수
	 static String title; // 전역변수 지정
	
	static void a() {
		/*int i = 0; // 전역 변수로 선언되있으면 i = 0
		//	i = 0; // 지역 변수 

		String title = "coding everybody";
		// -> 클래스 a 안 지역변수, 지역변수 title
}

	static int i = 5; // 전역 변수 선언
	
	static void a() {
		int i = 10;
		b();
	}
	
	static void b() {
		int i = 30;
		System.out.println(i);
	}


	public static void main(String[] args) {
		a();
		/*int i;
		
		for(i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
			System.out.println(i);
		
		/*for(i = 0; i < 5; i++) {
			System.out.println(i);
		}*/ // 무한 루프
	/*	String title = "coding everybody";
		// String title = "0"; // 지역변수 coding everybody 값이 아닌 0 이 선언
		a();
		System.out.println(title);
	}
	}*/
	
}

	
	
