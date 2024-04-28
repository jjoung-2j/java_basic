package Pack;
import java.util.Scanner;

public class SwitchEx1 {
	public static void main(String[] args) {
		// 사용자로부터 숫자를 입력 받아 해당 숫자의 월을 출력하는 프로그램
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("1부터 12까지 숫자를 입력하세요: ");
		int month = scanner.nextInt();
		
		String monthName;
		
		switch(month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		default:
			monthName = "Inbalid month";
		}
		
		System.out.println("입력한 숫자에 해당하는 월은 " + monthName + " 입니다");
		*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("년도를 입력하세요: ");
		int year = scanner.nextInt();
		
		System.out.println("월을 입력하세요(1부터 12까지): ");
		int month = scanner.nextInt();
		
		int dayInMonth;
		switch(month) {
		case 1,3,5,7,8,10,12:
			dayInMonth = 31;
			break;
		case 4,6,9,11:
			dayInMonth = 30;
			break;
		case 2:
			dayInMonth = (year%4==0&&(year%100!=0||year%400==0))?29:28;
			break;
		default:
			System.out.println("잘못된 월을 입력했습니다.");
			scanner.close();
			return;
		}
		System.out.println(year + "년 "+ month +"월은 " + dayInMonth + "일 까지 있습니다.");
		
		scanner.close();
	}
}
