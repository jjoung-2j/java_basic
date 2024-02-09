package day13_14.inheritance;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recruit {

	// field
	private int recruit_no;			// 채용공고순번
	private Company cp;				// 회사
	private String subject;			// 채용제목
	private String work_type;		// 모집분야(근무형태)
	private int cnt;				// 모집인원
	private int yearpay;			// 연봉
	private String register_day;	// 모집공고 등록일자
	private String finish_day;		// 모집 마감일자
	
	static int count;	// Recruit instance 개수를 알아오려는 용도
	
	// 기본생성자
	public Recruit() {
		recruit_no = count + 1;				// recruit_no 의 setter
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");	// 보기쉬운 형태로 변환하기
		register_day = df.format(now);		// register_day 의 setter
	}
	
	// method
	// === getter, setter === //
	// == 채용공고순서 == //
	public int getRecruit_no() {
		return recruit_no;
	}
	// setRecruit 는 기본생성자에서 설정하였기에 따로 실행할 필요가 없다.
	
//==========================================================================
	// == 회사 == //
	public Company getCp() {
		return cp;
	}
	public void setCp(Company cp) {
		if(cp != null)		// cp의 값이 없지 않다면
			this.cp = cp;
		else				// cp의 값이 없다면
			System.out.println("[경고] 채용하려면 반드시 회사정보를 입력하세요!!\n");
	}	// end of public void setCp(Company cp)---------------------------
	
//==========================================================================	
	// == 채용제목 == //
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		if(subject != null && !subject.isBlank())	// subject 의  값이 없지 않거나, 공백이 아니라면
			this.subject = subject;
		else		// subject 의 값이 없다면
			System.out.println("[경고] 채용제목을 필수로 입력해야 합니다.!!\n");
	}	// end of public void setSubject(String subject)----------------
	
//==========================================================================
	// == 모집분야 == //
	public String getWork_type() {
		return work_type;
	}
	
	public void setWork_type(String work_type) {
		if(work_type != null && !work_type.isBlank())	// work_type 의  값이 없지 않거나, 공백이 아니라면
			this.work_type = work_type;
		else		// work_type 의 값이 없다면
			System.out.println("[경고] 채용분야(근무형태)를 필수로 입력해야 합니다.!!\n");
	}	// end of public void setWork_type(String work_type)---------------------
	
//==========================================================================
	// == 모집인원 == //
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		if(cnt > 0)		// 모집인원이 0 보다 높다면
			this.cnt = cnt;
		else			// 모집인원이 0 이하라면
			System.out.println("[경고] 채용인원수는 1명 이상이어야 합니다.!!\n");
	}	// end of public void setCnt(int cnt)------------------------------
	
//==========================================================================	
	// == 연봉 == //
	public int getYearpay() {
		return yearpay;
	}
	public void setYearpay(int yearpay) {
		if(yearpay > 0)		// 연봉이 0 보다 높다면
			this.yearpay = yearpay;
		else				// 연봉이 0 이하라면
			System.out.println("[경고] 연봉은 1 이상이어야 합니다.!!\n");
	}	// end of public void setYearpay(int yearpay)----------------
	
//==========================================================================	
	// == 모집공고 등록일자 == //
	public String getRegister_day() {
		return register_day;
	}
	// setRegister_day 는 기본생성자에서 설정하였기에 따로 실행할 필요가 없다.	
	
//==========================================================================
	// == 모집 마감일자 == //
	public String getFinish_day() {
		return finish_day;
	}
	public void setFinish_day(String finish_day) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");		// 보기쉬운 형태로 변환하기
		df.setLenient(false);		// false 로 해주어야 => 날짜로 되지 못하는값이 있을 때, 오류 발생
		try {
			// 채용공고 등록일자 문자열타입 -> 날짜 타입으로 변환
			Date date_register_day = df.parse(register_day);
			// 채용공고 마감일자 문자열타입 -> 날짜 타입으로 변환
			Date date_finish_day = df.parse(finish_day);
			
			if(date_finish_day.after(date_register_day)){// date_finish_day(미래) > date_register_day 라면
				this.finish_day = finish_day;
			} else {
				System.out.println("[경고] 채용마감일자는 현재일자보다 이후인 날짜이어야 합니다.\n");
			}
		} catch(ParseException e) {	// 날짜로 변환할 수 없는 것에 대한 오류
			System.out.println("[경고] 채용마감일자는 달력에 존재하는 날짜이어야 합니다.\n");
		}	// end of try~catch-----------------------------
	}	// end of public void setFinish_day(String finish_day)---------------------------
	
//==========================================================================	
	
	// == 채용정보를 알려주는 메소드 == //
	public String recruit_info() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("=".repeat(50)+"\n");
		sb.append("1.채용번호 : "+ recruit_no +"\n");
		sb.append("2.채용제목 : "+ subject +"\n");
		sb.append("3.채용분야 : "+ work_type +"\n");
		sb.append("4.채용인원 : "+ cnt +"\n");
		sb.append("5.연봉 : "+ new DecimalFormat("#,###").format(yearpay) +"만원\n"); 
		sb.append("6.등록일자 : "+ register_day.substring(0, 4)+"-"+register_day.substring(4, 6)+"-"+register_day.substring(6) +"\n");   
		sb.append("7.채용마감일자 : "+ finish_day.substring(0, 4)+"-"+finish_day.substring(4, 6)+"-"+finish_day.substring(6) +"\n");
		sb.append("=".repeat(50)+"\n");
		
		return sb.toString();
	}// end of public String recruit_info()------------------------

}
