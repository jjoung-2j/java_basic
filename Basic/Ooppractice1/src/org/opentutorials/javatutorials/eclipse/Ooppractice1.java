package org.opentutorials.javatutorials.eclipse;

class Calculator{
	int left, right; // 클래스 변수
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void sum() {
		System.out.println(this.left + this.right);
	}
	public void avg() {
		System.out.println((this.left + this.right) / 2);
	}
}
public class Ooppractice1 {
	public static void main (String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator();
		c2.setOprands(20, 40);
		c2.sum();
		c2.avg();
	}
	/*
	public static void sum(int left, int right) {
		System.out.println(left + right);
	public static void main(String[] args) {
		sum(10, 20);
		sum(20, 40);
	}
	*/
}
