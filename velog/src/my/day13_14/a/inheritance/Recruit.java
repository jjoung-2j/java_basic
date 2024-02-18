package my.day13_14.a.inheritance;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recruit {

	// field
	private int recruit_no;			// 채용공고순번
	private Company cp;				// 회사
	private String subject;			// 채용제목
	private String work_type;		// 채용분야(근무형태)
	private int cnt;				// 채용인원
	private int yearpay;			// 연봉
	private String register_day;	// 채용공고 등록일자
	private String finish_day;		// 채용 마감일자
	
	static int count;	// Recruit 객체(인스턴스)의 개수를 알아오려는 용도
	
	// 기본생성자
	public Recruit() {
		// rc_arr[Recruit.count++] = rc1;		count 는 등록할때 ++ 로 1로바뀜
		recruit_no = count + 1;		// 등록하기 전부터 1이여야 되기때문에 지금 +1
		
		Date now = new Date();	// 현재시각
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		register_day = df.format(now);
	}

	// method
	// 채용공고순번
	public int getRecruit_no() {
		return recruit_no;
	}
	
	// 회사
	public Company getCp() {
		return cp;
	}

	public void setCp(Company cp) {
		if(cp != null) {	// 비어있으면 안된다! => != null
			this.cp = cp;
		} else {
			System.out.println("[경고] 채용하려면 반드시 회사정보를 입력하세요!!\n");
		}	// end of if~else------------
	}	// end of public void setCp(Company cp)-------------------------------
	
	// 채용제목
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		if(subject != null) {	// 비어있으면 안된다! => != null
			this.subject = subject;
		} else {
			System.out.println("[경고] 채용제목을 필수로 입력해야 합니다.\n");
		}	// end of if~else-------
	}	// end of public void setSubject(String subject)-------------------

	// 채용분야
	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		if(work_type != null) {
			this.work_type = work_type;
		} else {
			System.out.println("[경고] 채용분야(근무형태)를 필수로 입력해야 합니다.\n");
		}	// end of if~else-----------------------
	}	// end of public void setWork_type(String work_type)----------------------

	// 채용인원
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		if(cnt > 0)
			this.cnt = cnt;
		else
			System.out.println("[경고] 채용인원수는 1명 이상이어야 합니다.\n");
	}	// end of public void setCnt(int cnt)-------------------------------
	
	// 연봉
	public int getYearpay() {
		return yearpay;
	}

	public void setYearpay(int yearpay) {
		if(cnt > 0)
			this.yearpay = yearpay;
		else
			System.out.println("[경고] 연봉은 1 이상이어야 합니다.\n");
	}	// end of public void setYearpay(int yearpay)----------------

	// 등록일자
		public String getRegister_day() {
			return register_day;
		}

	// 마감일자
	public String getFinish_day() {
		return finish_day;
	}

	public void setFinish_day(String finish_day) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		df.setLenient(false); 	// 유효한 날짜인지 아닌지 확인
		// false 로 해주어야만 입력한 값을 날짜 타입으로 변경할때 날짜로 되지 못하는 값일 경우 오류가 발생한다.
	    // 날짜로 파싱될 때 허술하게 하지 말고 엄격하게 하라고 설정해주는 것이라고 생각하면 된다.  
		try {
			Date date_register_day = df.parse(register_day);		// 마감일자가 등록일자보다 이전이면 안되니까 비교하기 위해 Date 타입으로 바꿔주기
			// 채용공고 등록일자 문자열값을 날짜 타입으로 변환
			
			Date date_finish_day = df.parse(finish_day);			// String 타입을 Date 타입으로 변경해주는 것
			// 채용마감 일자 문자열값을 날짜 타입으로 변환
			
			if(date_finish_day.after(date_register_day))			// 마감일자(미래) > 등록일자 => 참
				this.finish_day = finish_day;
			else
				System.out.println("[경고] 채용마감일자는 현재일자 보다 이후인 날짜이어야 한다.\n");
		} catch(ParseException e) {	// 날짜로 변경이 불가능할 경우
			System.out.println("[경고] 채용마감일자는 달력에 존재하는 날짜이어야 합니다.\n");	
		}	// end of try~catch--------
	}	// end of public void setFinish_day(String finish_day)------------

	// == 채용정보를 알려주는 메소드 == //
	public String recruit_info() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("=".repeat(50)+"\n");
		sb.append("1. 채용번호 : " + recruit_no  + "\n");
		sb.append("2. 채용제목 : " + subject + "\n");
		sb.append("3. 채용분야 : " + work_type + "\n");
		sb.append("4. 채용인원 : " + cnt + "\n");
		sb.append("5. 연   봉 : " + new DecimalFormat("#,###").format(yearpay) + "만원\n");		// yearpay(연봉) int 타입 3자리 마다 콤마
		sb.append("6. 등록일자 : " + register_day.substring(0, 4) +"-" 		// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
								+ register_day.substring(4, 6) +"-" 
								+ register_day.substring(6) + "\n");	
		
		sb.append("7. 마감일자 : " + finish_day.substring(0, 4) +"-" 			// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
								+ finish_day.substring(4, 6) +"-" 
								+ finish_day.substring(6) + "\n");
		sb.append("=".repeat(50)+"\n");
		return sb.toString();
	}	// end of public String recruit_info()-----------------

	
	
}
