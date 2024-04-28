package org.opentutorials.javatutorials.eclipse;

public class LoopPrac {
	public static void main(String[] args) {
		int i = 0;
		// i의 값이 10보다 작으면 true, 크다면 false
		while (i < 10) {
			System.out.println("Coding Everybody" + i);
			i++; // i = i+1;
		/*	
		for(int i = 0; i < 10; i++) {
			if(i1 == 5)
				continue;
			System.out.println("Coding Everybody" + i);
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j< 10; j++) {
				System.out.println(i + ""+ j);		
		}
		*/
		String[] classGroup = new String[4];
		classGroup[0] = "지은";
		System.out.println(classGroup.length);
		classGroup[1] = "혜정";
		System.out.println(classGroup.length);
		classGroup[2] = "저녁식사";
		System.out.println(classGroup.length);
		classGroup[3] = "맛있게드세요";
		System.out.println(classGroup.length);
		
		String[] members = {"000","111","222"};
		for (String e : members){
			System.out.println(e + "이 상담을 받았습니다.");
			/*
			System.out.println(members[3]); //예외
			
			String[] members = new String[3];
			members[0] = "000";
			members[1] = "111";
			members[2] = "222";
			members[3] = "333"; //예외
			*/
		}
		}
	}
}

