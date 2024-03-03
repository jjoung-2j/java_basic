package my.day13_14.a.inheritance;

import java.util.Scanner;

public class Main_gujikja_company {

	public static void main(String[] args) {
		
		Gujikja[] gu_arr = new Gujikja[5];
		
		///////////////////////////////////////////////////////////
		Gujikja gu1 = new Gujikja();
		gu1.setId("eomjh");		// 생성되어진 인스턴시 gu1 에 메소드를 통해 아이디 입력
										// 메소드를 통하지 않을시 String 타입이면 무조건 OK 되기 때문에 설정한 값에 만족하지 않더라도 출력이 된다.
	    gu1.setPasswd("qWer1234$");
	    gu1.setName("엄정화");
	    gu1.setJubun("8610202");
		gu_arr[Gujikja.count++] = gu1;		// 구직자 클래스에 가서 static count 선언하기
	    
	    Gujikja gu2 = new Gujikja();
	    gu2.setId("leess");
	    gu2.setPasswd("abCd12345$");
	    gu2.setName("이순신");
	    gu2.setJubun("8601201");
	    gu_arr[Gujikja.count++] = gu2;
	    
	    Gujikja gu3 = new Gujikja();
	    gu3.setId("chaew");
	    gu3.setPasswd("aSdf1234$");
	    gu3.setName("차은우");
	    gu3.setJubun("0106203");
	    gu_arr[Gujikja.count++] = gu3;		// 3명으로 나옴, 3명이 저장되어있다!
	    
	    ////////////////////////////////////////////////////////////////////////
	    
	    Company[] cp_arr = new Company[3];
	    
	    Company cp1 = new Company();
	    cp1.setId("samsung");
	    cp1.setPasswd("Abcd1234$");
	    cp1.setName("삼성");
	    cp1.setBusiness_number("8123456789");
	    cp1.setJob_type("제조업");
	    cp1.setSeed_money(8000000000L);
	    cp_arr[Company.count++] = cp1;
	    
	    Company cp2 = new Company();
	    cp2.setId("lg");
	    cp2.setPasswd("Abcd007$");
	    cp2.setName("엘지");
	    cp2.setBusiness_number("7123456789");
	    cp2.setJob_type("IT");
	    cp2.setSeed_money(7000000000L);
	    
	    cp_arr[Company.count++] = cp2;

	    ///////////////////////////////////////////////////////////////////////
	    
	    Recruit[] rc_arr = new Recruit[10];		// 사원모집 10개 가능하도록 설정
	    										// 지금은 배열, 나중에는 무한대 ㄱㄱ
	    Recruit rc1 = new Recruit();
	    rc1.setCp(cp1);								// 삼성이라고 설정
	    rc1.setSubject("성실한 사무직원을 채용합니다.");	// 채용제목
	    rc1.setWork_type("사무직");					// 채용분야(근무형태)
	    rc1.setCnt(2);								// 인원
	    rc1.setYearpay(4000);						// 연봉
	    rc1.setFinish_day("20241208");				// 마감일자
	    rc_arr[Recruit.count++] = rc1;
	    
	    Recruit rc2 = new Recruit();
	    rc2.setCp(cp2);								// 엘지라고 설정
	    rc2.setSubject("우수한 기술직원을 채용합니다.");	// 채용제목
	    rc2.setWork_type("기술직");					// 채용분야(근무형태)
	    rc2.setCnt(5);								// 인원
	    rc2.setYearpay(4500);						// 연봉
	    rc2.setFinish_day("20241207");				// 마감일자
	    rc_arr[Recruit.count++] = rc2;
	    
	    Recruit rc3 = new Recruit();
	    rc3.setCp(cp2);								// 엘지라고 설정
	    rc3.setSubject("참신한 영업직원을 채용합니다.");	// 채용제목
	    rc3.setWork_type("영업직");					// 채용분야(근무형태)
	    rc3.setCnt(10);								// 인원
	    rc3.setYearpay(5000);						// 연봉
	    rc3.setFinish_day("20241202");				// 마감일자
	    rc_arr[Recruit.count++] = rc3;
	    
	    ////////////////////////////////////////////////////////////////////////
	    
	    RecruitApply[] rcApply_arr = new RecruitApply[20];
	    
	    RecruitApply rcapply1 = new RecruitApply();
	    rcapply1.setRc(rc1); 							// 1번 공고에 지원
	    rcapply1.setGu(gu1);							// 구직자 gu1 이 지원
	    rcapply1.setApply_motive("엄정화는 사무에 최선을 다합니다.");
	    rcApply_arr[RecruitApply.count++] = rcapply1;
	    
	    RecruitApply rcapply2 = new RecruitApply();
	    rcapply2.setRc(rc1); 							// 1번 공고에 지원
	    rcapply2.setGu(gu2);							// 구직자 gu2 이 지원
	    rcapply2.setApply_motive("이순신은 최고의 사무직 인재입니다.");
	    rcApply_arr[RecruitApply.count++] = rcapply2;
	    
	    RecruitApply rcapply3 = new RecruitApply();
	    rcapply3.setRc(rc2); 							// 2번 공고에 지원
	    rcapply3.setGu(gu3);							// 구직자 gu3 이 지원
	    rcapply3.setApply_motive("차은우는 최고의 기술을 가진 엔지니어 입니다.");
	    rcApply_arr[RecruitApply.count++] = rcapply3;
	    
	    RecruitApply rcapply4 = new RecruitApply();
	    rcapply4.setRc(rc3); 							// 3번 공고에 지원
	    rcapply4.setGu(gu1);							// 구직자 gu1 이 지원
	    rcapply4.setApply_motive("엄정화는 영업의 달인 입니다.");
	    rcApply_arr[RecruitApply.count++] = rcapply4;
	    
	    RecruitApply rcapply5 = new RecruitApply();
	    rcapply5.setRc(rc3); 							// 3번 공고에 지원
	    rcapply5.setGu(gu2);							// 구직자 gu2 이 지원
	    rcapply5.setApply_motive("이순신은 판매왕 입니다.");
	    rcApply_arr[RecruitApply.count++] = rcapply5;
	    
	    ////////////////////////////////////////////////////////////////////////
	    
	    Scanner sc = new Scanner(System.in);
	    Ctrl_common ctrl_common = new Ctrl_common();
	    Ctrl_gujikja ctrl_gu = new Ctrl_gujikja();
	    Ctrl_company ctrl_cp = new Ctrl_company();
	    
	    String str_menuno ="";
	    do {
			ctrl_common.main_menu();	// 메인메뉴
			str_menuno = sc.nextLine();
			
			switch (str_menuno) {
			case "1":	// 구직자 회원가입
				ctrl_gu.register(sc, gu_arr);
				break;
				
			case "2":	// 구인회사 회원가입
				ctrl_cp.register(sc,cp_arr);
				break;
			case "3":	// 구직자 로그인
				Gujikja login_gu = ctrl_gu.login(sc, gu_arr);
				
				if(login_gu != null) {
					System.out.println(">> 구직자 " + login_gu.getName() +"님 로그인 성공 ^^ <<\n");
					ctrl_gu.gu_menu(sc, login_gu, cp_arr, rc_arr, rcApply_arr);	// 구직자 전용메뉴
				} else {
					System.out.println(">> 구직자로 로그인 실패 ㅜㅜ <<\n");
				}
				break;	// switch 문을 빠져나간다.
			case "4":	// 구인회사 로그인
				Company login_cp = ctrl_cp.login(sc, cp_arr);
				
				if(login_cp != null) {
					System.out.println(">> 구인회사 " + login_cp.getName() +"기업 로그인 성공 ^^ <<\n");
					ctrl_cp.cp_menu(sc, login_cp, gu_arr, rc_arr, rcApply_arr);	// 구인회사 전용메뉴
																	// 구인회사는 구직자를 search , 모집공고 올림
				} else {
					System.out.println(">> 구인회사로 로그인 실패 ㅜㅜ <<\n");
				}
				break;
			case "5":	// 프로그램 종료
				break;
			default:	// 보기에 없는 경우
				System.out.println("[경고] 메뉴에 없는 번호입니다.\n");
				continue;
			}
		} while (!("5".equals(str_menuno)));	// end of do~while------------------------
	    
	    sc.close();
	    System.out.println("\n>>> 프로그램 종료 <<<");
	    
	}	// end of main()-----------------------

}
