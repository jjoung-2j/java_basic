package Pack;
import java.io.IOException;
import java.util.Random;

public class RandomEx {
	public static void main(String[] args) throws IOException{
		/*
		System.out.println("0~1 사이 랜덤 숫자 " + Math.random());
		System.out.println("0~100 사이 랜덤 숫자 " + (int)(Math.random() * 100));
		System.out.println("0~10000 사이 랜덤 숫자 " + (int)(Math.random()* 10000));
		// math.random() => 0 ~ 1 사이 숫자
		*/
		/*
		Random random = new Random(); // 랜덤 객체 생성
		random.setSeed(System.currentTimeMillis());
		
		System.out.println("0부터 N까지 무작위 랜덤 숫자: " + random.nextInt(100)); // 100 = n
		System.out.println("무작위 Int 값: " + random.nextInt()); // Int 최대최소 범위
		System.out.println("무작위 Long 값: " + random.nextLong()); // Long 최대최소 범위
		System.out.println("무작위 Double 값: " + random.nextDouble()); // 0 ~ 1
		System.out.println("무작위 Float 갑: " + random.nextFloat()); // 0 ~ 1
		System.out.println("무작위 정규 분포 랜덤 값: " + random.nextGaussian());
		System.out.println("무작위 Boolean 값: " + random.nextBoolean());
		
		
		Random random = new Random(); // 랜덤 객체 생성
		
		random.setSeed(0);
		for(int i = 0; i < 5; i++) {
			System.out.println(random.nextInt(100) + " ");
		}
		
		System.out.println();
		
		random.setSeed(0);
		for(int i = 0; i < 5; i++) {
			System.out.println(random.nextInt(100) + " ");
		}
		*/
		
		Random random = new Random(); 
		random.setSeed(System.currentTimeMillis());

		for(int i = 0; i < 6; i++) {
			System.out.print("[" + (random.nextInt(45)+1) + "]");
		}
		
		System.out.println();
		
	}
}
