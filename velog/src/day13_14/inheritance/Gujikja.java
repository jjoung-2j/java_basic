package day13_14.inheritance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gujikja extends CommonMember{
	// field 생성
	private String jubun;

	static int count;	// Gujikja instance 개수를 알아오려는 용도
	
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
		// 상속받는 것을 사용하기 때문에 getField() 메소드로 불러와야 한다.
	    // 또한, 부모의 것이므로 앞에 super. 붙여주기!!
		// ==> super.getField()
		
		sb.append(super.getId() + "\t");
	    // 정보 보호를 위해 비밀번호 앞 3자리를 제외한 문자에 * 넣기
	    String str_star = "*".repeat(super.getPasswd().length()-3);
	    sb.append(super.getPasswd().substring(0,3) + str_star + "\t");
	    sb.append(super.getName() + "\t");
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
	    sb.append(super.getRegister_day().substring(0,11));
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
