package day13_14.inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecruitApply {

	// field 
		private Recruit rc;           // 채용정보
		private Gujikja gu;           // 구직자 
		private String apply_motive;  // 지원동기
		private String register_day;  // 등록일자
		
		static int count;  // RecruitApply 객체(인스턴스)의 개수를 알아오려는 용도 
		
		// 기본생성자
		public RecruitApply() {
			Date now = new Date(); // 현재시각
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");		// 보기쉬운 형태로 변환하기
			register_day = df.format(now);								// 변환하고 싶은 값 넣어서 바꾸어주기
		}

		// method 
		// === getter, setter === //
		// ==  채용정보 == //
		public Recruit getRc() {
			return rc;
		}
		public void setRc(Recruit rc) {
			if(rc != null) 	// 값이 없지 않다면
				this.rc = rc;
			else 	// 값이 없다면
				System.out.println("[경고] 채용에 응모하려면 반드시 채용정보를 입력하세요!!\n"); 
		}	// end of public void setRc(Recruit rc)-------------------
		
	//==========================================================================
		// == 구직자 == //
		public Gujikja getGu() {
			return gu;
		}
		public void setGu(Gujikja gu) {
			if(gu != null) 	// 값이 없지 않다면
				this.gu = gu;
			else 	// 값이 없다면
				System.out.println("[경고] 채용에 응모하려면 반드시 구직자정보를 입력하세요!!\n");
		}	// end of public void setGu(Gujikja gu)------------------------

	//==========================================================================
		// == 지원동기 == //
		public String getApply_motive() {
			return apply_motive;
		}
		public void setApply_motive(String apply_motive) {
			if(apply_motive != null && !apply_motive.isBlank()) 	// 값이 없지 않고 공백이 아니라면
				this.apply_motive = apply_motive;	
			else 	// 값이 없거나 공백이라면
				System.out.println("[경고] 입사지원동기를 필수로 입력해야 합니다.!!\n");
		}	// end of public void setApply_motive(String apply_motive)----------

	//==========================================================================	
		// == 등록일자 == //
		public String getRegister_day() {
			return register_day;
		}
		// setter -> 기본생성자 안에 명시되어 있다.
}
