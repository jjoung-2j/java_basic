package org.opentutorials.javatutorials.eclipse;

public class Operator {
	public static void main(String[] args) {
		int result = 1 + 2; //3
		System.out.println(result);
		
		result = result - 1; //2, 3
		System.out.println(result); //2
		
		result = result * 2; //4, 2
		System.out.println(result); //4
		
		result = result / 2; //2, 4
		System.out.println(result); //2
		
		result = result + 8; //10, 2
		result = result % 7;
		System.out.println(result);
		
		
		int a = 10;
		int b = 5;
		
		float c = 10.0F;
		float d = 5.0F;
		
		System.out.println(a/b);
		System.out.println(c/d);
		System.out.println(a/d);
		
		
		int i = 3;
		i++; //4 i = i + 1
		System.out.println(i); //4
		++i; // i + 1 = i
		System.out.println(i); //5
		System.out.println(++i); //6 ++i는 바로 적용
		System.out.println(i++); //6 i++는 그 다음 적용
		System.out.println(i); //7
		/*
		String a = "Hello java";
		String b = new String("Hello java");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		*/
	}
}
