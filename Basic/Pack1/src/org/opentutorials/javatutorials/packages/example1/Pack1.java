package org.opentutorials.javatutorials.packages.example1;

// 패키지: 비슷한 성격의 클래스들을 모아 놓은 자바의 디렉터리
// import : 해당 패키지에서 다른 패키지 내의 클래스를 사용하고 싶을 때
// package.* : 패키지 내의 모든 클래스를 사용할 수 있다.
// package.원하는class: 원하는 클래스만 사용할 수 있다.
// 사용 이유 : 클래스 분류 용이, 패키지가 다르면 동일 클래스명을 사용할 수 있음
// src: 사람이 이해할 수 있는 코드가 들어 있음
// bin: 가성 머신이 이해할 수 있는 코드가 들어 있음
// javac 주소 -d 원하는 폴더

public class Pack1 {
	public static void main(String[] args) {
		Pack1 a = new Pack1();
	}
}
