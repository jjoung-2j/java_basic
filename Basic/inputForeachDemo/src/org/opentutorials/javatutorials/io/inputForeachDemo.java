package org.opentutorials.javatutorials.io;

import java.util.Scanner;

public class inputForeachDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(i*1000);
		sc.close();
		
		/*
		for(String e : args) {
		System.out.println(e);
		}*/
	}
}
