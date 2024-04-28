package org.opentutorials.javatutorials.eclipse;

public class ReturnDemo {
	/*public static String num(int i) {
		if(i == 0) {
			return " zero";
		} else if (i == 1) {
			return "one";
		} else if (i == 2) {
			return "two";
		}
		return "none";
	}
	
	public static void main (String[] args) {
		System.out.println(num(1));
	}
}*/
	public static String[] getMembers() {
		String[] members = {"지은", "혜정", "??"};
		return members;
	}
	
	public static void main(String [] args) {
		String[] members = getMembers();
		for (String member : members) {
			System.out.println(member);
		}
	}
}