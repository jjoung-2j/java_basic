package day13_14.inheritance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company extends CommonMember{

	// field 생성
	private String business_number;	// 사업자등록번호
	private String job_type;		// 업종
	private long seed_money;		// 자본금

	static int count;	// Company instance 개수를 알아오려는 용도
	
	//### 사업자등록번호 ###########################################################
	// === setter === //
	public void setBusiness_number(String business_number) {
		// 사업자등록번호는 오로지 숫자만 들어와야 하며
		// 첫글자는 0이 들어올 수 없다.
		// 또한 사업자등록번호의 길이는 10글자가 되어야 한다.
		
		Pattern p = Pattern.compile("^[1-9][0-9]{9}$");
		Matcher m = p.matcher(business_number);
		if(m.matches()) {	// 유효성 검사가 통과할 경우
			this.business_number = business_number;		// 나의 객체에 있기 때문에 this
		} else {
			System.out.println("[경고] 사업자등록번호는 10자이며, 오로지 숫자만 가능합니다.\n"
					+ "또한 첫글자는 0이 들어올 수 없습니다.\n");
		}	// end of if~else----------
	}	// end of public void setBusiness_number(String business_number)-------
	// === getter === //
	public String getBusiness_number() {
		return business_number;
	}	// end of public String getBusiness_number()--------
	
	//### 업종 ##################################################################
	// === setter === // 
	public void setJob_type(String job_type) {
		if((job_type == null || job_type.isBlank())){	// 공백일 경우
			System.out.println("[경고] 회사직종군은 공백이 아닌 글자로 입력하셔야 합니다.\n");
		}
		// 공백만 아니면 모두 통과
		this.job_type = job_type;	// 나의 객체에 있기 때문에 this
	}	// end of public void setJob_type(String job_type)----------
	// === getter === //
	public String getJob_type() {
		return job_type;
	}	// end of public String getJob_type()--------
	
	//### 자본금 ##################################################################
	// === setter === // 
	public void setSeed_money(long seed_money) {
		if(seed_money <= 0)	// 0원 이하 마이너스 일 경우
			System.out.println("[경고] 자본금은 0보다 커야 합니다.");
		// 자본
		this.seed_money = seed_money;
	}	// end of public void setSeed_money(String seed_money)
	// === getter === //
	public long getSeed_money() {
		return seed_money;
	}	// end of public long getSeed_money()-----------
	
	// === 회사의 정보를 한줄로 출력해주는 메소드 생성하기 === //
	String getInfo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getName() + "\t");			// 회사명
		sb.append(getJob_type() + "\t"); 			// 업종
		sb.append(getBusiness_number() + "\t"); 	// 사업자등록번호
		sb.append(getSeed_money() + "\t");			// 자본금
		sb.append(super.getRegister_day().substring(0, 10) + "\t"); 	// 가입일자 yyyy-MM-dd 만 출력
		
		// 쌓아둔 것을 하나의 문자열로 바꾸기
		return sb.toString();
	}	// end of String getInfo()--------------
}
