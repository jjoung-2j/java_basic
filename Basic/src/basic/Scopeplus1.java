package basic;
/*
public class Scopeplus1 {
	static int i =5;

	static void a() {
		int i = 10;
		b();
	}

	static void b() {
		System.out.println(i);
	}
	/*
	static int i; //전역변수

	static void a() {
		i = 0; //지역변수
	}
 */
/*
	static void a() {
		String title = "coding everybody";
	}
 */
/*
	public static void main(String[] args) {
		/*
		for(int i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
 */
/*
		a();
		// System.out.prtinln(title);
 */
/*
		for(int i= 0; i < 5; i++) {
			System.out.println(i);

	a();	
	}
}
 */

class C3{
	int v = 10; // 전역변수

	void m() {
		int v =20; // 지역변수 -> 지역변수>전역변수
		System.out.println(this.v); //this 는 인스턴스 자신
	}
}

public class Scopeplus1{
	public static void main(String[] args) {
		C3 c1 = new C3();
		c1.m();
	}
}

