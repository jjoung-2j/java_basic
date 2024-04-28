package org.opentutorials.javatutorials.Inheritance.example1;

class Calculator{
	int left, right;
	
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
/*
class SubstractionableCalculator extends Calculator{
	public void substract() {
		System.out.println(this.left - this.right);
	}
}
public class inherit1 {
	public static void main(String[] args) {
		SubstractionableCalculator c1 = new SubstractionableCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.substract();
	}
}

class MultiplicationableCalculator extends Calculator{
	public void multiplication() {
		System.out.println(this.left * this.right);
	}
}

public class inherit1{
	public static void main(String args[]) {
		MultiplicationableCalculator c1 = new MultiplicationableCalculator();
		//multiplicationableCalculator를 컴포넌트로 만들기
		c1.setOprands(10,20);
		// 클래스명.(변수 대입)
		c1.sum();
		// 클래스명.합
		c1.avg();
		//클리스명.평균
		c1.multiplication();
		//클래스명.multiplicationableCalculator
	}
}
*/
class DivisionableCalculator extends Calculator{
	public void division() {
		System.out.println(this.left / this.right);
	}
}
public class inherit1{
	public static void main(String args[]) {
		DivisionableCalculator c1 = new DivisionableCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.division();
	}
}

