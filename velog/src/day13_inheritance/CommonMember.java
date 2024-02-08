package day13_inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMember {

	private String id;		// 구직자와 회사 모두 사용할 것이기에 id 로 정의
	private String passwd;
	private String name;
	private String register_day;
	
	// 기본생성자
	public CommonMember() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		register_day = df.format(now);					// 설정해주었기 때문에 setter 을 하지 않아도 된다.
	}	// end of public CommonMember----------------
	
	// === getter === //
	public String getRegister_day() {
		return register_day;
	}	// end of public String getRegister_day()------------
	
	// === setter === //
	public void setId(String id) {
		if(id == null || id.isBlank()) {
	    // null. 은 불가능 하므로 null 일경우를 먼저쓰기!
	    	System.out.println
	        ("[경고] 아이디는 공백이 아닌 글자로 입력해주세요\n");
	    } else {
	    	// 정규표현식 패턴 작성
			Pattern p = Pattern.compile
	        				("^[A-Za-z][A-Za-z0-9]{2,9}$");
	       // 패턴이 일치하는지 확인 (참, 거짓)
	       Matcher m = p.matcher(id);
	       // 판별하기
	       if(m.matches()) {	// 패턴이 일치할 경우
	       		this.id = id;
	       } else {	// 패턴이 일치하지 않을 경우
				System.out.println("[경고] 아이디는 3~10글자로, " 
	    + "첫글자는 영문이어야 하고 나머지는 영문 또는 숫자로만 "
	    + "이루어져야 합니다.\n");
	       }	// end of if~else----------
	    }	// end of if~else---------------
	}	// end of public void setUserid(String id)--------

	// === getter === //
	public String getId() {
		return id;
	}	// end of public String getId()-----------
	
	public void setPasswd(String passwd) {
	// @@@@@@ 비밀번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(passwd.isBlank()) { // 공백이라면
       		System.out.println
              (">> 공백이 아닌 비밀번호를 입력하세요\n");
       }
       int length = passwd.length();
       // 글자수를 8~10 으로 설정
       if(length >= 8 && length <= 10) {
           boolean flag_upper = false;	// 영문대문자 표시
           boolean flag_lower = false;	// 영문소문자 표시
           boolean flag_number = false;	// 숫자 표시
           boolean flag_special = false;// 특수문자 표시
           
           for(int i=0; i<length; i++) {
           		char ch = passwd.charAt(i);
                // passwd 글자를 char 타입으로 변경
                if('가' <= ch && ch <= '힣')	{ // 한글을 적은경우
                	System.out.println("[경고] 한글이 아닌 문자로 적어주세요.");
                	break;	// 더이상 검사할 필요가 없다.
                } else if(' ' == ch) { 	// 공백을 적은경우
                	System.out.println("\n[경고] 공백이 아닌 문자로 적어주세요.");
                	break;	// 더이상 검사할 필요가 없다.
                }
                // 문자들이 모두 사용되었는지 확인하기
                if(Character.isUpperCase(ch))	// 영문대문자
                	flag_upper = true;
                else if(Character.isLowerCase(ch))	// 영문소문자
                	flag_lower = true;
                else if(Character.isDigit(ch))		// 숫자
                	flag_number = true;
                else							// 특수문자
                	flag_special = true;
           }	// end of for--------
           if(flag_upper && flag_lower && flag_number && flag_special)
           	// 하나라도 거짓이라면 false
              	this.passwd = passwd;
           else {
        	   System.out.println("[경고] 비밀번호는 대,소문자,숫자,특수문자가 혼합되어야 합니다.\n");
           }	// end of if~else------------------
       } else {
    	   System.out.println("[경고] 비밀번호는 8~10 글자로 구성되야 합니다.\n");
       }	// end of if~else----------
	}	// end of public void setPasswd(String passwd)--------------
		
	public String getPasswd() {
		return passwd;
	}	// end of public String getPasswd()---------
	
	public void setName(String name) {
		if(2 <= name.length() && name.length() <= 6) {		// 2~6 글자인 경우
			for(int i=0; i<name.length(); i++) {
				if('가' <= name.charAt(i) && name.charAt(i) >= '힣') {
					// 유효성 통과한 경우
					this.name = name;	// 가~힣 사이 글자들
				} else if('가' > name.charAt(i) && name.charAt(i) < '힣'){
					System.out.println("[경고] 성명은 한글로만 이루어져야 합니다.\n");
					break;	// 계속 검사할 이유가 없다.
				}	// end of if~else----
			}	// end of for-------

		} else {	// 2~6 글자가 아닌 경우
			System.out.println("[경고] 성명은 2~6글자로 공백이 없는 한글로만 이루어져야 합니다.\n");
		}	// end of if~else----------
	}	// end of public void setName (String name)-----------
	
	public String getName() {
			return name;
	}	// end of public String getName()-----
}
