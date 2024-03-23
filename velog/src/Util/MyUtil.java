package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	
public static boolean isCheckPasswd(String passwd) {
		
		if(passwd == null)
			return false;
		
		int length = passwd.length();
		if(length <8 || length >15)
			return false;
		
		boolean flag_upper = false;		// 영문대문자 표식을 위한 용도
		boolean flag_lower = false;		// 영문소문자 표식을 위한 용도
		boolean flag_number = false;	// 숫자 표식을 위한 용도
		boolean flag_special = false;	// 특수문자 표식을 위한 용도
		
		for(int i=0;i<length;i++) {
			char ch = passwd.charAt(i);
			if('가' <= ch && ch <= '힣') {	// 한글인 경우
				return false;
			}
			
			if(Character.isUpperCase(ch))	// 영문대문자인 경우
				flag_upper = true;
			
			else if(Character.isLowerCase(ch))	// 영문소문자인 경우
				flag_lower = true;
			
			else if(Character.isDigit(ch))	// 숫자인 경우
				flag_number = true;
			
			else	// 특수문자일 경우
				flag_special = true;

		}	// end of for----------------
		
		return flag_upper && flag_lower && flag_number && flag_special;	
		// 4개 중 하나라도 false 가 나오면 false
		// 이제부터는 입력받은 passwd 의 글자수가 8글자 이상 15글자 이하인 경우
	}	// end of isCheckPasswd(String passwd)-----------------------


	
	public static boolean isCheckJubun(String jubun) {
			
		if(jubun.length() != 7) {
			return false;
		}
		
		else if( !("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)) ||
				"3".equals(jubun.substring(6)) || "4".equals(jubun.substring(6)) )) {
			return false;
		}
		else {
			String str_birthday = "";	// 생년월일	(String 타입)
			if("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)))
				str_birthday = "19" + jubun.substring(0,6);		// 예 990520 생년월일
			else {
				str_birthday = "20" + jubun.substring(0,6);		// 예 001219 생년월일
			}	
		
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
			
			sdformat.setLenient(false); 	// 이거 안넣으면 32일도 맞다고 표시된다.
			// false 로 해주어야만 입력한 값을 날짜 타입으로 변경할때 날짜로 되지 못하는 값일 경우 오류가 발생한다.
			// 날짜로 파싱될 때 허술하게 하지 말고 엄격하게 하라고 설정해주는 것이라고 생각하면 된다. 
			
			// === 문자열을 날짜 형태로 변환하기 === //
			try {
				Date birthday = sdformat.parse(str_birthday);		// 스트링타입을 date 타입으로 바꿈
				// Date d = sdformat.parse("19980431");	// 존재 O , setLenient 때문에 가능
				// 현재날짜와 회원의생일날짜를 비교해서 회원의 생일날짜가 현재날짜보다 이후라면 안된다.
				
				Date now = new Date();	// 현재날짜시각
				String str_now = sdformat.format(now);	//20240131	// 문자열에서 시분초빼기
				now = sdformat.parse(str_now);	// 문자열을 date 타입으로 바꿈
				
				if(birthday.after(now))		// birthday 가 now 보다 미래일 때
					return false;
				else						// birthday 가 now 랑 같거나 과거일 때
					return true;
					// end of if--------
				
			} catch (ParseException e) {
				return false;
			}	// end of try~catch-------------------------
		}	// end of if-----------------------------
	}	// end of public static boolean isCheckJubun(String jubun)-----




}
