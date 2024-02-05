package day11_abstraction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ctrl_gujikja {
	void main_menu() {
		System.out.println("\n === 메인메뉴 ===\n"
				+ "1. 구직자 회원가입 2. 구직자 모두보기 3. 검색하기");
	    System.out.print("▷ 메뉴번호 선택 : ");
	}	// end of void main_menu()-----------------
	
	
	void register(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count < gu_arr.length) {	// 회원가입 가능
	    	String userid;
	        String passwd;
	        String name;
	        String jubun;
	      	
	    boolean isUse_userid = true;	// do~while 조건문에 넣어주기 위해 do 밖에서 선언해 주어야 한다.
        do{
           isUse_userid = true;	// 틀릴경우 반복될것이기 때문에
           System.out.print("아이디 : ");
           userid = sc.nextLine();
           if(userid.isBlank()) { // userid 가 공백이라면
           		System.out.println(">> 공백이 아닌 아이디를 입력하세요\n");
                isUse_userid = false;
           }
           // 가입된 회원들 중복아이디 검사하기
           for(int i=0; i<Gujikja.count; i++) {
               if(userid.equals(gu_arr[i].userid)) {
               	 System.out.println(">> 이미 동일한 아이디가 있습니다\n");
                 isUse_userid = false;
                 break;
               }
           }	// end of for----------
  		} while(!isUse_userid);	// end of do~while-------
		// @@@@@@ 비밀번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		boolean isUse_passwd = true;
        // do~while 조건문에 넣어주기 위해 do 밖에서 선언
        do{
        	isUse_passwd = true;
            	// 틀릴경우 반복될것이기 때문에
        	System.out.println("\n비밀번호는 8~10 글자로 대,소문자,숫자,특수문자가 혼합되어야 합니다.");
           	System.out.print("비밀번호 : "); 
           	passwd = sc.nextLine();
            if(passwd.isBlank()) { // 공백이라면
           		System.out.println
                  (">> 공백이 아닌 비밀번호를 입력하세요\n");
                isUse_passwd = false;
                continue;	// 다시 입력할 기회를 준다.
           }
           int length = passwd.length();
           // 글자수를 8~10 으로 설정
           if(length >= 8 || length <= 10) {
	           boolean flag_upper = false;	// 영문대문자 표시
	           boolean flag_lower = false;	// 영문소문자 표시
	           boolean flag_number = false;	// 숫자 표시
	           boolean flag_special = false;// 특수문자 표시
	           
	           for(int i=0; i<length; i++) {
	           		char ch = passwd.charAt(i);
	                // passwd 글자를 char 타입으로 변경
	                if('가' <= ch && ch <= '힣')	{ // 한글을 적은경우
	                	System.out.println("[경고] 한글이 아닌 문자로 적어주세요.");
	                	isUse_passwd = false;
	                	break;	// 더이상 검사할 필요가 없다.
	                } else if(' ' == ch) { 	// 공백을 적은경우
	                	System.out.println("\n[경고] 공백이 아닌 문자로 적어주세요.");
	                	isUse_passwd = false;
	                	break;	// 더이상 검사할 필요가 없다.
	                }
	                if(Character.isUpperCase(ch))	// 영문대문자
	                	flag_upper = true;
	                else if(Character.isLowerCase(ch))	// 영문소문자
	                	flag_lower = true;
	                else if(Character.isDigit(ch))		// 숫자
	                	flag_number = true;
	                else							// 특수문자
	                	flag_special = true;
	           }	// end of for--------
               if(!(flag_upper && flag_lower && flag_number && flag_special))
               	// 하나라도 참이 아니라면 false
                  	isUse_passwd = false;
           } else {
        	   isUse_passwd = false;
           }	// end of if~else----------
           if(!isUse_passwd)
        	   System.out.println("[경고] 비밀번호는 8~10 글자로 대,소문자,숫자,특수문자가 혼합되어야 합니다.\n");
       } while(!isUse_passwd);	// end of do~while----
     // @@@@@@ 성명 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        boolean isUse_name = true;
        // do~while 조건문에 넣어주기 위해 do 밖에서 선언
        do{
        	isUse_name = true;
            // 틀릴경우 반복될것이기 때문에
            System.out.println("\n성명은 2~6 글자로 "
            +"공백이 없는 한글로만 이루어져야 합니다.");
           	System.out.print("성명 : "); 
           	name = sc.nextLine();
            
            if(2<=name.length() && name.length() <= 6) {
            	for(int i=0; i<name.length(); i++) {
                	if(!('가' <= name.charAt(i) && name.charAt(i) <= '힣')) {
                    	isUse_name = false;
                        System.out.println("[경고] 성명은 공백없이 한글로만 입력하셔야 합니다.");
                        break;
                    }
               }	// end of for---------
            } else{
            	isUse_name = false;
                System.out.println("[경고] 2글자 이상 6글자 이하 공백없는 한글로만 이루어져야 합니다.");
            }	// end of if~else----------
        } while(!isUse_name);
		// @@@@@@@ 주민번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        boolean isUse_jubun = true;
        // do~while 조건문에 넣어주기 위해 do 밖에서 선언
        do{
        	isUse_jubun = true;
            // 틀릴경우 반복될것이기 때문에
            System.out.println("\n주민번호는 앞에서부터 "
           		+ " 7자리 입력해주세요 ");
           	System.out.print("주민번호 : "); 
           	jubun = sc.nextLine();
            if(jubun.length() != 7) {
            	isUse_jubun = false;
            } else if(!("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6))
            		|| "3".equals(jubun.substring(6)) || "4".equals(jubun.substring(6)))) {
            	// 태어난 년도가 1900 년생 이상의 한국인이 아닌경우
            	isUse_jubun = false;
            } else {	// 7자리 입력
            			// 태어난 년도가 1900년 이상의 한국인
                 String str_birthday = "";	// 생년월일
                 if("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6))) {
                	 str_birthday = "19" + jubun.substring(0,6);
            	 } else{
                 	str_birthday = "20" + jubun.substring(0,6);
                 }	// end of if~else---------
                 
                 // 날짜 보기쉬운 형태로 바꾸기
                 SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
            	// 유효성 검사하는 기능 넣기
                sdformat.setLenient(false);
                // 유효성 검사하기
                try{
                	// 문자열을 날짜 형태로 바꾸기
                	Date birthday = sdformat.parse(str_birthday);
                    // 현재 날짜와 비교해주어야하니 선언
                    Date now = new Date();
					// 보기쉬운형태로 바꾸며 시분초빼기
                    String str_now = sdformat.format(now);
                    // 문자열을 날짜 형태로 바꾸기
                    now = sdformat.parse(str_now);
                    if(birthday.after(now))
                    	isUse_jubun = false;
                    else
                    	isUse_jubun = true;
                 } catch (ParseException e) {	// 달력에 없는 경우
                	 	isUse_jubun = false;
                 }	// end of try~catch------
            }	// end of if~else----------
	         if(!isUse_jubun)
	         	System.out.println("[경고] 올바른 주민번호를 입력하세요!!\n");
         } while(!isUse_jubun);	// end of do~while--------
        
        Gujikja gu = new Gujikja();	// 새로운구직자로 등록하기
        gu.userid = userid;
        gu.passwd = passwd;
        gu.name = name;
        gu.jubun = jubun;
        
        gu_arr[Gujikja.count++] = gu;	// 구직자 배열에 추가하기
        
        System.out.println(">> 구직자 회원가입 성공!! <<\n");
		}	// 회원가입 가능할 경우
		else {	// 구직자 회원수가 gu_arr.length(정원)이 되었을 경우
			System.out.println(">> 정원 " + gu_arr.length +"명이 꽉차서 구직자 회원가입이 어렵습니다.\n죄송합니다.");
		}	// end of if~else--------------
	}	// end of void register(Scanner sc, Gujikja[] gu_arr)
	
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
	                isUse_ageLine_gender = false;
	          }	// end of switch(str_gender.trim())--------
	        }while(!isUse_ageLine_gender);
	        do {
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
		
