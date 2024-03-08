package my.day13_14.a.inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Util.MyUtil;

public class CommonMember {
	
	// Gujikja 클래스와 Company 클래스에서 공통으로 사용되어지는 field(속성) 생성하기
	
	private String id;        		// 아이디
	private String passwd;        	// 비밀번호
	private String name;          	// 성명
	private String register_day;  	// 가입일자
	
	// Gujikja 및 Company 클래스의 부모클래스인 CommonMember 클래스의 기본생성자
	public CommonMember(){
		// System.out.println("== 부모클래스인 CommonMember 클래스의 기본생성자 호출 ==");
		Date now = new Date();// 현재시각
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		register_day = df.format(now);
		// 2024-01-30 15:12:10
	}
	
	// 캡슐화(EnCapsulation == 은닉화) 되어진 field 를 메소드를 통해 접근하도록 만들기 //
		// == getter , setter  == // 
		public void setId(String id) {
			
			if(id == null || id.isBlank()) {	// null. 이 들어오면 안되기 때문에 유효성 검사가 반드시 필요하다.
				System.out.println("[경고] 아이디는 공백이 아닌 글자로 입력하셔야 합니다.\n");
			} else {
				
				// userid 는 첫글자는 반드시 영문(대.소문자)자로 시작해야 하고 그나머지 글자는
				// 영문자 또는 숫자로만 이루어져야 한다.!!
				// 그리고 userid 의 길이는 최소 3글자, 최대 10글자로 제한한다.
				
				// >> 정규표현식(Regular Expression)이란? <<
				// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
				
				// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
				Pattern p = Pattern.compile("^[A-Za-z][A-Za-z0-9]{1,9}$");		// [A-Za-z0-9] 가 {a,b} 최소 a 번 반복, 최대 b 번 반복
				// ^ 은 시작을 의미한다.
				// $ 는 끝을 의미한다.
				// [] 는 글자 1개가 들어오는 것을 의미한다.
				// [A-Za-z] 는 글자 1개가 들어오는데 영문자만 가능하다.				// [a-z] a 또는 b 또는 ... 또는 z
				// [A-Za-0-9] 는 글자 1개가 들어오는데 영문자 또는 숫자만 가능하다.	// 만약 2를 빼겠다면 [A-Za-03456789] 로 사용 
				// [A-Za-z0-9]{1,9} 은 [A-Za-z0-9] 이 최소 1번 반복, 최대 9번 반복해야 한다.
				
				// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
				Matcher m = p.matcher(id);		// userid 를 검색하고자 한다.
				
				// == 3. 판별하도록 한다. == //
				if(m.matches()) {	// boolean 타입으로 나온다.
					this.id = id;
					/*	Gujikja 나 Company 였을 경우 (아래 사항)
					super.id = userid;
					// 또는
					this.id = userid;	// 부모꺼이지만 자기껄로 오해할수 있기 때문에 super 사용 (this. 가능하지만 사용안하는 이유)
					// 또는
					id = userid;	// source 분석할때 헷가리기 때문에 위에 super 로 사용한다. (가능하지만 사용안하는 이유)
					*/
				} else {
					System.out.println("[경고] 아이디는 첫글자는 영문이어야 하고 나머지는 영문 또는 숫자로만 이루어진 글자길이는 2~10글자만 가능합니다.\n");
				}	// end of if~else----------			
			}	// end of if~else---------
		}	// end of public void setUserid(String userid)--------------------
		
		public String  getId() {
			return id;
		}	// end of public String getUserid()------------------------------
		
		// 비밀번호  ####################################################################################################################
		public void setPasswd(String passwd) {
			// 비밀번호는 영대문자, 영소문자, 숫자, 특수문자가 혼합된 최소 8글자 이상 최대 15글자 이하이어야 한다.
			if(MyUtil.isCheckPasswd(passwd)) {
				this.passwd = passwd;
			} else {
				System.out.println("[경고] 비밀번호는 영대문자, 영소문자, 숫자, 특수문자가 혼합된 최소 8글자 이상 최대 15글자 이하이어야 합니다.");
			}	// end of if~else--------------------
			for(int i=0;i<passwd.length();i++) {
				// 암호에 한글이 들어가 있는지 알아본다.
				char ch = passwd.charAt(i);
				if(ch == ' ') 
					System.out.println("[경고] 공백을 빼고 입력해주세요.\n");
			}	// end of for-----
		}	// end of public void setPasswd(String passwd)----------------
		
		public String getPasswd() {
			return passwd;
		}	// end of public String getPasswd()--------------------


		public void setName(String name) {
			// 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.
		/* 내방법
			if(2 <= name.length() && name.length() <= 6) {
				for(int i=0; i<name.length(); i++) {
					if('가'> name.charAt(i) && name.charAt(i) < '힣') {
						System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.");
						break;	// 계속 반복검사할 이유가 없다.
					}
					this.name = name;	// 가~힣 사이 글자들 
				}	// end of for-----------					
			} else {
				System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.");
			}	// end of if~else---------------
		}	// end of public void setName(String name)----------------
		*/
		// 강사님
		/*
			boolean isOnly_hangul = true;
			if(name != null) {
				char[] ch_arr = name.toCharArray();
				for(char ch : ch_arr) {		// 확장형 for 문, 개선된 for 문 
					if(!('가' <= ch && ch <= '힣')) {
						isOnly_hangul = false;
						break;
					}
				}	// end of for---------------
				if(2 <= ch_arr.length && ch_arr.length <= 6 && isOnly_hangul) {
					this.name = name;
				} else {
					System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.");
				}	// end of if~else--------------------
			}	// end of if---------------------
		}	// end of public void setName(String name)----------------
		*/
			
		// 또는 성명을 정규표현식으로 검사해보겠다.
			//public void setName(String name) {
			// 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.
			
			// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
			Pattern p = Pattern.compile("^[가-힣]{2,6}$");
			
			// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
			Matcher m = p.matcher(name);		// name 를 검색하고자 한다.
			
			// == 3. 판별하도록 한다. == //
			if(m.matches()) {	// boolean 타입으로 나온다.
				this.name = name;	
			} else {
				System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.\n");
			}	// end of if~else----------			
		}	// end of public void setName(String name)----------------
		
		public String getName() {
			return name;
		}	// end of public String getName()--------------------
		
		public String getRegister_day() {	// set 은 기본생성자에 있기 때문에 get 만 해주면 된다.
				return register_day;
			}	// end of public String getRegister_day()-----------

		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	String parent_test(){
		return "부모클래스에서 만들었어요. 그냥 연습이에요!!";
	}
}
