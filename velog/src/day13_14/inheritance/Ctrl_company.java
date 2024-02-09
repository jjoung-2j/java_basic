package day13_14.inheritance;

import java.util.Scanner;

public class Ctrl_company {

	// === 구인회사 회원가입 === //
	public void register(Scanner sc, Company[] cp_arr) {
		if(Company.count < cp_arr.length) {	// 정원이 초과되지 않을 경우
			
			Company cp = new Company();	// 새로운 구인회사로 등록하기
			
			outer:
	        do {
	        	System.out.print("1. 아이디 : ");
	        	String id = sc.nextLine();
	        	
	        	// 중복 아이디 검사하기
	        	for(int i=0; i<Company.count; i++) {
	        		if(id.equals(cp_arr[i].getId())) {
	        			System.out.println("이미 사용중인 아이디 이므로 다른 아이디를 입력해주세요.");
	        			continue outer;
	        		}
	        	}	// end of for------
	        	
	        	// 중복 아이디가 없을 경우
	        	cp.setId(id);
	        } while(!(cp.getId() != null));		// !(탈출조건)
	        // end of do~while------------------------
	        
		    do {
		    	System.out.print("2. 비밀번호 : ");
		    	String passwd = sc.nextLine();
		    	
		    	cp.setPasswd(passwd);
		    } while(!(cp.getPasswd() != null));		// !(탈출조건)
		    // end of do~while------------------------
	    
		    do {
		    	System.out.print("3. 회사명 : ");
		    	String name = sc.nextLine();
		    	
		    	cp.setName(name);
		    } while(!(cp.getName() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    do {
		    	System.out.print("4. 업종 : ");
		    	String job_type = sc.nextLine();
		    	
		    	cp.setJob_type(job_type);
		    } while(!(cp.getJob_type() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    do {
		    	System.out.print("5. 사업자등록번호 : ");
		    	String business_number = sc.nextLine();
		    	
		    	cp.setBusiness_number(business_number);
		    } while(!(cp.getBusiness_number() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    cp_arr[Company.count++] = cp;	// 구인회사 배열에 추가하기
	        
	        System.out.println(">> 구인회사 회원가입 성공!! <<\n");
			}	// 회원가입 가능할 경우
			else {	// 구인회사 회원수가 cp_arr.length(정원)이 되었을 경우
				System.out.println(">> 정원 " + cp_arr.length +"개가 꽉차서 구직자 회원가입이 어렵습니다.\n죄송합니다.");
			}	// end of if~else--------------
	}	// end of public void register(Scanner sc, Company[] cp_arr)-------
	
	// === 구인회사 로그인 === //
	public Company login(Scanner sc, Company[] cp_arr) {
		System.out.print("▷ 구인회사 ID : ");
		String id = sc.nextLine();
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Company.count; i++) {
			if(id.equals(cp_arr[i].getId()) && passwd.equals(cp_arr[i].getPasswd()))
				return cp_arr[i];
		}	// end of for------------
		return null;	// 아이디와 패스워드가 틀릴경우
	}	// end of public Company login(Scanner sc, Company[] cp_arr)--------
	
	// === 구인회사 전용메뉴 === //
	public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
		String str_menuno = "";
		do {
			System.out.println("=== 구인회사 전용메뉴(" + login_cp.getName() + "기업 로그인 중) ===\n"
					+ "1. 회사정보 보기 2. 회사정보 수정 3. 모든 구직자 조회 4. 구직자 성별 검색 5. 구직자 연령대 검색\n"
					+ "6. 구직자 연령대 및 성별 검색 7. 채용공고 입력하기 8. 우리회사 채용공고 조회 "
					+ "9. 우리회사 채용공고 지원자 조회 10. 로그아웃");
			System.out.print("▷ 메뉴번호 선택 : ");
			
			str_menuno = sc.nextLine();
			switch (str_menuno) {
			case "1":	// 회사정보 보기
				view_myInfo_company(login_cp);
				break;
			case "2":	// 회사정보 수정
				update_myInfo_company(sc, login_cp);
				break;
			case "3":	// 모든 구직자 조회
				view_all_gujikja_info(gu_arr);
				break;
			case "4":	// 구직자 성별 검색
				search_gender(sc, gu_arr);
				break;
			case "5":	// 구직자 연령대 검색
				search_ageLine(sc, gu_arr);
				break;
			case "6":	// 구직자 연령대 및 성별 검색
				search_ageLine_gender(sc, gu_arr);
				break;
			case "7":	// 채용공고 입력하기
				register_recruit(sc, login_cp, rc_arr);
				break;
			case "8":	// 우리회사 채용공고 조회
				view_recruit_mycompany(login_cp, rc_arr);
			case "9":	// 우리회사 채용공고 지원자 조회
				view_gujikja_my_recruitApply(login_cp, rcApply_arr);
				break;
			case "10":	// 로그아웃
				login_cp = null;
				System.out.println(">> 로그아웃 되었습니다. <<\n");
				break;

			default:	// 메뉴에 없는 보기를 작성한 경우
				System.out.println("[경고] 검색메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
			}	// end of switch------
		} while(!("10".equals(str_menuno)));
	}	// end of public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr, Recruit[] rc_arr)--	

	// == 회사 정보 보기 == // 
	private void view_myInfo_company(Company login_cp) {
		// title
		System.out.println(">>> " + login_cp.getName() + "님의 정보 <<<\n"
				+ "-".repeat(70)+"\n아이디\t비밀번호\t   성명\t업종 사업자등록번호 자본금\t가입일자\n"
				+ "-".repeat(70));
		
		System.out.println(login_cp.getId() + " " 				// 아이디
						+ login_cp.getPasswd()+" "				// 비밀번호
						+ login_cp.getName() + " " 				// 성명
						+ login_cp.getJob_type() + " "			// 업종
						+ login_cp.getBusiness_number() + " " 	// 사업자등록번호
						+ login_cp.getSeed_money() + "원  "		// 자본금
						+ login_cp.getRegister_day().substring(0,10) + "\n");	// 가입일자
		
	}	// end of private void view_myInfo_company(Company login_cp)----------------
	
	// == 회사 정보 수정하기 == //
	private void update_myInfo_company(Scanner sc, Company login_cp) {
		// 회사 정보 보여주기
		view_myInfo_company(login_cp);
		
		// 비밀번호 변경
		String new_passwd;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("1. 비밀번호 : ");
			new_passwd = sc.nextLine();	
	
			if(!new_passwd.equals("")) {	// 입력한 비밀번호가 엔터가 아닐 경우
				
				if(new_passwd.equals(login_cp.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
					System.out.println(">> 기존 암호와 동일하므로 변경이 불가합니다.!!");
				else	// 값이 같지 않을 경우
					login_cp.setPasswd(new_passwd);			// 비밀번호 바꾸기
			}	
			else {		// 입력한 비밀번호가 엔터일 경우
				new_passwd = login_cp.getPasswd();		// 입력한 값에 기존 패스워드를 넣는다.
			}	// end of if------------
		} while(!(login_cp.getPasswd().equals(new_passwd)));	// end of do~while----------------
	
		// 회사명 변경
		String new_name;
		do {
			System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("2. 회사명 : ");
			new_name = sc.nextLine();	
			
			if(!(new_name.equals(""))) {		// 입력한 회사명이 엔터가 아닐 경우
				if(new_name.equals(login_cp.getName()))	// 입력한 회사명이 기존 회사명과 같을 경우
					System.out.println("기존 회사명와 동일하므로 변경이 불가합니다.");
				else	// 값이 같지 않을 경우
					login_cp.setName(new_name);		// 회사명 바꾸기
			}	
			else {	// 입력한 회사명이 엔터일 경우
				new_name = login_cp.getName();		// 입력한 값에 기존 회사명을 넣는다.
			}	// end of if------------
		}while(!(login_cp.getName().equals(new_name)));	// end of do~while----------------
		
		// 업종 변경
		String new_job_type;
		do {
			System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("3. 업종 : ");
			new_job_type = sc.nextLine();
			
			if(!(new_job_type.equals(""))) {	// 입력한 업종이 엔터가 아닐 경우
				if(new_job_type.equals(login_cp.getJob_type()))	// 입력한 업종이 기존 업종과 같을 경우
						System.out.println("기존 업종과 동일하므로 변경이 불가합니다.");
				else	// 값이 같지 않을 경우
					login_cp.setJob_type(new_job_type);	// 업종 바꾸기
			}	
			else {	// 입력한 업종이 엔터일 경우
				new_job_type = login_cp.getJob_type();	// 입력한 값에 기존 업종을 넣는다.
			}	// end of if------------		
		} while (!(login_cp.getJob_type().equals(new_job_type)));	// end of do~while----------------
		
		// 사업자번호 변경
		String new_businessnum;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("4. 사업자등록번호 : ");
			new_businessnum = sc.nextLine();
			
			if(!new_businessnum.equals("")) {	// 입력한 사업자등록번호가 엔터가 아닐 경우
				if(new_businessnum.equals(login_cp.getBusiness_number()))	// 입력한 값이 기존 값과 같을 경우
					System.out.println(">> 기존 사업자등록번호와 동일하므로 변경이 불가합니다.!!");
				else	// 값이 같지 않을 경우
					login_cp.setBusiness_number(new_businessnum);	// 사업자등록번호 바꾸기
			}	
			else {	// 입력한 사업자등록번호가 엔터일 경우
				new_businessnum = login_cp.getBusiness_number();	// 입력한 값에 기존 사업자등록번호를 넣는다.
			}	// end of if------------
		}while(!(login_cp.getBusiness_number().equals(new_businessnum)));
		
		
		// 자본금 변경
		String new_seedmoney;
		boolean exit_seedmoney = false;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("5. 자본금 : ");
			
			try {
				new_seedmoney = sc.nextLine();
				
				if(!new_seedmoney.equals("")) {	// 입력한 자본금이 엔터가 아닐 경우
					if(Long.valueOf(new_seedmoney).equals(login_cp.getSeed_money()))
						System.out.println(">> 기존 자본금과 동일하므로 변경이 불가합니다.!!");
					else	// 기존 자본금과 동일하지 않을 경우
						login_cp.setSeed_money(Long.valueOf(new_seedmoney));
						exit_seedmoney = true;
				} else {
					exit_seedmoney = true;
				}	// end of if------------
			}catch(NumberFormatException e) {	// 숫자가 아닌 값을 입력한 경우
				System.out.println("숫자만 입력해주세요");
			}	// end of try~catch-----------
		}while(!(exit_seedmoney));
	}	// end of private void update_myInfo_company(Scanner sc, Company login_cp)-----------
	
	// === 모든 구직자 조회 === //
	private void view_all_gujikja_info(Gujikja[] gu_arr) {
		if(Gujikja.count == 0)	// 구직자가 없을 경우
			System.out.println(">> 구직자로 가입된 회원이 없습니다. << \n");
		else					// 구직자가 있을 경우
			// 구직자 타이틀
			title_gujikja();	
			// 구직자 정보 나열하기
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<Gujikja.count; i++) {
				sb.append(gu_arr[i].getInfo() + "\n");	// sb 에 구직자 정보 나열 쌓기 => append
			}	// end of for-----------------
			System.out.println(sb.toString());			// 쌓은 정보 문자열로 바꾸어 출력하기
	}	// end of private void view_all_gujikja_info(Gujikja[] gu_arr)-------------
	// 구직자 타이틀
	private void title_gujikja() {
		
		System.out.println("=".repeat(70) +"\n"
					+ "아이디\t비밀번호\t    성명\t주민번호\t성별\t나이\t가입일자\n"
					+ "=".repeat(70));
	}	// end of private void title_gujikja()-------------------
	
	// === 구직자 성별 검색 ===	//
	void search_gender(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 없을 경우
	    System.out.println(">> 구직자로 가입된 회원이 없습니다.\n");
	    } else{	// 구직자가 있는 경우
	    	String input_gender = "";
	        boolean isUse_input_gender = false;
	        do{
	        	System.out.print
	            	("▷ 검색하고자 하는 성별 [남/여] => ");
	            input_gender = sc.nextLine();
	            switch (input_gender.trim()) {
	            case "남" :
	            case "여" :	// 남 또는 여 일 경우
	              isUse_input_gender = true;
	              input_gender = input_gender.trim();
	              // 한글자 이므로 isblank가 아닌 trim 사용가능
	            	break;
	            default :	// 남 또는 여 가 아닐 경우
	            	System.out.println
	                ("[경고] \"남\" 또는 \"여\"만 입력하세요!\n");
	         		break;
	            } 	// end of switch(input_gender.trim())----
	      } while(!isUse_input_gender);	// end of do~while----
	        
	// 입력받은 성별에 해당하는 구직자 찾기
		  StringBuilder sb = new StringBuilder();
	      boolean isSearch = false;
	      
	      for(int i=0; i<Gujikja.count; i++) {
	      	// === 기존 구직자들의 성별 구하기 === //
	          if(input_gender.equals(gu_arr[i].getGender())) {
	          // 검색하고자 한 성별이 같다면,
	              isSearch = true;
	              sb.append(gu_arr[i].getInfo() + "\n");
	              // 정보가 나열된 값이 쌓인다.
	          }
	        }	// end of for----------
	        if(isSearch) {	// 같은 값이 있다면.
	        	title_gujikja();
	            System.out.println(sb.toString());
	        // 쌓아둔 값을 문자열로 출력한다.
	        } else { // 없을 경우
	        	System.out.println("[검색결과 성별 " 
	            + input_gender + "자 구직자는 없습니다.]");
	        }	// end of if~else-----
	    }	// end of if~else---------------
	}	// end of void search_gender(sc, gu_arr)-----
	
	// === 구직자 연령대 검색 === //
	void search_ageLine(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 없을 경우
	    System.out.println(">> 구직자로 가입된 회원이 없습니다.\n");
	    } else{	// 구직자가 있는 경우
	    	String str_ageLine = "";
	    	
	        outer:
	        do{
	        	System.out.println("0~80 대까지 입력 가능합니다.");
	        	System.out.print
	            	("▷ 검색하고자 하는 연령대 [예 : 20] => ");
	            str_ageLine = sc.nextLine();
	            switch(str_ageLine) {
	            case "0" : 
	            case "10" :
	            case "20" :
	            case "30" :
	            case "40" :
	            case "50" :
	            case "60" :
	            case "70" :
	            case "80" :
	            	break outer;
	            default :
	            	System.out.println
	                ("[경고] 올바른 연령대를 입력하세요\n");
	                continue;
	            }	// end of switch(str_ageLine)------
	       } while(true);	// end of do~while-----
	       
	 // 입력받은 연령대에 해당하는 구직자 찾기
	 		StringBuilder sb = new StringBuilder();
	        boolean isSearch = false;
	        for(int i=0; i<Gujikja.count; i++) {
	        // 연령대는 10 단위니까 int 타입을 10 으로
	        // Ex) 26/10 => (int) 2
	        //	   26/10*10 => (int) 20
	          int ageLine = gu_arr[i].getAge()/10*10;	
	          if(Integer.parseInt(str_ageLine) == ageLine) {
	          // 검색하고자 한 값이 연령대가 같다면,
	              isSearch = true;
	              sb.append(gu_arr[i].getInfo() + "\n");
	              // 정보가 나열된 값이 쌓인다.
	          }
	        }	// end of for----------
	        if(isSearch) {	// 같은 값이 있다면.
	        	title_gujikja();
	            System.out.println(sb.toString());
	        // 쌓아둔 값을 문자열로 출력한다.
	        } else { // 없을 경우
	        	System.out.println("[검색결과 연령대 " 
	            + str_ageLine + "대인 구직자는 없습니다.]");
	        }	// end of if~else-----
	}	// end of if~else------
}	// end of void search_ageLine(sc, gu_arr)-----
	
	// === 구직자 연령대 및 성별 검색 === //
	void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 없을 경우
	    	System.out.println
	        		(">> 구직자로 가입된 회원이 없습니다.\n");
	    } else{	// 구직자가 있는 경우
	    	StringBuilder sb = new StringBuilder();
	        String str_ageLine = "";
	        String str_gender = "";
	        boolean isUse_ageLine_gender = false;
	        boolean isSearch = false;
	        
	        outer:
	        do{
	        	System.out.println("0~80 대까지 입력 가능합니다.");
	        	System.out.print
	            	("▷ 검색하고자 하는 연령대 [예 : 20] => ");
	            str_ageLine = sc.nextLine();
	            switch(str_ageLine) {
	            case "0" : 
	            case "10" :
	            case "20" :
	            case "30" :
	            case "40" :
	            case "50" :
	            case "60" :
	            case "70" :
	            case "80" :
	            	isUse_ageLine_gender = true;
	                break;
	            default :
	            	System.out.println
	                ("[경고] 올바른 연령대를 입력하세요\n");
	                break outer;
	            }	// end of switch(str_ageLine)-------
	            for(int i=0; i<Gujikja.count; i++) {
	            	int ageLine = gu_arr[i].getAge()/10*10;
	                if(Integer.parseInt(str_ageLine) == ageLine)
	                {isSearch = true;
	                break;
	                }
	            }	// end of for--------
	            if(!isSearch) {
	            	System.out.println("[검색결과 연령대 " 
	            + str_ageLine + "대인 구직자는 없습니다.]");
	            break outer;
	        }
	        
	        do{
	          System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
	          str_gender = sc.nextLine();
	          switch (str_gender.trim()) {
	          case "남" :
	          case "여" :
	        	isUse_ageLine_gender = true;
	            str_gender = str_gender.trim();
	            break;
	          default :
	          	System.out.println
	            	("[경고] \"남\" 또는 \"여\"만 입력하세요!\n");
	                break;
	          }	// end of switch(str_gender.trim())--------
	          isSearch = false;
	          for(int i=0; i<Gujikja.count; i++) {
	          	if(str_gender.equals(gu_arr[i].getGender())) {
	            // 검색하고자 한 성별이 같다면,
	            	isSearch = true;
	                sb.append(gu_arr[i].getInfo() + "\n");
	                //정보가 나열된 값이 쌓인다.
	            }
	           }	// end of for-----------
	           if(isSearch) {	// 같은 값이 있다면
	        	   	title_gujikja();
	              	System.out.println(sb.toString());
	                // 쌓아둔 값을 문자열로 출력한다.
	           } else {	// 없을 경우
	           		System.out.println("[검색결과 " 
	            	+ str_gender + "자 구직자는 없습니다.]\n");
	           }	// end of if~else-------
	        } while(!isSearch);	// end of do~while----
	        } while(!isUse_ageLine_gender);	// end of do~while--
	    }	// end of if~else------------
	}	// end of void search_ageLine_gender(sc, gu_arr)-------
	
	// === 채용공고 입력하기 ===	//
	private void register_recruit(Scanner sc, Company login_cp, Recruit[] rc_arr) {
		System.out.println("======= " + login_cp.getName() + " 채용공고 등록 ======="); 
		
		Recruit rc = new Recruit();				// Recruit rc 이용
		
		do {
			System.out.print("1.채용제목 : ");
			String subject = sc.nextLine();
			rc.setSubject(subject);
		} while ( !(rc.getSubject() != null) );
		
		do {
			System.out.print("2.채용분야[예> 사무직] : ");
			String work_type = sc.nextLine();
			rc.setWork_type(work_type);
		} while ( !(rc.getWork_type() != null) );
		
		do {
			System.out.print("3.채용인원 : ");
			String str_cnt = sc.nextLine();
			try {
				int cnt = Integer.parseInt(str_cnt);		// String -> integer 타입으로 변환
				if(cnt <= 0) 
					System.out.println("[경고] 1 이상 입력하세요!!");
				else 
					rc.setCnt(cnt);
			} catch(NumberFormatException e) {	// 문자열에서 숫자로 변환하는데 오류
				System.out.println("[경고] 1 이상 입력하세요!!");
			}	// end of try~catch--------------------------
		} while ( !(rc.getCnt() > 0) );		// end of do~while--------------------
		
		do {
			System.out.print("4.연봉[단위 만원] : ");
			String str_yearpay = sc.nextLine();
			try {
				int yearpay = Integer.parseInt(str_yearpay);	// String -> integer 타입으로 변환
				if(yearpay <= 0) 
					System.out.println("[경고] 1 이상 입력하세요!!");
				else 
					rc.setYearpay(yearpay);
			} catch(NumberFormatException e) {	// 문자열에서 숫자로 변환하는데 오류
				System.out.println("[경고] 1 이상 입력하세요!!");
			}	// end of try~catch-------------------------
		} while ( !(rc.getYearpay() > 0) );		// end of do~while---------------------
		
		do {
			System.out.print("5.채용마감일자[예> 20240208] : ");
			String finish_day = sc.nextLine();
			rc.setFinish_day(finish_day);
		} while ( !(rc.getFinish_day() != null) );
		
		System.out.println("");
		rc.setCp(login_cp); 	// 현재 구인회사로 로그인해서 들어온 상태이다.
		rc_arr[Recruit.count++] = rc;
	}	// end of private void register_recruit(Scanner sc, Company login_cp, Recruit[] rc_arr)------
	
	// == 우리회사 채용공고 조회 == //
	private void view_recruit_mycompany(Company login_cp, Recruit[] rc_arr) {
		boolean is_existence = false;
		for(int i=0; i<Recruit.count; i++) {	
			if( login_cp.getId().equals(rc_arr[i].getCp().getId()) ) {
				// 로그인한 회사의 아이디와 지원공고에 적힌 회사의 아이디가 같다면 
				is_existence = true;
				System.out.println(rc_arr[i].recruit_info());	// 채용공고 정보
			}
		}// end of for-------------------------------------

		if(!is_existence) 		// 로그인한 회사의 아이디와 지원공고에 적힌 회사의 아이디가 같지 않다면
			System.out.println(">> 채용공고를 낸 것이 없습니다.<<\n");
	}	// end of private void view_recruit_mycompany(Company login_cp, Recruit[] rc_arr)---------
	
	// == 우리회사 채용공고 지원자 조회 == //
	private void view_gujikja_my_recruitApply(Company login_cp, RecruitApply[] rcApply_arr) {
		boolean is_existence = false;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<RecruitApply.count; i++) {
			if( login_cp.getId().equals( rcApply_arr[i].getRc().getCp().getId() ) ) {
				// 로그인한 회사의 아이디와 지원공고에 적힌 회사의 아이디가 같다면 
				is_existence = true;
				sb.append(rcApply_arr[i].getRc().getRecruit_no()+"\t"+		// 채용공고순번
						  rcApply_arr[i].getRc().getSubject()+"\t"+			// 채용제목
						  rcApply_arr[i].getGu().getName()+"\t"+			// 구직자 이름
						  rcApply_arr[i].getGu().getGender()+"\t"+			// 구직자 성별
						  rcApply_arr[i].getGu().getAge()+"\t"+				// 구직자 나이
						  rcApply_arr[i].getApply_motive()+"\n");			// 구직자 지원동기
			}
		}	// end of for--------------------------
		if(is_existence) {	// 로그인한 회사의 아이디와 지원공고에 적힌 회사의 아이디가 같다면
			System.out.println("=".repeat(100));
			System.out.println("채용공고번호  채용제목                 지원자명   성별  나이   지원동기 ");
			System.out.println("=".repeat(100));
			System.out.println(sb.toString());
		}
		else {	// 지원한 사람이 없을 경우 or 채용공고가 없을 경우
			System.out.println(">> 채용공고에 지원자가 없습니다. <<\n");
		}	// end of if~else------------------------
	}	// end of private void view_gujikja_my_recruitApply(Company login_cp, RecruitApply[] rcApply_arr)
		
}
