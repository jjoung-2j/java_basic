package Pack;

public class Day10_quiz {

	public static void main(String[] args) {
		System.out.println("\n=== 파일명만 뽑아온 결과물 (index) ===");
		String[] pathFileNameArr = {"C:/mydocument/resume/나의이력서.hwp",
									"D:/mymusic.mp3",
									"C:/photo/내얼굴.jpg"};
		for(int i=0; i<pathFileNameArr.length; i++) {
			// char 타입의 배열로 만들어서 chArr에 저장
			char[] chArr = pathFileNameArr[i].toCharArray();
			
			// 거꾸로 배열하기
			String str_reverse = "";
			for(int j=chArr.length-1; j>=0; j--) { //길이-1 : 마지막 index
				str_reverse += chArr[j];	// 거꾸로 나열
			}	// end of for---------
			
			// 거꾸로 나열되있는 것을 indexOf로 파일 구분 찾아내기
			int idx = str_reverse.indexOf("/");
			if(idx != -1) {	// -1일경우는 없는 경우니 제외
				// 거꾸로 나열된 상태에서의 index 값이니
				// 찾은 idx 의 뒷부분은 파일명이 아니므로 짤라준다.
				str_reverse = str_reverse.substring(0,idx);
				
				chArr = str_reverse.toCharArray();
				// char타입 문자열에 새로 저장하기
				
				// 다시 거꾸로 돌려놓기
				String str_result = "";
				for(int k=chArr.length-1; k>=0; k--) {
					str_result += chArr[k];
					// char타입으로 배열된 값을 String 타입으로 저장하기
				}	// end of for--------------
				System.out.println(str_result);
			}	// end of if---------
		}	// end of for------------

		System.out.println("\n=== 파일명만 뽑아온 결과물 (lastIndex) ===");
		String result ="";
		for(int i=0; i<pathFileNameArr.length;i++) {
			int idx = pathFileNameArr[i].lastIndexOf("/");
			// 마지막으로 "/" 있는 위치찾기
			if(idx != -1) {		// -1일경우는 존재하지 않는다는 이야기
			result = pathFileNameArr[i].substring(idx+1);
			// idx 부터 나오면 '/'부터 나오므로 +1 을 해주어야한다.
			}	// end of if---------
			System.out.println(result);
		}	// end of for-----
	
	}
}
