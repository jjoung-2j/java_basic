package org.opentutorials.javatutorials.object;

class C1{
	static int static_variable = 1; // 클래스 변수 선언
	int instance_variable = 2; // 인스턴스 변수 선언
	
	static void static_static() {
		System.out.println(static_variable);	
	}
	
	static void static_instance() {
		// 정적메소드는 인스턴스 변수에 접근할 수 없음
		// System.out.println(instance_variable);
	}
	
	void instance_static() {
		// 인스턴스 메소드에서는 클래스 변수에 접근할 수 있음
		System.out.println(static_variable);
	}
	void instance_instance() {
		System.out.println(instance_variable);
	}
}

public class Oophw1 {
	public static void main(String[] args) {
		C1 c = new C1(); //c라는 이름의 인스턴스 생성
		c.static_static(); // 1
		// c.static_instance();
		c.instance_static(); // 1
		c.instance_instance(); //2
		
		C1.static_static();
		C1.static_instance();
	}
}
