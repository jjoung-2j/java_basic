package basic;
// 오버로딩 Overloading -> Tiger
class Tiger{
	void method01() {
		System.out.println(1); // 1
	}
	void method01(int a) {
		System.out.println(2); // 2
	}
	void method01(int a, int b) {
		System.out.println(3); // 3
	}
	void method01(String a, int b) {
		System.out.println(4); // 4
	}
	int getArrayRECT(int w, int h) {
		return w*h; // w*h
	}
	int getArrayRECT(int length) {
		return length*length; // length * length
	}
}

public class Typecasting {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.method01(); 
		t1.method01(1); 
		t1.method01(1, 2); 
		t1.method01("호랑이", 1);
		System.out.println(t1.getArrayRECT(3,2)); // 6
		System.out.println(t1.getArrayRECT(3)); // 9
		
		/*
		int a = 100;
		String s1 = Integer.toString(a); // 문자열로 변환하고 싶을 때 toString 쓰기!
		System.out.println(s1+200); // 연산 x 100200
		String s2 =""+a; // sugar code
		System.out.println(s2+200); // 100200
		String s3 ="456";
		int b = Integer.parseInt(s3); // 숫자로 변환하고 싶을 때 parseInt 쓰기!
		System.out.println(b+1); // 연산 o 457
		*/
	}
}
/*
 * int intValue = 123456780; // 00000111 01011011 11001101 00001100
 * byte byteValue = (byte) intValue; // 00001100
 * 
 * System.out.println(intValue); // 123456780
 * System.out.println(byteValue); // 12
 */
