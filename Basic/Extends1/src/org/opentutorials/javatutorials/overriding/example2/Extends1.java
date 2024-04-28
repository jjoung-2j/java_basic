package org.opentutorials.javatutorials.overriding.example2;
/*
class Parent{
	int a = 10;
}

class Child extends Parent{
	int a = 20;
	
	void display() {
		System.out.println(a);
		System.out.println(this.a); // 내안에 있는 20
		System.out.println(super.a); // 자신이 상속받은 부모 10
	}
}

public class Extends1 {
	public static void main(String args[]) {
		Child ch = new Child();
		ch.display();
	}
}
*/
/*
// 컴파일러가 항상 super()를 자동 추가해주는 것은 아닌 경우
class Parent{
	int a;
	Parent(int n){a = n;};
}
	
class Child extends Parent() {
	int b;
	Child(){
		super()
		b = 20;
	}
}
*/
/*
//1번째 해결방법
// 명시된 문제 그대로의 해결: 부모 클래스에 기본 생성자 선언
class Parent{
	int a;
	Parent(){a = 10;}; // 부모 클래스에 기본 생성자 선언
	Parent(int n){a=n;};
}

class Child extends Parent{
	int b;
	Child(){
		super();
		b = 20;
	}
}
*/
// 2번째 해결방법
// 합리적 해결 : 오버로딩된 생성자에 맞춰 super()의 인자를 맞춰준다.
class Parent{
	int a;
	Parent(int n){a = n;};
}

class Child extends Parent{
	int b;
	Child(){
		super(40);
		b = 20;
	}
}