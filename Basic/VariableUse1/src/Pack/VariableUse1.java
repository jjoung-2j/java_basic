package Pack;

public class VariableUse1 {
	public static void main(String[] args) {
		/*
		// 변수 사용 방법
		int a; // 컴퓨터야 4byte 메모리 줘. 그 이름을 a라고 할게
		a = 10; // 메모리에 정수 리터럴 10 대입 연산
		System.out.println(a);
		
		int b, c, d; // 변수를 일괄적으로 한 줄에 사용 가능
		b = 1;
		c = 2;
		d = 3;
		System.out.println(b); // 1
		System.out.println(b+c); // 3
		System.out.println(b+""+c); // 12
		System.out.println(b+" "+c); // 1 2
		System.out.println(b+" "+c+" "+d); // 1 2 3
		
		int e = 10; // 초기값 설정
		int f = 20, g = 30; // 변수 두개를 선언하면서 초기값 설정
		int h,i =40,j; //초기화 안된 것도 할 수 있음 but 밑에서 꼭 한번은 초기화 해야 함 i = 40, h = j
		h = 50;
		j = 60;
		System.out.println(e+" "+j+" "+h); // 10 60 50
		
		int a10; // 변수 이름은 숫자와 같이 사용 가능 but 숫자가 앞에 오면 안된다.
		a10 = 10;
		System.out.println(a10); //10
		a10 = 20; // 재 대입: 과거 값은 지움, 최근값을 가진다.
		System.out.println(a10); //20
		
		int aa =88, bb = 99;
		int temp; // 임시 라는 뜻의 변수로 많이 사용
		System.out.println(aa+" "+bb);
		// 교환 프로그램 or swap program (유손 아 3줄만으로 접근!)
		temp = aa; // temp = 88
		aa = bb; // aa = 99
		bb = temp; // bb = 88
		System.out.print(aa+" "+bb+"\n");
		
		// 위와 같으나 한 줄 줄어든 버전
		int cc = 100, dd = 200;
		System.out.println(cc+" "+dd); // 100 200
		int tt = cc; // tt = 100
		cc = dd; // cc =200
		dd = tt; // dd = 100
		System.out.println(cc+" "+dd); // 200 100
		*/
		/*
		// 변수를 가지고 오칙연산을 사용할 수 있음: 변수를 사용하면, 일일히 숫자 변경 안해도 됨.
		int a = 17, b =3; // 값이 0이 들어가지 않는다는 가정 하에 (나누기)
		System.out.println(a+b); // 20
		System.out.println(a-b); // 14
		System.out.println(a*b); // 51
		System.out.println(a/b); // 5
		System.out.println(a%b); // 2
		
		System.out.println(a>b); // t
		System.out.println(a>=b); // t
		System.out.println(a<b); // f
		System.out.println(a<=b); // f
		System.out.println(a==b); // f
		System.out.println(a!=b); // t
		
		// 연산 우선순위: 산술>비교>논리 (외우자!)
		System.out.println(a>b*7); // 산술 연산, 비교 연산이 같이 일어남. f
		System.out.println(a>b*7 || a-10>b); // t
		*/
		
		/*
		// while문과 break문을 사용해 1부터 10까지 더하기
		
		int result = 0;
		int i = 1;
		
		while(true) {
			result+=i; // result = result + i
			if(i == 10) {
				break;
			}
			i+=1;
		}
			System.out.println(result);
			
			// 1부터 10까지 홀수만 더하기
			int result = 0;
			
			for(int i = 1; i <=10; i++) {
				if(i %2 == 0) {
					continue;
				}
				result += i;
			}
			System.out.println(result);
			*/
			
			for(int i = 0; i < 10; i++) {
				if(i < 3) {
					continue;
				}
				System.out.println(i);
					if(i == 7) {
						break;
					}
				}
				System.out.println("호랑이");
				
				int num = 0;
				while(true) {
					num++;
					if(num % 2 != 0) {
						System.out.println("호랑이"+num);
						continue;
					}
					if(num == 10) {
						System.out.println("코끼리"+num);
						break;
					}
				}
			}
		}