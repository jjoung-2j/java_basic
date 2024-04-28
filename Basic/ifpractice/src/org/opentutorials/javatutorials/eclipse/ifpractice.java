package org.opentutorials.javatutorials.eclipse;

public class ifpractice {
	public static void main(String[] args) {
		String id = "juic"; // 입력 값
		String pw = "11111";
		if(id.equals("juice")) {
			if(pw.equals("111111")) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
		else {
			System.out.println("wrong");
		}
		
		int a = 10;
		int b = 20;
		if(a > b) {
			System.out.println("right");
		}
		else if(a != b) {
			System.out.println("true");
		}
		else {
			System.out.println("wrong");
		}
		
		int num = 3;
		
		switch(num) {
		case 1:
			System.out.println("숫자 1이다.");
			break;
		case 2:
			System.out.println("숫자 2이다.");
			break;
		case 3:
			System.out.println("숫자 3이다.");
			break;
			default:
				System.out.println("숫자 5이다");
		}
		/*
		if(!true) {
			System.out.println(1);
		}
		if(!false) {
			System.out.println(2);
		}
		*/
	}
}
