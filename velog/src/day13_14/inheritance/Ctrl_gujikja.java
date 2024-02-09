package day13_14.inheritance;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ctrl_gujikja {
	
	// === 구직자 회원가입 === //
	void register(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count < gu_arr.length) {	// 회원가입 가능

	        Gujikja gu = new Gujikja();	// 새로운 구직자로 등록하기
	        
	        outer:
	        do {
	        	System.out.print("1. 아이디 : ");
	        	String id = sc.nextLine();		// 구직자와 회사의 아이디
	        	
	        	// 중복 아이디 검사하기
	        	for(int i=0; i<Gujikja.count; i++) {
	        		if(id.equals(gu_arr[i].getId())) {
	        			System.out.println("이미 사용중인 아이디 이므로 다른 아이디를 입력해주세요.");
	        			continue outer;
	        		}
	        	}	// end of for------
	        	
	        	// 중복 아이디가 없을 경우
	        	gu.setId(id);
	        } while(!(gu.getId() != null));		// !(탈출조건)
	        // end of do~while------------------------
	        
		    do {
		    	System.out.print("2. 비밀번호 : ");
		    	String passwd = sc.nextLine();
		    	
		    	gu.setPasswd(passwd);
		    } while(!(gu.getPasswd() != null));		// !(탈출조건)
		    // end of do~while------------------------
	    
		    do {
		    	System.out.print("3. 성명 : ");
		    	String name = sc.nextLine();
		    	
		    	gu.setName(name);
		    } while(!(gu.getName() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    do {
		    	System.out.print("4. 주민번호 : ");
		    	String jubun = sc.nextLine();
		    	
		    	gu.setJubun(jubun);
		    } while(!(gu.getJubun() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    gu_arr[Gujikja.count++] = gu;	// 구직자 배열에 추가하기
	        
	        System.out.println(">> 구직자 회원가입 성공!! <<\n");
			}	//--------------// 회원가입이 가능할 경우
		else {	// 구직자 회원수가 gu_arr.length(정원)이 되었을 경우
			System.out.println(">> 정원 " + gu_arr.length +"명이 꽉차서 구직자 회원가입이 어렵습니다.\n죄송합니다.");
		}	// end of if~else--------------
	}	// end of void register(Scanner sc, Gujikja[] gu_arr)
	
	// === 구직자 로그인 메소드 생성하기 === //
	public Gujikja login(Scanner sc, Gujikja[] gu_arr) {
		System.out.print("▷ 구직자 ID : ");
		String id = sc.nextLine();
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Gujikja.count; i++) {
			if(id.equals(gu_arr[i].getId()) && passwd.equals(gu_arr[i].getPasswd()))
				// 하나라도 거짓이라면 false
				return gu_arr[i];
		}	// end of for---------
		return null;	// 아이디와 비밀번호가 맞지 않을 경우, 값이 없다! == null
	}	// end of public Gujikja login(Scanner sc, Gujikja[] gu_arr)------------
	
	// === 구직자 전용메뉴 메소드 생성하기 === //
	public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
		String str_menuno;
		do {
			System.out.println("\n === 구직자 전용메뉴(" + login_gu.getName() +"님 로그인중) ===\n"
					+ "1. 내정보 보기	2. 내정보 수정 3. 모든 구인회사 조회 4. 구인회사 검색하기\n"
					+ "5. 모든 채용공고 조회 6. 채용 지원하기 7. 지원한 채용공고 조회 8. 로그아웃");
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();
			
			// 구직자 전용메뉴에서 메뉴선택 후
			switch(str_menuno) {
			case "1" :	// 내정보 보기
				view_myInfo(login_gu);
				break;
			case "2" :	// 내정보 수정
				update_myInfo(sc, login_gu);
				break;
			case "3" :	// 모든 구인회사 조회
				view_all_company_info(cp_arr);
				break;
			case "4" :	// 구인회사 검색하기
				search_company(sc,cp_arr);
				break;
			case "5" :	// 모든 채용공고 조회
				view_all_recruit_info(rc_arr);
				break;
			case "6" :	// 채용 지원하기
				input_recruitApply(sc, login_gu, rc_arr, rcApply_arr);
				break;
			case "7" :	// 지원한 채용공고 조회
				view_my_recruitApply(login_gu, rcApply_arr);
				break;
			case "8" :	// 로그아웃
				System.out.println(">> 로그아웃 되었습니다. <<\n");
				login_gu = null;
				break;
			default :
				System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다.\n");
				break;
			}
		} while(!"8".equals(str_menuno));
	}	// end of public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr)---

	// === 내정보 보기 === //
	private void view_myInfo(Gujikja login_gu) {
		System.out.println(">>> " + login_gu.getName() + "님의 정보 <<<");
		System.out.println("-".repeat(40) + "\n아이디\t비밀번호t   성명\t주민번호\n" + "-".repeat(40));
		System.out.println(login_gu.getId() + " ".repeat(3)
				+ login_gu.getPasswd() + " "
				+ login_gu.getName() + " ".repeat(2)
				+ login_gu.getJubun());
	}	// end of private void view_myInfo(Gujikja login_gu)----------
	
	// === 내정보 수정 === //
	private void update_myInfo(Scanner sc, Gujikja login_gu) {
		view_myInfo(login_gu);	// 기존 정보 보여주기
		
		// @@ 비밀번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String new_passwd;
		do {
			System.out.println("\n>>[알림] 기존 정보를 유지하시려면 엔터를 입력하세요");
			System.out.print("1.비밀번호 : ");
			new_passwd = sc.nextLine();
			if(!new_passwd.equals("")) {	// 정보를 변경할 경우
				if(login_gu.getPasswd().equals(new_passwd))
					System.out.println(">> 기존 암호와 동일하므로 변경이 불가합니다.");
				else {
					login_gu.setPasswd(new_passwd);
				}	// end of if~else------------
			} else	// 정보를 변경하지 않을 경우
				new_passwd = login_gu.getPasswd();
			if(!(login_gu.getPasswd().equals(new_passwd)))
				System.out.println("[경고] 비밀번호는 8~10 글자로 대,소문자,숫자,특수문자가 혼합되어야 합니다.\n");
		} while(!(login_gu.getPasswd().equals(new_passwd)));// end of do~while-------------------
		// 패스워드가 변경이 성공되거나, 변경시도를 하지 않은 경우
		
		// @@ 성명 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String new_name;
		do {
			System.out.println("\n>>[알림] 기존 정보를 유지하시려면 엔터를 입력하세요");
			System.out.print("2. 성명 : ");
			new_name = sc.nextLine();
			if(!(new_name.equals(""))) {	// 정보를 변경할 경우
				if(new_name.equals(login_gu.getName()))	// 기존성명과 동일할 경우
					System.out.println(">> 기존 성명과 동일하여 변경이 불가합니다.");
				else
					login_gu.setName(new_name);
			} else	// 정보를 변경하지 않을 경우
				new_name = login_gu.getName();
		} while(!(login_gu.getName().equals(new_name)));	// end of do~while------------
		// 성명이 변경에 성공하거나, 변경시도를 하지 않은 경우
		
		// @@ 주민번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String new_jubun;
		do {
			System.out.println("\n>>[알림] 기존 정보를 유지하시려면 엔터를 입력하세요");
			System.out.print("3. 주민번호 : ");
			new_jubun = sc.nextLine();
			if(!(new_jubun.equals(""))) {	// 정보를 변경할 경우
				if(new_jubun.equals(login_gu.getJubun()))	// 기존 주민번호와 동일한 경우
					System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다.");
				else
					login_gu.setJubun(new_jubun);
			} else	// 정보를 변경하지 않을 경우
				new_jubun = login_gu.getJubun();
		} while(!(login_gu.getJubun().equals(new_jubun)));	// end of do~while---------
		// 주민번호 변경이 성공되거나, 변경시도를 하지 않은 경우
	}	// end of private void update_myInfo(Scanner sc, Gujikja login_gu)------
	
	// === 모든 구인회사 조회 === //
	private void view_all_company_info(Company[] cp_arr) {
		if(Company.count == 0)	// 회사가 없을 경우
			System.out.println(">> 구인회사로 등록된 회사가 없습니다. <<\n");
		else {	// 회사가 있을 경우
			title_company();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<Company.count; i++) {
				sb.append(cp_arr[i].getInfo() + "\n");
			}	// end of for-----------
			System.out.println(sb.toString());
		}
	}	// end of private void view_all_company_info(Company[] cp_arr)------
	// @@@@@@ 회사 타이틀 @@@@@@@@@@
	void title_company() {
		System.out.println("-".repeat(70) + "\n"
		    	+ "회사명\t업종\t사업자등록번호\t자본금\t\t등록일자\n"
		        + "-".repeat(70));
	}	// end of void title_company()-----------------
	
	// === 구인회사 검색하기 === //
	private void search_company(Scanner sc, Company[] cp_arr) {
		try {
		boolean exit = false;
		do {
			System.out.println(">>> 구인회사 검색메뉴 <<<\n"
					+ "1. 업종 검색 2. 자본금 검색 3. 구직자메뉴로 돌아가기");
			System.out.print("▷ 검색메뉴번호 입력 : ");
			
			int search_num = Integer.parseInt(sc.nextLine());	// 입력한 번호 저장
			switch(search_num) {
			case 1:		// 업종검색
				search_jobtype(sc,cp_arr);
				break;
			case 2:		// 자본금검색
				search_seedmoney(sc,cp_arr);
				break;
			case 3:		//구직자메뉴로 돌아가기
				exit = true;
				break;
			default:	// 보기에 없는 것을 누른경우
				System.out.println("[경고] 메뉴에 있는 번호를 입력해주세요.");
				break;
			}	// end of switch-----
		} while(!exit);	// end of do~while---------
		} catch(NumberFormatException e) {
			System.out.println("[경고] 메뉴에 있는 번호를 입력해주세요.");
		}
	}	// end of private void search_company(Scanner sc, Company[] cp_arr)------
	
		// === 업종검색 === //
		// 검색한 업종에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_jobtype(Scanner sc, Company[] cp_arr) {
			boolean exit = false;
			StringBuilder sb = new StringBuilder();	// 쌓아둔것을 do~while 밖에서 호출하기 위해
			do {
				System.out.println("엔터를 누르시면 모든 업종을 보실 수 있습니다. 또한 검색메뉴로 돌아갑니다.");
				System.out.print("▷ 업종명 : ");
				String jobtype = sc.nextLine();
				String search_jobtype = String.join("", jobtype.split(" "));
				// " " 으로 구분짓고 연결시키기 -> 공백없애기
				for(int i=0; i<Company.count; i++) {
					if(cp_arr[i].getJob_type().toLowerCase().contains(search_jobtype.toLowerCase())) {
						// 소문자로 변환시켜서 검색한 글씨가 업종목록에 해당하는 것이 있다면
						// 글씨가 해당한 업종이 있다면
						exit = true;
						sb.append(cp_arr[i].getInfo() + "\n");	// 해당한 업종 쌓기
					} 
				}	// end of for-----------
				if(!exit)
					System.out.println("검색하시려는 " + search_jobtype + "은 없습니다.");
			} while(!exit);	// end of do~while----------
			
			// 해당 업종이 있는 경우 탈출
			title_company();
			System.out.println(sb.toString());
		}	// end of private void search_jobtype(Scanner sc, Company[] cp_arr)----------
		
		// === 자본금 검색하기 === //
		// 검색한 자본금에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_seedmoney(Scanner sc, Company[] cp_arr) {
			boolean exit = false;
			StringBuilder sb = new StringBuilder();
			do {
				try {
					System.out.print("▷ 자본금 : ");
					long seedmoney = Long.parseLong(sc.nextLine());
					for(int i=0; i<Company.count; i++) {
						if(cp_arr[i].getSeed_money() >= seedmoney) {	// 입력한 자본금 이상이라면
							exit = true;
							sb.append(cp_arr[i].getInfo() + "\n");	// 해당 회사의 정보 쌓기
						}
					}	// end of for----------
					if(!exit)	// 해당 회사가 없다면
						System.out.println("자본금이 " + seedmoney + "이상인 회사는 없습니다.");
				} catch(NumberFormatException e) {
					System.out.println("올바른 수를 입력하세요");
				}	// end of try~catch----------
			} while(!exit);	// end of do~while------------
			
			// 해당 자본금이 있는 경우 탈출
			title_company();
			System.out.println(sb.toString());
		}	// end of private void search_seedmoney(Scanner sc, Company[] cp_arr)---------
		
		// === 모든 채용공고 조회 === //
		private void view_all_recruit_info(Recruit[] rc_arr) {
			if(Recruit.count == 0) {
				System.out.println(">> 채용공고가 1개도 없습니다. <<\n");
			} else {
				
				StringBuilder sb = new StringBuilder();
				try {
					Date now = new Date();
					SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
					Date today = sdft.parse(sdft.format(now));
					
					for(int i=0; i<Recruit.count; i++) {
						Date date_finish_day = sdft.parse(rc_arr[i].getFinish_day());	// String -> Date 타입 변환
					
						// == !채용마감일자.befor(오늘날짜)
						if(!date_finish_day.before(today)) {
						// if(rc_arr[i].getFinish_day() != null) {		// 채용마감일이 오늘날짜 이후
						sb.append(rc_arr[i].getRecruit_no()+"\t\t"+
								  rc_arr[i].getCp().getName()+"\t"+
								  rc_arr[i].getCp().getJob_type()+"\t"+
								  new DecimalFormat("#,###").format(rc_arr[i].getCp().getSeed_money())+"원\t"+
								  rc_arr[i].getWork_type()+"\t"+
								  rc_arr[i].getCnt()+"\t"+
								  rc_arr[i].getRegister_day().substring(0,4)+"-"+rc_arr[i].getRegister_day().substring(4,6)+"-"+rc_arr[i].getRegister_day().substring(6)+"\t"+  
								  rc_arr[i].getFinish_day().substring(0,4)+"-"+rc_arr[i].getFinish_day().substring(4,6)+"-"+rc_arr[i].getFinish_day().substring(6)+"\n");
					}
					}// end of for-----------------------------------
				} catch(ParseException e) {
				}
				System.out.println("-".repeat(90));
				System.out.println("채용공고순번      회사명   회사직종타입  자본금   채용분야(근무형태)  채용인원  등록일자  채용마감일자");
				System.out.println("-".repeat(90));
			    System.out.println(sb.toString());
				System.out.println("[채용공고가 "+ Recruit.count +"건이 있습니다]\n");
			}
			
		}	// end of private void view_all_recruit_info(Recruit[] rc_arr)-------------
		
		// === 채용 지원하기 === //
		private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
			String str_my_recruit_no = "";
			for(int i=0; i<RecruitApply.count; i++) {
				if(rcApply_arr[i].getGu().getId().equals(login_gu.getId())) {
					// 지원한 구직자의 아이디와 로그인한 구직자의 아이디가 같다면
					str_my_recruit_no += rcApply_arr[i].getRc().getRecruit_no()+","; 
					// 지원한 채용공고 순번 쌓기
				}
			}// end of for-------------------------------

			// 맨 뒤에 ',' 이 있으니 빼준다.
			str_my_recruit_no = str_my_recruit_no.substring(0, str_my_recruit_no.length()-1); 
			
			// ',' 을 기준으로 나눠준다.
			String[] my_recruit_no_arr = str_my_recruit_no.split("\\,");
			// Ex) {"1","3","2"}
			
			if( my_recruit_no_arr.length == Recruit.count ) {	// 총 공고와 지원한 공고의 수가 같다면
				System.out.println(">> 이미 모든 채용공고에 응모하셨기에 더 이상 응모할 채용공고번호가 없습니다. \n");
				return; // 메소드 종료 
			}
			
			boolean is_existence, is_duplicate_recruit_no;
			Recruit rc = null;
			do {
				is_existence = false;
				is_duplicate_recruit_no = false;		// 중복지원 표시하기
							
				System.out.print("▷ 채용공고번호 : ");
				String input_recruit_no = sc.nextLine();				
				for(int i=0; i<Recruit.count; i++) {
					if( input_recruit_no.equals( String.valueOf(rc_arr[i].getRecruit_no()) ) ) {
						// 입력한 채용공고번호와 공고의 채용공고번호가 같다면
						is_existence = true;
						rc = rc_arr[i];
						break;
					}
				}// end of for--------------------
				
				if(!is_existence) {	// 입력한 번호가 채용공고번호에 없는 경우
					System.out.println(">> 입력하신 "+ input_recruit_no +"번은 채용공고에 존재하지 않습니다.!!\n");
				}
				
				else {	// 입력한 채용공고번호와 공고의 채용공고 번호가 같다면
						// == 채용공고번호는 채용공고로 올라온 번호이지만 이미 응모한 채용공고번호는 입력하면 안된다. == //
						for(int i=0; i<RecruitApply.count; i++) {
							if(String.valueOf(rcApply_arr[i].getRc().getRecruit_no()).equals(input_recruit_no) &&  
							   // 지원한 공고의 채용공고순번과 입력한 채용공고순번이 같다면
									rcApply_arr[i].getGu().getId().equals(login_gu.getId()) ) {
								// 또는 지원한 구직자의 아이디와 로그인한 구직자의 아이디가 같다면
								 is_duplicate_recruit_no = true;	// 중복지원이다.
								 break;
							}
						}// end of for-----------------------------
						
						if(is_duplicate_recruit_no) 	// 중복지원이라면
							System.out.println(">> 입력하신 채용공고번호 "+ input_recruit_no + "번은 이미 응모하신 번호 입니다. \n"); 						
						else {	// 중복지원이 아니라면
							do {
								System.out.print("▷ 지원동기 : ");
								String apply_motive = sc.nextLine();
								if(apply_motive.isBlank()) 	// 지원동기가 공백이면
									System.out.println("[경고] 지원동기는 필수로 입력하셔야 합니다.!!\n");
								else {	// 지원동기가 공백이 아니면
									RecruitApply rc_apply = new RecruitApply();
									rc_apply.setRc(rc);
									rc_apply.setGu(login_gu);
									rc_apply.setApply_motive(apply_motive);
									
									rcApply_arr[RecruitApply.count++] = rc_apply; 
									break;
								}
							} while(true);	// end of do~while--------------
						}	// end of if~else------------
					}	// end of if~else--------------------------------			
			} while(!(is_existence && !is_duplicate_recruit_no));	// end of do~while--------
		}	// end of private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr)----
		
		// === 지원한 채용공고 조회 === //
		private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr) {
			boolean is_existence = false;
			
			for(int i=0; i<RecruitApply.count; i++) {
				if( login_gu.getId().equals(rcApply_arr[i].getGu().getId()) ) {
					// 로그인한 구직자의 아이디와 지원한 구직자의 아이디가 같다면
					is_existence = true;
					System.out.print(rcApply_arr[i].getRc().recruit_info());
					System.out.println("▣ 지원동기 : " + rcApply_arr[i].getApply_motive() + "\n\n");
				}
			}// end of for----------------------------------
			
			if(!is_existence) 	// 로그인한 구직자의 아이디가 지원한 곳에 없을 경우
				System.out.println(">> 채용공고에 응모한 내역이 없습니다. <<\n");
		}	// end of private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr)---
}
		
