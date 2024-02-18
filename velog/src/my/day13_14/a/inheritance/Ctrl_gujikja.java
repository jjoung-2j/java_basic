package my.day13_14.a.inheritance;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ctrl_gujikja extends Ctrl_common{
	
	
	// == 구직자(Gujikja) 신규 회원가입시
	//	Gujikja 클래스의 field 의 요구사항에 모두 맞으면
	//	Gujikja[] gu_arr 에 저장시켜주는 메소드 생성하기 ==
	void register(Scanner sc, Gujikja[] gu_arr) {
		
		if(Gujikja.count < gu_arr.length) {	// 지금까지 생성된 구직자 회원수가 gu_arr.length(==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
			
			Gujikja gu = new Gujikja();
			
			// 아이디는 필수 입력사항이면서 아이디 조건에 맞을때 까지 반복해야 한다.
			outer:
			do {
				System.out.print("1.아이디 : ");
				String id = sc.nextLine();
				
				// == 중복 아이디 검사하기 시작 == //
				for(int i=0; i<Gujikja.count; i++) {
					if(id.equals(gu_arr[i].getId())) {
						System.out.println(">> 이미 사용중인 아이디 이므로 다른 아이디를 입력하세요!!\n");
						continue outer;
					}	
				}	// end of for----------
				// == 중복 아이디 검사하기 끝 == //
				gu.setId(id);
				
			} while(!(gu.getId() != null));
			
			// 비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때까지 반복해야 한다.
			do {
				System.out.print("2.비밀번호 : ");
				String passwd = sc.nextLine();
				
				gu.setPasswd(passwd);

			} while(!(gu.getPasswd() != null));
			
		// 성명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
		// 성명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.

			do {
				System.out.print("3.성명 : ");
				String name = sc.nextLine();
				
				gu.setName(name);

			} while(!(gu.getName() != null));
		
		// 주민번호는 필수 입력사항이면서 주민번호 조건에 맞을때까지 반복해야 한다.

			do {
				System.out.print("4.주민번호 : ");
				String jubun = sc.nextLine();
				
				gu.setJubun(jubun);

			} while(!(gu.getJubun() != null));
		
			//////////////////////////////////////////////////////
			
			
		gu_arr[Gujikja.count++] = gu;
		
		System.out.println(">> 구직자 회원가입 성공 !! << \n");
		
		} else {	// 지금까지 생성된 구직자 회원수가 gu_arr.length(==>정원) 와 같거나 큰 경우에만 신규회원을 받아들이면 안된다.
			System.out.println(">>> 정원 " + gu_arr.length + "명이 꽉차서 구직자 회원가입이 불가합니다.!! <<\n");
		}
		
	}	// end of void register(Scanner sc, Gujikja[] gu_arr)-------------

	// === 구직자 모두보기 메소드 ===
	public void view_all_info(Gujikja[] gu_arr) {
		
		/*
			------------------------------------------------------------------------
			아이디    비밀번호     성명    생년월일    성별   현재만나이    가입일자
			------------------------------------------------------------------------
			eomjh	qWe******  엄정화  961002     여       27      2024-01-31 10:30:40
			leess	abC******* 이순신  960120     남       28      2024-01-31 10:30:40
			chaew	aSd******  차은우  010620     남       22      2024-01-31 10:30:40
			------------------------------------------------------------------------
		 */
		
		if(Gujikja.count == 0) {
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. \n");
		} else {
			title();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<Gujikja.count;i++) {
				sb.append(gu_arr[i].getInfo()+"\n");	//sb.append 는 쌓아두는 것, gu_arr[i] 의 정보를 getInfo메소드에 담기
			}	// end of for-----------------
		
			System.out.println(sb.toString()); 	// String 타입으로 바꾼것을 찍어라
		}	// end of if---------
		
	}	// end of public void view_all_info(Gujikja[] gu_arr)
	
	void title() {
		System.out.println("-".repeat(80)+"\n"
				+ "아이디    비밀번호          성명    생년월일    성별   현재만나이    가입일자\n"
				+ "-".repeat(80));
	}	// end of void title()------------------------------

	// 검색하기 메뉴를 보여주는 메소드 생성하기 == // 
	void search_menu(Scanner sc, Gujikja[] gu_arr) {
		String str_menuno = "";		// 지역변수이면 while 문 조건에 사용할 수 없으니 밖으로 뺀다.
		do {
			System.out.println("\n === 검색메뉴 ===\n"
								+ "1. 연령대검색  2. 성별검색  3.연령대 및 성별 검색하기  4.메인메뉴로 돌아가기\n");
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();
			
			switch (str_menuno) {
			case "1":	// 연령대 검색
				search_ageLine(sc,gu_arr);
				break;
			case "2":	// 성별검색
				search_gender(sc,gu_arr);
				break;
			case"3":	// 연령대 및 성별 검색하기
				search_ageLine_gender(sc,gu_arr);
				break;
			case"4":	// 메인메뉴로 돌아가기
				break;
			default:
				System.out.println("[경고] 검색메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
			}	// end of switch(str_menuno)------------------
		 } while(!("4".equals(str_menuno)));
	}	// end of public void search_menu(Scanner sc, Gujikja[] gu_arr)----------------



	// === 연령대 검색해주는 메소드 == //
	void search_ageLine(Scanner sc, Gujikja[] gu_arr) {
		
		if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		} else {	// 구직자가 존재하는 경우
			
			String str_ageLine = "";
			// 강사님
			boolean isUse_ageLine = false;
			// 내방법
			// outer:
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
					isUse_ageLine = true;
					break;
					// 내방법
					// break outer;
				default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					break;
					// 내방법
					// continue;
				}	// end of switch(str_ageLine)----------------------------
			} while(!isUse_ageLine);	// end of do~while----------------
			// 내방법
			//} while(true);	// end of do~while-------------------------------------
			
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
	}	// end of void search_ageLine(Scanner sc, Gujikja[] gu_arr)-------------------
	
	// == 성별 검색해주는 메소드 == //
		void search_gender(Scanner sc, Gujikja[] gu_arr) {
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
			
		}	// end of void search_gender(Scanner sc, Gujikja[] gu_arr)
		
		// == 연령대 및 성별 검색해주는 메소드 == //
		/*
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
		*/
		////////////////////////////////////////////////////////////////////////////////////
		// 강사님
		
		// == 연령대 및 성별 검색해주는 메소드 == //
		void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
			
			if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
				System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
				// return;		// 해당 메소드 종료(확인사살)
			} else {	// 구직자가 존재하는 경우
				
				String str_ageLine = "";
				boolean isUse_ageLine = false;
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
						isUse_ageLine = true;
						break;

					default:
						System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
						break;

					}	// end of switch(str_ageLine)----------------------------
				} while(!isUse_ageLine);	// end of do~while----------------
				
				// == 입력받은 연령대에 해당하는 구직자 찾기 == //
				boolean is_ageline_Search = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					int ageLine = gu_arr[i].getAge()/10*10;
									// 나이/10*10
									// 26/10*10 ==> 20
									// 23/10*10 ==> 20
					
					if(Integer.parseInt(str_ageLine) == ageLine) {
						is_ageline_Search = true;
						break;						// 연령대에 1명만 있는게 중요하기 때문에 나가도 된다.
					}
				}	// end of for----------------
				
				if(!is_ageline_Search) {	// 검색하고자 하는 연령대에 해당하는 구직자가 존재하지 않는 경우
					System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
				}
				else {	// 검색하고자 하는 연령대에 해당하는 구직자가 존재하는 경우
					
					// === !! 성별 검색에 시작 !! === // 
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
					
					// == 입력받은 연령대 및 성별에 해당하는 구직자 찾기 == //
					StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
					boolean is_ageline_gender_Search = false;
					
					for(int i=0; i<Gujikja.count; i++) {
						if(Integer.parseInt(str_ageLine) == gu_arr[i].getAge()/10*10 
							&& input_gender.equals(gu_arr[i].getGender())){
							is_ageline_gender_Search = true;
							sb.append(gu_arr[i].getInfo() + "\n");
						}
					}	// end of for----------------
					
					if(is_ageline_gender_Search) {
						title();
						System.out.println(sb.toString());
					}
					else {
						System.out.println("[검색결과 연령대가 " +str_ageLine + "대인 " + input_gender+ "자 구직자는 없습니다.]\n");
					}
					// === !! 성별 검색 끝 !! === //
				}	// end of if~else-----------------------
				
				// 회원명수, 회원정보 등 입력하는 경우가 else 뒤에 있을경우 확인사살로 if 에 return 을 적어줘야한다.
				
			}	// end of if~else----------			
			
		}	// end of void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr)

		// 구직자 로그인 메소드 생성하기 //
		public Gujikja login(Scanner sc, Gujikja[] gu_arr) {
			
			System.out.print("▷ 구직자 ID : ");
			String id = sc.nextLine();
			
			System.out.print("▷ 구직자 비밀번호 : ");
			String passwd = sc.nextLine();
			
			for(int i=0; i<Gujikja.count; i++) {
				if(id.equals(gu_arr[i].getId()) && passwd.equals(gu_arr[i].getPasswd())) {
					return gu_arr[i];
				}
			}	// end of for--------------
			
			return null;	// 아이디와 비밀번호가 맞지 않는 경우
		}	// end of public Gujikja login(Scanner sc, Gujikja[] gu_arr)-----------

		// == 구직자 전용메뉴 메소드 생성하기 == //
		public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
			String str_menuno;
			do {
				System.out.println("\n === 구직자 전용메뉴(" + login_gu.getName() + "님 로그인중) ===\n"
						+ "1. 내정보 보기  2. 내정보 수정 3. 모든 구인회사 조회 4. 구인회사 검색하기\n"
						+ "5. 모든 채용공고 조회 6. 채용 지원하기 7. 지원한 채용공고 조회 8. 로그아웃\n");
				System.out.print("▷ 메뉴번호 선택 : ");
				str_menuno = sc.nextLine();
				
				switch (str_menuno) {
				case "1":	// 내정보 보기
					view_myInfo(login_gu);
					break;
				case "2":	// 내정보 수정
					update_myInfo(sc, login_gu);
					break;
				case "3":	// 모든 구인회사 조회
					view_all_company_info(cp_arr);
					break;
				case "4":	// 구인회사 검색하기
					search_company(sc,cp_arr);
					break;
				case "5":	// 모든 채용공고 조회
					view_all_recruit_info(rc_arr);
					break;
				case "6":	// 채용 지원하기
					input_recruitApply(sc, login_gu, rc_arr, rcApply_arr);
					break;
				case "7":	// 지원한 채용공고 조회
					view_my_recruitApply(login_gu, rcApply_arr);
					break;
				case "8":	// 로그아웃
					System.out.println(">> 로그아웃 되었습니다. <<\n");
					login_gu = null;		// 로그인 되어진 사람을 없애주어야한다.
					break;
				default:
					System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다.");
					break;
				}	// end of switch (str_menuno)------------------------------
			} while(!("8".equals(str_menuno)));	// end of do~while------------------------
		}	// end of public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr)------------

		/*
			>>> 엄정화님의 정보 <<<
			------------------------------
			아이디  비밀번호    성명   주민번호
			------------------------------
			eomjh qWer1234$ 엄정화 8610202
			
		 */
		// 내정보 보기
		private void view_myInfo(Gujikja login_gu) {
			System.out.println(">>> " + login_gu.getName() + "님의 정보 <<<\n"
					+ "-".repeat(40)+"\n아이디\t비밀번호\t   성명\t주민번호\n"+ "-".repeat(40));
			System.out.println(login_gu.getId() + " ".repeat(3) + login_gu.getPasswd()+" ".repeat(1)
					+ login_gu.getName() + " ".repeat(2) + login_gu.getJubun());
		}	// end of private void view_myInfo(Gujikja login_gu)---------------------
		
		// 내정보 수정
		private void update_myInfo(Scanner sc, Gujikja login_gu) {
			view_myInfo(login_gu);
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/* 내방법
			String new_passwd;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("1. 비밀번호 : ");
				new_passwd = sc.nextLine();	// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 하려면 기존암호와 동일하므로 변경이 불가합니다.
													// 기존 비밀번호인 qWer1234$ 을 바꾸지 않으려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 abcd 로 변경하고자 할때는 비밀정책에 맞지 않으므로 안된다.!!
				
				if(!new_passwd.equals("")) {		// 입력한 비밀번호가 엔터가 아닐 경우
					// System.out.println("엔터이군요");
					
					if(new_passwd.equals(login_gu.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
						System.out.println(">> 기존암호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setPasswd(new_passwd);			// 비밀번호 바꾸기
				}	
				else {
					new_passwd = login_gu.getName();
				}	// end of if------------
			} while(!(login_gu.getPasswd().equals(new_passwd)));	// end of do~while----------------
			*/
			
			// 강사님
			boolean exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("1. 비밀번호 : ");
				String new_passwd = sc.nextLine();	// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 하려면 기존암호와 동일하므로 변경이 불가합니다.
													// 기존 비밀번호인 qWer1234$ 을 바꾸지 않으려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 abcd 로 변경하고자 할때는 비밀정책에 맞지 않으므로 안된다.!!
				
				if(!new_passwd.equals("")) {		// 입력한 비밀번호가 엔터가 아닐 경우
					// System.out.println("엔터이군요");
					
					if(new_passwd.equals(login_gu.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
						System.out.println(">> 기존암호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setPasswd(new_passwd);			// 비밀번호 바꾸기
						if(login_gu.getPasswd().equals(new_passwd)) {	// 암호가 바뀔경우
							exit_ok = true;
						}
						// 암호를 틀리게 입력한 경우 else
				}	
				else {	// 입력한 비밀번호가 엔터일 경우
					exit_ok = true;
				}
			} while (!exit_ok);	// end of do~while----------------
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/* 내방법
			String new_name;
			do {
				System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("2. 성명 : ");
				new_name = sc.nextLine();	// 기존 성명인 엄정화 를 엄화정 으로 변경하려고 한다.
													// 기존 성명인 엄정화 를 엄정화 으로 변경하려고 하려면 기존성명와 동일하므로 변경이 불가합니다.
													// 기존 성명인 엄정화 를 바꾸지 않으려고 한다.
													// 기존 성명인 엄정화 를 엄JungHwa 로 변경하고자 할때는 성명정책에 맞지 않으므로 안된다.!!
				
				if(!(new_name.equals(""))) {
					if(new_name.equals(login_gu.getName()))
						System.out.println("기존성명와 동일하므로 변경이 불가합니다.");
					else
						login_gu.setName(new_name);
				}	
				else {
					new_name = login_gu.getName();
				}	// end of if------------
			}while(!(login_gu.getName().equals(new_name)));	// end of do~while----------------
			*/
			
			// 강사님
			exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("2. 성명 : ");
				String new_name = sc.nextLine();	// 기존 성명인 엄정화 를 엄화정 으로 변경하려고 한다.
													// 기존 성명인 엄정화 를 엄정화 으로 변경하려고 하려면 기존성명와 동일하므로 변경이 불가합니다.
													// 기존 성명인 엄정화 를 바꾸지 않으려고 한다.
													// 기존 성명인 엄정화 를 엄JungHwa 로 변경하고자 할때는 성명정책에 맞지 않으므로 안된다.!!
				
				if(!new_name.equals("")) {
					if(new_name.equals(login_gu.getPasswd()))
						System.out.println(">> 기존성명와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setName(new_name);
						if(login_gu.getName().equals(new_name)) {
							exit_ok = true;
						}
				}	// end of if------------
				else {
					exit_ok = true;
				}
			}while(!exit_ok);
	
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/* 내방법
			String new_jubun;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("3. 주민번호 : ");
				new_jubun = sc.nextLine();	// 기존 주민번호인 8610202 를 8808081 으로 변경하려고 한다.
													// 기존 주민번호인 8610202 를 8610202 으로 변경하려고 하려면 기존 주민번호와 동일하므로 변경이 불가합니다.
													// 기존 주민번호인 8610202 를 바꾸지 않으려고 한다.
													// 기존 주민번호인 8610202 를 엄JungHwa 로 변경하고자 할때는 주민번호 정책에 맞지 않으므로 안된다.!!
				
				if(!new_jubun.equals("")) {
					if(new_jubun.equals(login_gu.getJubun()))
						System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setJubun(new_jubun);
				}	
				else {
					new_jubun = login_gu.getJubun();
				}	// end of if------------
			}while(!(login_gu.getJubun().equals(new_jubun)));
			*/
			
			// 강사님
			exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("3. 주민번호 : ");
				String new_jubun = sc.nextLine();	// 기존 주민번호인 8610202 를 8808081 으로 변경하려고 한다.
													// 기존 주민번호인 8610202 를 8610202 으로 변경하려고 하려면 기존 주민번호와 동일하므로 변경이 불가합니다.
													// 기존 주민번호인 8610202 를 바꾸지 않으려고 한다.
													// 기존 주민번호인 8610202 를 엄JungHwa 로 변경하고자 할때는 주민번호 정책에 맞지 않으므로 안된다.!!
				
				if(!new_jubun.equals("")) {
					if(new_jubun.equals(login_gu.getJubun()))
						System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setJubun(new_jubun);
						if(login_gu.getJubun().equals(new_jubun)) {
						exit_ok = true;
						}
				}	
				else {
					exit_ok = true;
				}	// end of if------------
			} while (!exit_ok);
		}	// end of private void update_myInfo(Scanner sc, Gujikja login_gu)----------------------
		
		// 모든 구인회사 조회
		private void view_all_company_info(Company[] cp_arr) {
			
			if(Company.count == 0)
				System.out.println(">> 구인회사로 등록된 회사가 없습니다. << \n");
			else
				title_company();
			
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<Company.count; i++) {
					sb.append(cp_arr[i].getInfo() + "\n");	// sb 에 쌓기 => append
				}	// end of for-----------------
				
				System.out.println(sb.toString());
			
		}	// end of private void view_all_company_info(Company[] cp_arr)-----------------------
		
		// 구인회사 검색하기
		private void search_company(Scanner sc, Company[] cp_arr) {
			
			boolean exit = false;
			do {
				System.out.println(">>> 구인회사 검색메뉴 <<<\n"
								+ "1. 업종검색 2. 자본금검색 3. 구직자메뉴로 돌아가기");
				System.out.print("▷ 검색메뉴번호 입력 : ");
				
				int search_num = Integer.parseInt(sc.nextLine());
				
				switch (search_num) {
				case 1:	// 업종검색
					search_jobtype(sc,cp_arr);
					break;
				case 2:	// 자본금검색
					search_seedmoney(sc,cp_arr);	// 강사님꺼적용
					break;
				case 3:	// 구직자메뉴로 돌아가기
					exit = true;
					break;
				default:	// 다른것을 입력할 경우
					System.out.println("[경고]메뉴에 있는 번호를 입력해주세요.");
					break;
				}

			} while (!exit);
			
		}	// end of private void search_company(Scanner sc, Company[] cp_arr)

		// 회사 타이틀
		private void title_company() {
			
			System.out.println("=".repeat(70) +"\n"
						+ " 회사명\t업종\t사업자등록번호\t자본금" + "\n" 
						+ "=".repeat(70));
			
		}	// end of private void title_company()-------------------
		
		// 강사님 (업종검색)
		// 결과만 도출되도록(검색값이 나오지 않아도 메뉴로 돌아간다.)
		/*
		   private void search_jobtype_company(Scanner sc, Company[] cp_arr) {
		      
		      System.out.print("▷ 업종명 : ");
		      String job_type_name = sc.nextLine().toLowerCase();
		      
		      StringBuilder sb = new StringBuilder();
		      boolean is_existence = false;
		      for(int i=0; i<Company.count; i++) {
		         if(cp_arr[i].getJob_type().toLowerCase().contains(String.join("", job_type_name.split("\\ ")))) {
		            is_existence = true;
		            sb.append(cp_arr[i].getInfo()+"\n");
		         }
		      }// end of for----------------------------
		      
		      if(is_existence) {
		         title_company();
		         System.out.println(sb.toString());
		      }
		      else {
		         System.out.println(">> 검색하시려는 "+ job_type_name +"업종에 해당하는 회사는 없습니다.!!\n");
		      }
		      
		   }// end of private void search_jobtype_company(Company[] cp_arr)------
		*/
		// 업종명 검색하기
		// 검색한 업종에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_jobtype(Scanner sc, Company[] cp_arr) {
			boolean exit = false;
			StringBuilder sb = new StringBuilder();
			do {
				System.out.print("▷ 업종명 : ");
				String jobtype = sc.nextLine();	// 입력한 업종		
				String search_jobtype = String.join("",jobtype.split(" "));	// jobtype 을 " "로 조각낸것을 다 붙임(""으로)
				for(int i=0; i<Company.count; i++) {
					if(cp_arr[i].getJob_type().toLowerCase().contains(search_jobtype.toLowerCase())) {
						// 대소문자 구분을 위해 소문자로 바꿔서 검사하기
						exit = true;
						sb.append(cp_arr[i].getInfo() + "\n");	// 해당한 업종 쌓기)
					} 
				}	// end of for------
				if(!exit)	// 해당하는 것이 없다면
					System.out.println("검색하시려는 " + search_jobtype + "은 없습니다.");
			} while (!exit);	// end of do~while------------
			title_company();
			System.out.println(sb.toString());
		}	// end of private void search_jobtype(Scanner sc, Company[] cp_arr)------------
		
	   //////////////////////////////////////////////////////////////////////////////////////////////////
		// 자본금 검색하기
		// 검색한 자본금에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_seedmoney(Scanner sc, Company[] cp_arr) {
		boolean exit = false;
		StringBuilder sb = new StringBuilder();
		do {
			try {
				System.out.print("▷ 자본금 : ");
				long seedmoney = Long.parseLong(sc.nextLine());	// 입력한 자본금
				for(int i=0; i<Company.count; i++) {
					if(cp_arr[i].getSeed_money() >= seedmoney) {	// 입력한 자본금 이상이라면
						exit = true;
						sb.append(cp_arr[i].getInfo() + "\n");	// 해당 회사의 정보 쌓기
					}
				}	// end of for-------
				if(!exit)	// 해당 회사가 없다면
					System.out.println("자본금이 " + seedmoney + "이상인 회사는 없습니다.");
			} catch(NumberFormatException e) {
				System.out.println("올바른 수를 입력해주세요");
			}	// end of try~catch----------
		} while (!exit);	// end of do~while------------		
		
		// 해당 자본금이 있는 경우 탈출
		title_company();
		System.out.println(sb.toString());
		}	// end of private void search_seedmoney(Scanner sc, Company[] cp_arr)------
			
		/*
		// 강사님
		// 결과만 도출되도록(검색값이 나오지 않아도 메뉴로 돌아간다.)
	   private void search_seedmoney_company(Scanner sc, Company[] cp_arr) {
	      
	      System.out.print("▷ 자본금 : ");
	      String str_search_seed_money = sc.nextLine();
	      
	      try {
	         long search_seed_money = Long.parseLong(str_search_seed_money);
	         
	         StringBuilder sb = new StringBuilder();
	         boolean is_existence = false;
	         
	         for(int i=0; i<Company.count; i++) {
	            if( search_seed_money <= cp_arr[i].getSeed_money() ) {
	               is_existence = true;
	               sb.append(cp_arr[i].getInfo()+"\n");
	            }
	         }// end of for----------------------------
	         
	         if(is_existence) {
	            title_company();
	            System.out.println(sb.toString());
	         }
	         else {
	            System.out.println(">> 검색하시려는 자본금이 "+ str_search_seed_money +"원 이상인 회사는 없습니다.!!\n");
	         }
	         
	      } catch(NumberFormatException e) {
	         System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!<< \n");
	      }
	      
	   }// end of private void search_seedmoney_company(Company[] cp_arr)------
 		*/
		
		// 모든 채용공고 조회
		private void view_all_recruit_info(Recruit[] rc_arr) {
			if(Recruit.count == 0)
				System.out.println(">> 채용공고가 없습니다. <<\n");
			else {
				// 60000/10000		6만원
				// 123456000/10000	12345.6
				StringBuilder sb = new StringBuilder();		// 채용공고를 쌓을려고 한다.
				
				try {
					Date now = new Date();
					SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMdd");
					Date today = sdft.parse(sdft.format(now));	// "20240207" ==> 20240207
					// sdft.format(now);
					// String str_now = sdft.format(now);	// "20240207"
				
					for(int i=0; i<Recruit.count; i++) {
						 Date date_finish_day = sdft.parse(rc_arr[i].getFinish_day());	// String -> Date 타입 변환
						 
							// == !채용마감일자.before(오늘날짜)
							 if(!date_finish_day.before(today)) {
							// if(rc_arr[i].getFinish_day() != null) { 		// 채용마감일이 오늘날짜 이후 
					
								sb.append(rc_arr[i].getRecruit_no() + "\t\t"
										+ rc_arr[i].getCp().getName() + "\t"
										+ rc_arr[i].getCp().getJob_type() + "\t"
										+ new DecimalFormat("#,###").format(rc_arr[i].getCp().getSeed_money()) + "원\t"
																								// 3자리마다 콤마찍어서 나오게하기
										+ rc_arr[i].getWork_type() + "\t    "
										+ rc_arr[i].getCnt() + "\t"
										
										+ rc_arr[i].getRegister_day().substring(0, 4) +"-" 		// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
										+ rc_arr[i].getRegister_day().substring(4, 6) +"-" 
										+ rc_arr[i].getRegister_day().substring(6) + "\t"
										
										+ rc_arr[i].getFinish_day().substring(0, 4) +"-" 		// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
										+ rc_arr[i].getFinish_day().substring(4, 6) +"-" 
										+ rc_arr[i].getFinish_day().substring(6) + "\n");
							 }
					}	// end of for----------
				} catch(ParseException e) {
				} 
				System.out.println("-".repeat(90));
				System.out.println("채용공고 순번     회사명     회사직종타입    자본금   채용분야(근무형태) 채용인원  등록일자  채용마감일자");
				System.out.println("-".repeat(90));
				
				System.out.println(sb.toString());
				System.out.println("[채용공고가 " + Recruit.count +"건이 있습니다]\n");
			}	// end of if~else---------------
		}	// end of private void view_all_recruit_info(Recruit[] rc_arr)-----------------------
		
		// 채용 지원하기
		private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
			
			// 구직자 자신이 응모한 채용공고 번호를 알아오자
			String str_my_recruit_no = "";
			for(int i=0; i<RecruitApply.count; i++) {
				if(rcApply_arr[i].getGu().getId().equals(login_gu.getId()))	// 로그인한 아이디와 지원서에 있는 아이디가 같은 경우
					str_my_recruit_no += rcApply_arr[i].getRc().getRecruit_no() + ",";	// 채용공고순서
			}	// end of for-----------------------
			
			if(str_my_recruit_no.length() > 0) {	// 응모한 경우가 있으면
				// str_my_cruit_no = "1,3,2,";
				str_my_recruit_no = str_my_recruit_no.substring(0, str_my_recruit_no.length()-1);
				// str_my_cruit_no = "1,3,2"
				
				String[] my_recruit_no_arr = str_my_recruit_no.split("\\,");
				// {"1","3","2"}
				
				if(my_recruit_no_arr.length == Recruit.count) {
					System.out.println(">> 이미 모든 채용공고에 지원하셨으므로, 더 이상 채용지원 가능한 공고가 없습니다.");
					return;	// 메소드 종료
				}
			}
			
			// == 채용공고번호는 채용공고로 올라온 번호만 입력해야 한다. == //
			boolean is_existance, is_duplicate_recruit_no;
			Recruit rc = null;		// 초기값
			
			// 내방법
			// outer:
			do {
				is_existance = false;
				is_duplicate_recruit_no = true;
			System.out.print("▷ 채용공고번호 : ");
			String input_recruit_no = sc.nextLine();
			// 내방법
			/*
				try{
					if(Recruit.count < Integer.valueOf(input_recruit_no))					// int 타입으로 바꾸기
						System.out.println(input_recruit_no + "번 공고는 없습니다.\n");
					else{
						is_existance = true;												// do~while 쓸경우 추가(틀릴경우 반복할 수 있다)
					}	// end of if~else----------
				} catch(NumberFormatException e) {
					System.out.println(input_recruit_no + "번 공고는 없습니다.\n");
				}	// end of try~catch---------------------
			*/
				//강사님 방법
				for(int i=0; i<Recruit.count; i++) {
					if(input_recruit_no.equals(String.valueOf(rc_arr[i].getRecruit_no()))) {	// string 타입으로 바꾸기
						is_existance = true;					// 문자열로 비교하였기 때문에 try~catch(NumberFormatException) 할 필요가 없다.
						rc = rc_arr[i];			// 채용공고번호를 담아주기!
						break;						
					}
				}	// end of for-------------
				if(!is_existance)
					System.out.println(">> 입력하신 " + input_recruit_no + "번은 채용공고에 존재하지 않습니다.\n");
			
				// 또한
				// 이미 공고한 곳에 중복 지원을 하면 안된다.
				// 아직 미진행(내방법)
				
				// 내 방법일 시 if(is_existance) 로 적기!
				else {		// 입력한 번호가 채용공고 번호에 있는 경우
					// == 채용공고번호는 채용공고로 올라온 번호이지만 이미 응모한 채용공고번호는 입력하면 안된다. == //
					for(int i=0; i<RecruitApply.count; i++) {
						// rcApply_arr[i].getRc().getRecruit_no()	// 채용공고 번호
						// rcApply_arr[i].getGu().getId()			// 채용공고에 지원한 구직자 Id
						
						if(input_recruit_no.equals(String.valueOf(rcApply_arr[i].getRc().getRecruit_no()))
																						// 지원신청한 공고번호와 지원목록에 있는 공고번호가 같을 경우
																						// 채용공고 순서가 int 타입이므로 String 타입으로 바꾸어 주어야 한다.
								&& login_gu.getId().equals(rcApply_arr[i].getGu().getId()))	{// 로그인한 아이디와 지원목록에 있는 아이디가 같을 경우
							// 중복된 경우
							is_duplicate_recruit_no = false;
							break;
							// 내방법
							//System.out.println("[경고] " + input_recruit_no + "번은 이미 지원하신 번호입니다.\n 중복지원은 불가합니다.\n");
							// break outer;
						}
					}	// end of for-----------
					// 강사님
					if(!is_duplicate_recruit_no)	// 중복된 경우
						System.out.println("채용공고번호 " + input_recruit_no + "번은 이미 지원하신 번호입니다.\n");
					else {	// 중복지원이 아닐 경우
							do {
							System.out.print("▷ 지원동기 : ");
							String apply_motive = sc.nextLine();
							if(apply_motive.isBlank()) {	// 지원동기가 비어있는 경우
								System.out.println("[경고] 지원동기는 필수로 입력하셔야 합니다.!!\n");
							} else {	// 지원동기를 입력한경우
								RecruitApply rc_apply = new RecruitApply();
								rc_apply.setRc(rc);
								rc_apply.setGu(login_gu);
								rc_apply.setApply_motive(apply_motive);
								
								rcApply_arr[RecruitApply.count++] = rc_apply;
								break;	// do~while 문 빠져나가기(지원동기)
							}	// end of if~else----------
							} while (true);
					}	// end of if~else-----------
				}	// end of if~else--------------
			// } while (!is_existance);	// end of do~while---------------	
			} while (!(is_existance && is_duplicate_recruit_no));	// end of do~while--------------
		}	// end of private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr)----
		
		// 지원한 채용공고 조회
		private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr) {
			boolean is_existence = false;
			
			for(int i=0; i<RecruitApply.count; i++) {
				if(rcApply_arr[i].getGu().getId().equals(login_gu.getId()))	{	// 지원배열에 아이디가 로그인한 사람과 같을 경우
					is_existence = true;
					System.out.print(rcApply_arr[i].getRc().recruit_info());	// 채용정보를 알려주는 메소드 호출하기
					System.out.println("▣ 지원동기 : " + rcApply_arr[i].getApply_motive() + "\n\n");
				}
			}	// end of for----------------
			if(!is_existence)
				System.out.println(">>> 채용공고에 응모한 내역이 없습니다.\n");
		}	// end of private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr)---------------------

}
