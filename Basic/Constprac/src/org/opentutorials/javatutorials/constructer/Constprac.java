package org.opentutorials.javatutorials.constructer;

class Calculator{
	int left,right;
	
	public Calculator(int left, int right) { //생성자(construct)
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

public class Constprac {
	public static void main(String[] args) {
		Calculator c1 = new Calculator(10, 20); // 클래스가 아닌 생성자
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator(20, 40);
		c2.sum();
		c2.avg();
	}
}
