package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MethodDemo1 {
	public static String numbering(int init, int limit) {
		int i = init;
		String output = "";
		while(i < limit) {
			output += i; //output = output + i
						//(왼) += (오) => (왼)+(오)
			i++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		String result = numbering(1, 5);
		System.out.println(result);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
			out.write(result);
			out.close();
		} catch(IOException e) {
			
		}
		}
}

