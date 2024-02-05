package day13_inheritance;

import java.util.Scanner;

public class Ctrl_gujikja {
	
	// === 구직자 회원가입 === //
	void register(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count < gu_arr.length) {	// 회원가입 가능
	    	String userid;
	        String passwd;
	        String name;
	        String jubun;
	      	
        Gujikja gu = new Gujikja();	// 새로운 구직자로 등록하기
        
        outer:
        do {
        	System.out.print("1. 아이디 : ");
        	userid = sc.nextLine();
        	
        	// 중복 아이디 검사하기
        	for(int i=0; i<Gujikja.count; i++) {
        		if(userid.equals(gu_arr[i].getId())) {
        			System.out.println("이미 사용중인 아이디 이므로 다른 아이디를 입력해주세요.");
        			continue outer;
        		}
        	}	// end of for------
        	
        	// 중복 아이디가 없을 경우
        	gu.setId(userid);
        } while(!(gu.getId() != null));		// !(탈출조건)
        // end of do~while------------------------
        
	    do {
	    	System.out.print("2. 비밀번호 : ");
	    	passwd = sc.nextLine();
	    	
	    	gu.setPasswd(passwd);
	    } while(!(gu.getPasswd() != null));		// !(탈출조건)
	    // end of do~while------------------------
    
	    do {
	    	System.out.print("3. 성명 : ");
	    	name = sc.nextLine();
	    	
	    	gu.setName(name);
	    } while(!(gu.getName() != null));		// !(탈출조건)
	    // end of do~while------------------------
	    
	    do {
	    	System.out.print("4. 주민번호 : ");
	    	jubun = sc.nextLine();
	    	
	    	gu.setJubun(jubun);
	    } while(!(gu.getJubun() != null));		// !(탈출조건)
	    // end of do~while------------------------
	    
	    gu_arr[Gujikja.count++] = gu;	// 구직자 배열에 추가하기
        
        System.out.println(">> 구직자 회원가입 성공!! <<\n");
		}	// 회원가입 가능할 경우
		else {	// 구직자 회원수가 gu_arr.length(정원)이 되었을 경우
			System.out.println(">> 정원 " + gu_arr.length +"명이 꽉차서 구직자 회원가입이 어렵습니다.\n죄송합니다.");
		}	// end of if~else--------------
	}	// end of void register(Scanner sc, Gujikja[] gu_arr)
	
	// === 구직자 로그인 메소드 생성하기 === //
	public Gujikja login(Scanner sc, Gujikja[] gu_arr) {
		System.out.print("▷ 구직자 ID : ");
		String id = sc.nextLine();
		System.out.println("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Gujikja.count; i++) {
			if(id.equals(gu_arr[i].getId()) && passwd.equals(gu_arr[i].getPasswd()))
				// 하나라도 거짓이라면 false
				return gu_arr[i];
		}	// end of for---------
		return null;	// 아이디와 비밀번호가 맞지 않을 경우, 값이 없다! == null
	}	// end of public Gujikja login(Scanner sc, Gujikja[] gu_arr)------------
	
	// === 구직자 전용메뉴 메소드 생성하기 === //
	public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr) {
		String str_menuno;
		do {
			System.out.println("\n === 구직자 전용메뉴(" + login_gu.getName() +"님 로그인중) ===\n"
					+ "1. 내정보 보기	2. 내정보 수정 3. 모든구인회사 조회 4. 구인회사 검색하기 5. 로그아웃");
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
			case "3" :	// 모든구인회사 조회
				view_all_company_info(cp_arr);
				break;
			case "4" :	// 구인회사 검색하기
				search_company(sc,cp_arr);
				break;
			case "5" :	// 로그아웃
				System.out.println(">> 로그아웃 되었습니다. <<\n");
				login_gu = null;
				break;
			default :
				System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다.\n");
				break;
			}
		} while(!"5".equals(str_menuno));
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
				if(!new_jubun.equals(login_gu.getJubun()))	// 기존 주민번호와 동일한 경우
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
			}
		}
	}	// end of private void view_all_company_info(Company[] cp_arr)------
	// @@@@@@ 회사 타이틀 @@@@@@@@@@
	void title_company() {
		System.out.println("-".repeat(70) + "\n"
		    	+ "회사명\t업종\t사업자등록번호\t자본금\n"
		        + "-".repeat(70));
	}	// end of void title_company()-----------------
	
	// === 구인회사 검색하기 === //
	private void search_company(Scanner sc, Company[] cp_arr) {
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
	}	// end of private void search_company(Scanner sc, Company[] cp_arr)------
	
		// === 업종검색 === //
		// 검색한 업종에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_jobtype(Scanner sc, Company[] cp_arr) {
			boolean exit = false;
			StringBuilder sb = new StringBuilder();	// 쌓아둔것을 do~while 밖에서 호출하기 위해
			do {
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
		
	
		
		
/*
	public void view_all_info(Gujikja[] gu_arr) {
		if(Gujikja.count == 0)
	      System.out.println(">> 구직자로 가입된 회원이 없습니다.");
	    else{	// 회원이 있을 경우
	    	title();	// 구직자 타이틀
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<Gujikja.count; i++) {
	        	// 회원 정보나열 쌓기
	        	sb.append(gu_arr[i].getInfo() + "\n");
	        }	// end of for-----------------
	     // 쌓아둔 것 문자열로 바꾸어 출력하기
	        System.out.println(sb.toString());
	    }	// end of if~else------------
	}	// end of public void view_all_info(Gujikja[] gu_arr)---
*/	
	// @@@@@@ 구직자 타이틀 @@@@@@@@@@
	void title() {
		System.out.println("-".repeat(80) + "\n"
		    	+ "아이디   비밀번호\t\t 성명   생년월일   성별"
		        + "   현재만나이   가입일자\n"
		        + "-".repeat(80));
	}	// end of void title()-----------------
	
	// 검색하기 메뉴를 보여주는 메소드
	void search_menu(Scanner sc, Gujikja[] gu_arr) {
		String str_menuno = "";
	    // do~while 조건문에 넣어주기 위해 do 밖에서 선언
	    do{
	    	System.out.println("\n === 검색메뉴 === \n"
	        				+ "1. 연령대검색 2. 성별검색 "
	                        + "3. 연령대 및 성별검색 "
	                        + "4. 메인메뉴로 돌아가기");
	        System.out.print("▷ 메뉴번호 선택 : ");
	        str_menuno = sc.nextLine();
	        switch(str_menuno) {
	        	case "1" : 	// 연령대 검색
	                search_ageLine(sc, gu_arr);
	                break;
	            case "2" : 	// 성별 검색
	                search_gender(sc,gu_arr);
	                break;
	            case "3" :	// 연령대 및 성별 검색
	            	search_ageLine_gender(sc,gu_arr);
	                break;
	            case "4" : 	// 메인메뉴로 돌아가기
	            	break;
	            default :	// 보기에 없는 번호를 입력한 경우
	            	System.out.println
	              ("[경고] 검색메뉴에 존재하는 번호만 입력하세요\n");
	                break;
	        }	// end of switch(str_menuno)--------
	    } while(!("4".equals(str_menuno)));	// end of do~while--
	}	// end of void search_menu(sc, gu_arr)---------------
	// @@@@@@ 연령대 검색 @@@@@@@@@@
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
	        	title();
	            System.out.println(sb.toString());
	        // 쌓아둔 값을 문자열로 출력한다.
	        } else { // 없을 경우
	        	System.out.println("[검색결과 연령대 " 
	            + str_ageLine + "대인 구직자는 없습니다.]");
	        }	// end of if~else-----
	}	// end of if~else------
}	// end of void search_ageLine(sc, gu_arr)-----

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
	        	title();
	            System.out.println(sb.toString());
	        // 쌓아둔 값을 문자열로 출력한다.
	        } else { // 없을 경우
	        	System.out.println("[검색결과 성별 " 
	            + input_gender + "자 구직자는 없습니다.]");
	        }	// end of if~else-----
	    }	// end of if~else---------------
	}	// end of void search_gender(sc, gu_arr)-----
	
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
	           		title();
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
}
		
