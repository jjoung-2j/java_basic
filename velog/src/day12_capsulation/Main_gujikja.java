package day12_capsulation;

import java.util.Scanner;

public class Main_gujikja {

	public static void main(String[] args) {
		Gujikja[] gu_arr = new Gujikja[5];
		
		Gujikja gu1 = new Gujikja();
		gu1.setUserid("eomjh");
		//gu1.setPasswd("qwer1234$");
		gu1.setName("엄정화");
		gu1.setJubun("8610201");
		gu_arr[Gujikja.count++] = gu1;
		
		Gujikja gu2 = new Gujikja();
		gu2.setUserid("leess");
		//gu2.setPasswd("abCd12345$");
		gu2.setName("이순신");
		gu2.setJubun("8601201");
		gu_arr[Gujikja.count++] = gu2;

		Scanner sc = new Scanner(System.in);
		Ctrl_gujikja ctrl = new Ctrl_gujikja();
		
		String str_menuno = "";
		do {
			ctrl.main_menu();	// 메인메뉴
			str_menuno = sc.nextLine();
			switch (str_menuno) {
			case "1":	// 구직자 회원가입
				ctrl.register(sc, gu_arr);
				break;
			case "2":	// 구직자 모두보기
				ctrl.view_all_info(gu_arr);
				break;
			case "3":	// 검색하기
				ctrl.search_menu(sc, gu_arr);
				break;
			case "4":
				break;
			default:
				System.out.println("[경고] 메뉴에 없는 번호입니다.\n");
				continue;
			}
		} while (!("4".equals(str_menuno)));
		
		sc.close();
		System.out.println("\n>>> 프로그램 종료 <<<");
	}

}
