package day11_abstraction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gujikja {
	// field 생성
	String userid;
	String passwd;
	String name;
	String jubun;
	String register_day;
	
	static int count;	// Gujikja instance 개수를 알아오려는 용도
	
	public Gujikja() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		register_day = df.format(now);
	}	// end of public Gujikja
	
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
