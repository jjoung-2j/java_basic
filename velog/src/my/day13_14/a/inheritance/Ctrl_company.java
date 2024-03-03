	package my.day13_14.a.inheritance;
	
	import java.util.Scanner;
	
	public class Ctrl_company extends Ctrl_common{
	
		// == 구인회사(Company) 신규 회원가입시
	//	Company 클래스의 field 의 요구사항에 모두 맞으면
	//	Company[] gu_arr 에 저장시켜주는 메소드 생성하기 ==
	public void register(Scanner sc, Company[] cp_arr) {
		
		if(Company.count < cp_arr.length) {	// 지금까지 생성된 구인회사 회원수가 cp_arr.length(==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
	
			Company cp = new Company();
			
			// 아이디는 필수 입력사항이면서 아이디 조건에 맞을때 까지 반복해야 한다.
			outer:
			do {
				System.out.print("1.아이디 : ");
				String id = sc.nextLine();
				
				// == 중복 아이디 검사하기 시작 == //
				for(int i=0; i<Company.count; i++) {
					if(id.equals(cp_arr[i].getId())) {
						System.out.println(">> 이미 사용중인 아이디 이므로 다른 아이디를 입력하세요!!\n");
						continue outer;
					}	
				}	// end of for----------
				// == 중복 아이디 검사하기 끝 == //
				cp.setId(id);
				
			} while(!(cp.getId() != null));
			
			// 비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때까지 반복해야 한다.
			do {
				System.out.print("2.비밀번호 : ");
				String passwd = sc.nextLine();
				
				cp.setPasswd(passwd);
			
			} while(!(cp.getPasswd() != null));
			
			// 회사명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
			// 회사명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.
			
			do {
				System.out.print("3.회사명 : ");
				String name = sc.nextLine();
				
				cp.setName(name);
			
			} while(!(cp.getName() != null));
			
			///////////////////////////////////////////////////////////////////
			// 강사님 X / 따로 추가한 값
			do {
				System.out.print("4.업종 : ");
				String job_type = sc.nextLine();
				
				cp.setJob_type(job_type);
				
			} while(!(cp.getJob_type() != null));
			////////////////////////////////////////////////////////////////
			
			// 사업자등록번호는 필수 입력사항이면서 사업자등록번호 조건에 맞을때까지 반복해야 한다.
			
			do {
				System.out.print("5.사업자등록번호 : ");
				String business_number = sc.nextLine();
				
				cp.setBusiness_number(business_number);
			
			} while(!(cp.getBusiness_number() != null));
			
			//////////////////////////////////////////////////////
			
			
			cp_arr[Company.count++] = cp;
			
			System.out.println(">> 구인회사 회원가입 성공 !! << \n");
			
			} else {	// 지금까지 생성된 구인회사 회원수가 gu_arr.length(==>정원) 와 같거나 큰 경우에만 신규회원을 받아들이면 안된다.
			System.out.println(">>> 정원 " + cp_arr.length + "개가 꽉차서 구인회사 회원가입이 불가합니다.!! <<\n");
			}	// end of if~else--------------
	
	}	// end of public void register(Scanner sc, Company[] cp_arr)--------------------
	
	// 구인회사 로그인
	public Company login(Scanner sc, Company[] cp_arr) {
		
		System.out.print("▷ 구인회사 ID : ");
		String id = sc.nextLine();
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Company.count; i++) {
			if(id.equals(cp_arr[i].getId()) && passwd.equals(cp_arr[i].getPasswd() )) {
				return cp_arr[i];	// 메소드의 종료
			}	
		}	// end of for---------
		return null;
	}	// end of private Company login(Scanner sc, Company[] cp_arr)--------
	
	// 구인회사 전용메뉴
	public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
		
	String str_menuno = "";
	do {
		System.out.println("=== 구인회사 전용메뉴(" + login_cp.getName() + "기업 로그인 중) ===\n"
						+ "1. 회사정보 보기 2. 회사정보 수정 3. 모든 구직자 조회 4. 구직자 성별 검색 5. 구직자 연령대 검색\n"
						+ "6. 구직자 연령대 및 성별 검색 7. 채용공고 입력하기 8. 우리회사 채용공고 조회  9. 우리회사 채용공고 지원자 10. 로그아웃\n");
		System.out.print("▷ 메뉴번호 선택 : ");
		
		str_menuno = sc.nextLine();
		switch (str_menuno) {
			case "1":	// 회사정보 보기
				view_myInfo_company(login_cp);
				break;
			case "2":	// 회사정보 수정
				update_myInfo_company(sc, login_cp);
				break;
			case "3":	// 모든 구직자 조회
				view_all_gujikja_info(gu_arr);
				break;
			case "4":	// 구직자 성별 검색
				search_gender(sc,gu_arr);
				break;
			case "5":	// 구직자 연령대 검색
				search_ageLine(sc, gu_arr);
				break;
			case "6":	// 구직자 연령대 및 성별 검색
				search_ageLine_gender(sc, gu_arr);
				break;
			case "7" :	// 채용공고 입력하기
				register_recruit(sc, login_cp, rc_arr);
				break;
			case "8" :	// 우리회사 채용공고 조회
				view_recruit_mycompany(login_cp,rc_arr);
				break;
			case "9" :	// 우리회사 채용공고 지원자
				view_gujikja_my_recruitApply(login_cp, rcApply_arr);
				break;
			case "10":	// 로그아웃
				System.out.println(">> 로그아웃 되었습니다. <<\n");
				login_cp = null;		
				break;
			default:	// 보기에 없는 메뉴
				System.out.println("[경고] 검색메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
		}
	} while (!("10".equals(str_menuno)));
}	// end of public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr)

	// // 회사정보 보기
	private void view_myInfo_company(Company login_cp) {
		System.out.println(">>> " + login_cp.getName() + "님의 정보 <<<\n"
				+ "-".repeat(70)+"\n아이디\t비밀번호\t   성명\t업종 사업자등록번호 자본금\t가입일자\n"
				+ "-".repeat(70));
		System.out.println(login_cp.getId() + "  " + login_cp.getPasswd()+"   "
				+ login_cp.getName() + " " + login_cp.getJob_type() + " "
				+ login_cp.getBusiness_number() + " " + login_cp.getSeed_money() + "원  "
				+ login_cp.getRegister_day().substring(0,10));
		System.out.println();
		
	}	// end of private void view_myInfo_company(Company login_cp)-----------
	
	// 회사정보 수정
	private void update_myInfo_company(Scanner sc, Company login_cp) {
		view_myInfo_company(login_cp);
		
		// 비밀번호 변경
		String new_passwd;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("1. 비밀번호 : ");
			new_passwd = sc.nextLine();		// 변경할 경우 패스워드 입력
	
			if(!new_passwd.equals("")) {		// 입력한 비밀번호가 엔터가 아닐 경우
				
				if(new_passwd.equals(login_cp.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
					System.out.println(">> 기존 암호와 동일하므로 변경이 불가합니다.!!");
				else
					login_cp.setPasswd(new_passwd);			// 비밀번호 바꾸기
			}	
			else {
				new_passwd = login_cp.getPasswd();
			}	// end of if------------
		} while(!(login_cp.getPasswd().equals(new_passwd)));	// end of do~while----------------
	
		// 회사명 변경
		String new_name;
		do {
			System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("2. 회사명 : ");
			new_name = sc.nextLine();	// 기존 성명인 엄정화 를 엄화정 으로 변경하려고 한다.
												// 기존 성명인 엄정화 를 엄정화 으로 변경하려고 하려면 기존성명와 동일하므로 변경이 불가합니다.
												// 기존 성명인 엄정화 를 바꾸지 않으려고 한다.
												// 기존 성명인 엄정화 를 엄JungHwa 로 변경하고자 할때는 성명정책에 맞지 않으므로 안된다.!!
			
			if(!(new_name.equals(""))) {
				if(new_name.equals(login_cp.getName()))
					System.out.println("기존 회사명와 동일하므로 변경이 불가합니다.");
				else
					login_cp.setName(new_name);
			}	
			else {
				new_name = login_cp.getName();
			}	// end of if------------
		}while(!(login_cp.getName().equals(new_name)));	// end of do~while----------------
		
		// 업종 변경
		String new_job_type;
		do {
			System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("3. 업종 : ");
			new_job_type = sc.nextLine();
			if(!(new_job_type.equals(""))) {
				if(new_job_type.equals(login_cp.getJob_type()))
						System.out.println("기존 업종과 동일하므로 변경이 불가합니다.");
				else
					login_cp.setJob_type(new_job_type);
			}	
			else {
				new_job_type = login_cp.getJob_type();
			}	// end of if------------		
		} while (!(login_cp.getJob_type().equals(new_job_type)));
		
		// 사업자번호 변경
		String new_businessnum;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("4. 사업자번호 : ");
			new_businessnum = sc.nextLine();
			
			if(!new_businessnum.equals("")) {
				if(new_businessnum.equals(login_cp.getBusiness_number()))
					System.out.println(">> 기존 사업자번호와 동일하므로 변경이 불가합니다.!!");
				else
					login_cp.setBusiness_number(new_businessnum);
			}	
			else {
				new_businessnum = login_cp.getBusiness_number();
			}	// end of if------------
		}while(!(login_cp.getBusiness_number().equals(new_businessnum)));
		
		
		// 자본금 변경
		String new_seedmoney;
		boolean exit_seedmoney = false;
		do {
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
			System.out.print("5. 자본금 : ");
			try {
				new_seedmoney = sc.nextLine();
				
				if(!new_seedmoney.equals("")) {
					if(Long.valueOf(new_seedmoney).equals(login_cp.getSeed_money()))
						System.out.println(">> 기존 사업자번호와 동일하므로 변경이 불가합니다.!!");
					else
						login_cp.setSeed_money(Long.valueOf(new_seedmoney));
						exit_seedmoney = true;
				} else {
					exit_seedmoney = true;
				}	// end of if------------
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");
			}	// end of try~catch-----------
		}while(!(exit_seedmoney));
	}	// end of private void update_myInfo_company(Scanner sc, Company login_cp)
		
	// 모든 구직자 조회
	private void view_all_gujikja_info(Gujikja[] gu_arr) {
		if(Gujikja.count == 0)
			System.out.println(">> 구직자가 없습니다. << \n");
		else
			title_gujikja();
		
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<Gujikja.count; i++) {
				sb.append(gu_arr[i].getInfo() + "\n");	// sb 에 쌓기 => append
			}	// end of for-----------------
			
			System.out.println(sb.toString());
	}	// end of private void view_all_gujikja_info(Gujikja[] gu_arr)------------------
	
	// 구직자 타이틀
	private void title_gujikja() {
		
		System.out.println("=".repeat(70) +"\n"
					+ "아이디\t비밀번호\t    성명\t주민번호\t성별\t나이\t가입일자\n"
					+ "=".repeat(70));
		
	}	// end of private void title_gujikja()-------------------
	
	// 구직자 성별 검색
	private void search_gender(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		} else {	// 구직자가 존재하는 경우
			String input_gender = "";
			boolean isUse_input_gender = false;
			do {
				System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
				input_gender = sc.nextLine();		// "남" "여" "   남" "여   " "    남    " "   여   " -- 정상
													// "" "       " "강아지" --> 비정상
				switch (input_gender.trim()) {
				case "남" :
				case "여" :
					isUse_input_gender = true;
					input_gender = input_gender.trim();		// 공백을 뺀것을 넣어주기
					break;
				default:
					System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
					break;
				}	// end of switch(input_gender.trim())----------------------------
			} while(!isUse_input_gender);	// end of do~while----------------
			
			// == 입력받은 성별에 해당하는 구직자 찾기 == //
			StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
			boolean isSearch = false;
			
			for(int i=0; i<Gujikja.count; i++) {
				if(input_gender.equals(gu_arr[i].getGender())){
					isSearch = true;
					sb.append(gu_arr[i].getInfo() + "\n");
				}
			
			}	// end of for----------------
			
			if(isSearch) {
				title();
				System.out.println(sb.toString());
			}
			else {
				System.out.println("[검색결과 성별 " + input_gender+ "자 구직자는 없습니다.]");
			}
			
		}	// end of if~else-----------------------
}	// end of private void search_gender(Scanner sc, Gujikja[] gu_arr)-------
	
	// 구직자 연령대 검색
	private void search_ageLine(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		} else {	// 구직자가 존재하는 경우
			
			String str_ageLine = "";
			outer:
			do {
				System.out.print("▷ 검색하고자 하는 연령대 [예: 20] => ");
				str_ageLine = sc.nextLine();		// "0" "10" "20" "30" "40" "50" "60" "70" "80"	-- 정상
														// "25" "강아지" "-20" --> 비정상
				switch (str_ageLine) {
				case "0" :
				case "10":
				case "20":
				case "30":
				case "40":
				case "50":
				case "60":
				case "70":
				case "80":
					break outer;
				default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					continue;
				}	// end of switch(str_ageLine)----------------------------
			} while(true);	// end of do~while-------------------------------------
			
			// == 입력받은 연령대에 해당하는 구직자 찾기 == //
			StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
			boolean isSearch = false;
			
			for(int i=0; i<Gujikja.count; i++) {
				int ageLine = gu_arr[i].getAge()/10*10;
								// 나이/10*10
								// 26/10*10 ==> 20
								// 23/10*10 ==> 20
				
				if(Integer.parseInt(str_ageLine) == ageLine) {
					isSearch = true;
					sb.append(gu_arr[i].getInfo() + "\n");
				}
			}	// end of for----------------
			
			if(isSearch) {
				title();
				System.out.println(sb.toString());
			}
			else {
				System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
			}
		}	// end of if~else---------------------------
	}	// end of private void search_ageLine(Scanner sc, Gujikja[] gu_arr)-----
	
	// 리턴이 없는 void 메소드로 다른 클래스에서 불러오기 힘들기 때문에 새로 선언해준다.
	void title() {
		System.out.println("-".repeat(80)+"\n"
				+ "아이디    비밀번호          성명    생년월일    성별   현재만나이    가입일자\n"
				+ "-".repeat(80));
	}	// end of void title()------------------------------
	
	
	// 구직자 연령대 및 성별 검색
	private void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
		if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		} else {	// 구직자가 존재하는 경우
			StringBuilder sb = new StringBuilder();
			String str_ageLine = "";
			String str_gender = "";
			boolean isUse_ageLine_gender = false;
			boolean isSearch = false;
						
			outer:
			do {
				System.out.print("▷ 검색하고자 하는 연령대 [예: 20] => ");
				str_ageLine = sc.nextLine();		// "0" "10" "20" "30" "40" "50" "60" "70" "80"	-- 정상
				// "25" "강아지" "-20" --> 비정상
				switch (str_ageLine) {
					case "0" :
					case "10":
					case "20":
					case "30":
					case "40":
					case "50":
					case "60":
					case "70":
					case "80":
						isUse_ageLine_gender = true;
						break;
					default:
				System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
				break outer;
				}	// end of switch(str_ageLine)----------------------------
				
				for(int i=0; i<Gujikja.count; i++) {
					int ageLine = gu_arr[i].getAge()/10*10;
									// 나이/10*10
									// 26/10*10 ==> 20
									// 23/10*10 ==> 20
					
					if(Integer.parseInt(str_ageLine) == ageLine) {
						isSearch = true;
											// 빼도됨.	sb.append(gu_arr[i].getInfo() + "\n");
					  break; 				// 한명만 참이여도 되기때문에 break 해도 된다. //////////////////
					}
				}	// end of for----------------
				
				if (!isSearch ){
					System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
					break outer;
				}	

				System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
				str_gender = sc.nextLine();
				
				
				switch (str_gender.trim()) {
					case "남" :
					case "여" :
						isUse_ageLine_gender = true;
						str_gender = str_gender.trim();		// 공백을 뺀것을 넣어주기
						break;
					default:
						System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
						break outer;
				}	// end of switch(input_gender.trim())----------------------------
				
				// 연령대와 성별 모두 일치한 값 쌓아두기
				for(int i=0; i<Gujikja.count; i++) {
					if(str_gender.equals(gu_arr[i].getGender())){
						if(gu_arr[i].getAge()== Integer.parseInt(str_ageLine))
							isSearch = true;
							sb.append(gu_arr[i].getInfo() + "\n");
					}
				
				}	// end of for----------------
				isSearch = false;
				if(isSearch) {	// 쌓아둔 값 추출하기
					title();
					System.out.println(sb.toString());
				}
				else {
					System.out.println("[검색결과 성별 " + str_gender+ "자 구직자는 없습니다.]");
					System.out.println();
				}
			} while (!isUse_ageLine_gender);	// end of do~while----------------------
		}	// end of if~else-------------------------
	}	// end of private void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr)------
	
	// == 채용공고 입력하기 ==
	private void register_recruit(Scanner sc, Company login_cp, Recruit[] rc_arr) {
		
		System.out.println("======= " + login_cp.getName() + " 채용공고 등록 =======");
		Recruit rc = new Recruit();		// rc 에 채용공고 등록
		
		do {
			System.out.print("1. 채용제목 : ");
			String subject = sc.nextLine();
			rc.setSubject(subject);
		} while (!(rc.getSubject() != null));	// null 이 아니라는 것은 올바르게 들어갔다는 말이다.
		
		do {
			System.out.print("2. 채용분야[예> 사무직] : ");
			String work_type = sc.nextLine();
			rc.setWork_type(work_type);
		} while (!(rc.getWork_type() != null));	// null 이 아니라는 것은 올바르게 들어갔다는 말이다.
		
		do {
			System.out.print("3. 채용인원 : ");
			String str_cnt = sc.nextLine();
			
			try {
				int cnt = Integer.parseInt(str_cnt);
				if(cnt <= 0)
					System.out.println("[경고] 1 이상 입력하세요");
				else
					rc.setCnt(cnt);
			} catch(NumberFormatException e) {	// 숫자를 입력하지 않은 경우
				System.out.println("[경고] 1 이상 입력하세요");
			}	// end of try~catch---------------
			
		} while (!(rc.getCnt() > 0));	// 입력이 되지 않은 경우, 초기값이 0 이기 때문에 0 보다 커야한다.
		
		do {
			System.out.print("4. 연봉[단위 만원] : ");
			String str_yearpay = sc.nextLine();
			
			try {
				int yearpay = Integer.parseInt(str_yearpay);
				if(yearpay <= 0)
					System.out.println("[경고] 1 이상 입력하세요");
				else
					rc.setYearpay(yearpay);
			} catch(NumberFormatException e) {	// 숫자를 입력하지 않은 경우
				System.out.println("[경고] 1 이상 입력하세요");
			}	// end of try~catch---------------
			
		} while (!(rc.getYearpay() > 0));	// 입력이 되지 않은 경우, 초기값이 0 이기 때문에 0 보다 커야한다.
		
		do {
			System.out.print("5. 채용마감일자[예{> 20240208] : ");
			String finish_day = sc.nextLine();
			rc.setFinish_day(finish_day);
		} while (!(rc.getFinish_day() != null));	// null 이 아니라는 것은 올바르게 들어갔다는 말이다.
		
		rc.setCp(login_cp);
		
		rc_arr[Recruit.count++] = rc;
		
		System.out.println("");
		
	}	// end of private void register_recruit(Scanner sc, Company login_cp)-----------
	
	// == 우리회사 채용공고 조회 == 
	private void view_recruit_mycompany(Company login_cp, Recruit[] rc_arr) {
		
		boolean is_existence = false;
		
		for(int i=0; i<Recruit.count; i++) {
			if(rc_arr[i].getCp().getId().equals(login_cp.getId())) {	// login_cp.getId().equals(rc_arr[i].getCp().getId()) 와 동일
				is_existence = true;	// 동일한 것을 발견했을 경우
				System.out.println(rc_arr[i].recruit_info()); 			// 채용정보를 보여주는 메소드
			}
		}	// end of for--------------
		if(!is_existence)
			System.out.println(">> 채용공고를 낸 것이 없습니다.<<\n");
	}	// end of private void view_recruit_mycompany(Company login_cp, Recruit[] rc_arr)---------
	
	// == 우리회사 채용공고 지원자 조회 ==
	private void view_gujikja_my_recruitApply(Company login_cp, RecruitApply[] rcApply_arr) {
		boolean is_existence = false;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<RecruitApply.count; i++) {
			if(login_cp.getId().equals(rcApply_arr[i].getRc().getCp().getId()))	{	// 채용지원 -> 어디 지원하는 지(채용정보) -> 회사 -> 회사 아이디
				is_existence = true;	// 지원자가 있을 경우
				sb.append(rcApply_arr[i].getRc().getRecruit_no() + "\t");	// 채용공고번호
				sb.append(rcApply_arr[i].getRc().getSubject() + "\t");		// 채용제목
				sb.append(rcApply_arr[i].getGu().getName() + "\t");			// 지원자명
				sb.append(rcApply_arr[i].getGu().getGender() + "\t");		// 성별
				sb.append(rcApply_arr[i].getGu().getAge() + "\t");			// 나이
				sb.append(rcApply_arr[i].getApply_motive() + "\n");			// 지원동기
			}
		}	// end of for-----------
		if(is_existence) {
			System.out.println("=".repeat(100) + "\n" + "채용공고번호 채용제목\t\t지원자명  성별  나이\t지원동기" + "\n" + "=".repeat(100));
			System.out.println(sb.toString());
		} else {	// !is_existence
			System.out.println(">> 채용공고에 지원자가 없습니다. <<\n");
		}
	}	// end of private void view_gujikja_my_recruitApply(Company login_cp, RecruitApply[] rcApply_arr)--------
	
	}
