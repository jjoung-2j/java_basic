package org.opentutorials.javatutorials.Inheritance.example2;

class Calculator{
	int left,right;
	
	//기본 생성자 생성
	// public Calculator() {}
	
	public Calculator(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right)/2);
	}
}
class SubstractionableCalculator extends Calculator{
	public SubstractionableCalculator(int left, int right) {
		super(left,right);
		// this.left = left;
		// this.right = right;
	}
	public void substract() {
		System.out.println(this.left - this.right);
	}
}

public class ConstructorDemo {
	public static void main(String[] args) {
		SubstractionableCalculator c1 = new SubstractionableCalculator(10,20);
		c1.sum();
		c1.avg();
		c1.substract();
	}
	/*
	public static void main(String[] args) {
		ConstructorDemo c = new ConstructorDemo();
	}*/
	/*
	public ConstructorDemo() {}
	public ConstructorDemo(int param1) {
	}
	public static void main(String[] args) {
			ConstructorDemo c= new ConstructorDemo();
	}
	//에러 뜨는 경우
	 */
}
