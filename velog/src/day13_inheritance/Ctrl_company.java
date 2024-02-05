package day13_inheritance;

import java.util.Scanner;

public class Ctrl_company {

	// === 구인회사 회원가입 === //
	public void register(Scanner sc, Company[] cp_arr) {
		if(Company.count < cp_arr.length) {	// 정원이 초과되지 않을 경우
			
			Company cp = new Company();	// 새로운 구인회사로 등록하기
			
			outer:
	        do {
	        	System.out.print("1. 아이디 : ");
	        	String id = sc.nextLine();
	        	
	        	// 중복 아이디 검사하기
	        	for(int i=0; i<Company.count; i++) {
	        		if(id.equals(cp_arr[i].getId())) {
	        			System.out.println("이미 사용중인 아이디 이므로 다른 아이디를 입력해주세요.");
	        			continue outer;
	        		}
	        	}	// end of for------
	        	
	        	// 중복 아이디가 없을 경우
	        	cp.setId(id);
	        } while(!(cp.getId() != null));		// !(탈출조건)
	        // end of do~while------------------------
	        
		    do {
		    	System.out.print("2. 비밀번호 : ");
		    	String passwd = sc.nextLine();
		    	
		    	cp.setPasswd(passwd);
		    } while(!(cp.getPasswd() != null));		// !(탈출조건)
		    // end of do~while------------------------
	    
		    do {
		    	System.out.print("3. 회사명 : ");
		    	String business_number = sc.nextLine();
		    	
		    	cp.setBusiness_number(business_number);
		    } while(!(cp.getBusiness_number() != null));		// !(탈출조건)
		    // end of do~while------------------------
		    
		    cp_arr[Company.count++] = cp;	// 구인회사 배열에 추가하기
	        
	        System.out.println(">> 구인회사 회원가입 성공!! <<\n");
			}	// 회원가입 가능할 경우
			else {	// 구인회사 회원수가 cp_arr.length(정원)이 되었을 경우
				System.out.println(">> 정원 " + cp_arr.length +"개가 꽉차서 구직자 회원가입이 어렵습니다.\n죄송합니다.");
			}	// end of if~else--------------
	}	// end of public void register(Scanner sc, Company[] cp_arr)-------
	
	// === 구인회사 로그인 === //
	public Company login(Scanner sc, Company[] cp_arr) {
		System.out.print("▷ 구인회사 ID : ");
		String id = sc.nextLine();
		System.out.println("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Company.count; i++) {
			if(id.equals(cp_arr[i].getId()) && passwd.equals(cp_arr[i].getPasswd()))
				return cp_arr[i];
		}	// end of for------------
		return null;	// 아이디와 패스워드가 틀릴경우
	}	// end of public Company login(Scanner sc, Company[] cp_arr)--------
	
	// === 구인회사 전용메뉴 === //
	public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr, Recruit[] rc_arr) {
		String str_menuno = "";
		do {
			System.out.println("=== 구인회사 전용메뉴(" + login_cp + "기업 로그인 중) ===\n"
					+ "1. 회사정보 보기 2. 회사정보 수정 3. 모든 구직자 조회 4. 구직자 성별 검색 5. 구직자 연령대 검색\n"
					+ "6. 구직자 연령대 및 성별 검색 7. 사원모집공고 8. 모집공고지원자 조회 9. 로그아웃");
			System.out.print("▷ 메뉴번호 선택 : ");
			
			str_menuno = sc.nextLine();
			switch (str_menuno) {
			case "1":	// 회사정보 보기
				
				break;
			case "2":	// 회사정보 수정
				
				break;
			case "3":	// 모든 구직자 조회
	
				break;
			case "4":	// 구직자 성별 검색
	
				break;
			case "5":	// 구직자 연령대 검색
	
				break;
			case "6":	// 구직자 연령대 및 성별 검색
	
				break;
			case "7":	// 사원모집공고
	
				break;
			case "8":	// 모집공고지원자 조회
	
				break;
			case "9":	// 로그아웃
	
				break;

			default:	// 메뉴에 없는 보기를 작성한 경우
				break;
			}	// end of switch------
		} while(!("9".equals(str_menuno)));
	}	// end of public void cp_menu(Scanner sc, Company login_cp, Gujikja[] gu_arr, Recruit[] rc_arr)--
}
