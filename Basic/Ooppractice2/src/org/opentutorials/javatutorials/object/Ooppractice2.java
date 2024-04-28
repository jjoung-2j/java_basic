package org.opentutorials.javatutorials.object;

public class Ooppractice2 {
	/*
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	public static void main(String[] args) {
		sum(10, 20);
		sum(20, 40);
	}
	*/
	
	public static void avg(int left, int right) {
		System.out.println((left + right) / 2);
	}
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	public static void main(String[] args) {
		int left, right;
		
		left = 10;
		right = 20; // 명시화
		
		sum(left, right);
		avg(left, right);
		
		left = 20;
		right = 40;
		
		sum(left, right);
		avg(left, right);
		
	}
	// Ooppracice1으로 가기
}
