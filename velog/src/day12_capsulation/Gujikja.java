package day12_capsulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gujikja {
	// field 생성
	private String userid;
	private String passwd;
	private String name;
	private String jubun;
	private String register_day;
	
	static int count;	// Gujikja instance 개수를 알아오려는 용도
	
	public Gujikja() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		register_day = df.format(now);
	}	// end of public Gujikja
	
	// === setter === //
	public void setUserid(String userid) {
		if(userid == null || userid.isBlank()) {
	    // null. 은 불가능 하므로 null 일경우를 먼저쓰기!
	    	System.out.println
	        ("[경고] 아이디는 공백이 아닌 글자로 입력해주세요\n");
	    } else {
	    	// 정규표현식 패턴 작성
			Pattern p = Pattern.compile
	        				("^[A-Za-z][A-Za-z0-9]{2,9}$");
	       // 패턴이 일치하는지 확인 (참, 거짓)
	       Matcher m = p.matcher(userid);
	       // 판별하기
	       if(m.matches()) {	// 패턴이 일치할 경우
	       		this.userid = userid;
	       } else {	// 패턴이 일치하지 않을 경우
				System.out.println("[경고] 아이디는 3~10글자로, " 
	    + "첫글자는 영문이어야 하고 나머지는 영문 또는 숫자로만 "
	    + "이루어져야 합니다.\n");
	       }	// end of if~else----------
	    }	// end of if~else---------------
	}	// end of public void setUserid(String userid)--------

	// === getter === //
	public String getUserid() {
		return userid;
	}	// end of public String getUserid()-----------
	
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
		for(int i=0; i<name.length(); i++) {
			if('가' > name.charAt(i) && name.charAt(i) <'힣') {
				System.out.println("[경고] 성명은 한글로만 이루어져야 합니다.\n");
				break;	// 계속 검사할 이유가 없다.
			}
		}	// end of for-------
		if(2 <= name.length() && name.length() <= 6) {
			// 유효성 통과한 경우
			this.name = name;	// 가~힣 사이 글자들
			
		} else {	// 2~6 글자가 아닌 경우
			System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며, 2~6글자로 이루어져야 합니다.\n");
		}	// end of if~else----------
	}	// end of public void setName (String name)-----------
	
	public String getName() {
			return name;
	}	// end of public String getName()-----
	
	public void setJubun(String jubun) {
	// @@@@@@@ 주민번호 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            if(jubun.length() != 7) {
            	System.out.println("[경고] 주민번호는 7자리를 입력해야 합니다.\n");
            } else {
            	if(!("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6))
            
            		|| "3".equals(jubun.substring(6)) || "4".equals(jubun.substring(6)))) {
            		// 태어난 년도가 1900 년생 이상의 한국인이 아닌경우
            		System.out.println("[경고] 올바른 주민번호를 입력하세요.\n");
            	} else {
            		// 7자리 입력
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
	                    	System.out.println("[경고] 올바른 주민번호를 입력하세요!!\n");
	                    else
	                    	// 유효성 검사가 통과한 후
	                	    this.jubun = jubun;
	                 } catch (ParseException e) {	// 달력에 없는 경우
	                	 System.out.println("[경고] 올바른 주민번호를 입력하세요!!\n");
	                 }	// end of try~catch------
            	}	// end of if~else----------
            }	// end of if~else----------
	}	// end of public void setJubun(String jubun)---
	
	public String getJubun() {
		return jubun;
	}	// end of public String getJubun()----------
	
	String getInfo() {
		StringBuilder sb = new StringBuilder();
	    sb.append(userid + "\t");
	    // 정보 보호를 위해 비밀번호 앞 3자리를 제외한 문자에 * 넣기
	    String str_star = "*".repeat(passwd.length()-3);
	    sb.append(passwd.substring(0,3) + str_star + "\t");
	    sb.append(name + "\t");
	    sb.append(jubun.substring(0,6) + "\t");
	    
	    // === 성별구하기 === //
	    if("1".equals(jubun.substring(6)) 
	    || "3".equals(jubun.substring(6)))
	    	sb.append("남" + "\t");
	    else
	    	sb.append("여" + "\t");
	    
	    // === 만나이 구하기 === //
	    int age = 0;
	    // ## 구직자가 올해 생일이 지난경우,
	    // 		나이 = 현재년도 - 구직자의 태어난 년도
	    // ## 구직자가 올해 생일이 지나지 않은 경우,
	    // 		나이 = 현재년도 - 구직자의 태어난 년도 -1
	    
	    Date now = new Date();	// 현재시각
	    // 보기 쉬운타입으로 바꾸기
	    SimpleDateFormat sdfmt
	    					= new SimpleDateFormat("yyyyMMdd");
	    // 문자열타입으로 바꾸기
	    String str_now = sdfmt.format(now);
	    
	    // 구직자의 올해 생일
	    String str_now_birthday = str_now.substring(0,4)
	    								+ jubun.substring(2,6);

		// 현재년도
		int now_year = Integer.parseInt(str_now.substring(0,4));
	    // 구직자의 년대구하기(1900,2000)
	    int centry = ("1".equals(jubun.substring(6))
	    		|| "2".equals(jubun.substring(6)))?1900:2000;
	    // 구직자의 태어난년도 구하기
	    int birth_year = centry 
	    			+ Integer.parseInt(jubun.substring(0,2));
		try{
	    	// 문자열을 날짜타입으로 변환
	    	now = sdfmt.parse(str_now);
	        Date now_birthday = sdfmt.parse(str_now_birthday);
	       	if(now_birthday.compareTo(now) > 0) 	// 미래
	        	age = now_year - birth_year -1;
	        else
	        	age = now_year - birth_year;       
	    } catch (ParseException e) {
	    //유효성검사를 미리했기 때문에 예외가 나올리 없다.
	 	}	// end of try~catch-------------------
	    sb.append(age + "\t");
	    sb.append(register_day.substring(0,11));
	    // 쌓아둔것을 문자열로 return 하기
	    return sb.toString();
	 }	// end of String get Info()-----------------------

	int getAge() {
		// === 만나이 구하기 === //
	    int age = 0;
	    // ## 구직자가 올해 생일이 지난경우,
	    // 		나이 = 현재년도 - 구직자의 태어난 년도
	    // ## 구직자가 올해 생일이 지나지 않은 경우,
	    // 		나이 = 현재년도 - 구직자의 태어난 년도 -1
	    
	    Date now = new Date();	// 현재시각
	    // 보기 쉬운타입으로 바꾸기
	    SimpleDateFormat sdfmt
	    					= new SimpleDateFormat("yyyyMMdd");
	    // 문자열타입으로 바꾸기
	    String str_now = sdfmt.format(now);
	    
	    // 구직자의 올해 생일
	    String str_now_birthday = str_now.substring(0,4)
	    								+ jubun.substring(2,6);

		// 현재년도
		int now_year = Integer.parseInt(str_now.substring(0,4));
	    // 구직자의 년대구하기(1900,2000)
	    int centry = ("1".equals(jubun.substring(6))
	    		|| "2".equals(jubun.substring(6)))?1900:2000;
	    // 구직자의 태어난년도 구하기
	    int birth_year = centry 
	    			+ Integer.parseInt(jubun.substring(0,2));
		try{
	    	// 문자열을 날짜타입으로 변환
	    	now = sdfmt.parse(str_now);
	        Date now_birthday = sdfmt.parse(str_now_birthday);
	       	if(now_birthday.compareTo(now) > 0) 	// 미래
	        	age = now_year - birth_year -1;
	        else
	        	age = now_year - birth_year;       
	    } catch (ParseException e) {
	    //유효성검사를 미리했기 때문에 예외가 나올리 없다.
	 	}	// end of try~catch-------------------
		
		return age;
	}	// end of int getAge()----------
	
	String getGender() { 
		if("1".equals(jubun.substring(6))
	    	|| "3".equals(jubun.substring(6)))
	    	return "남";
	    else
	    	return "여";
	}	// end of String getGender()-------------
}
