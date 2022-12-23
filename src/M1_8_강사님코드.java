import java.io.*;
import java.util.*;

public class M1_8_강사님코드 {
	
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++)
		{
			int N = Integer.parseInt(br.readLine());
			
			int Height[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				Height[i] = Integer.parseInt(st.nextToken());

			int Card[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				Card[i] = Integer.parseInt(st.nextToken());
			
			// index : 카드 번호, value : 해당 카드를 갖는 사람의 키
			int Card2Height[] = new int[N + 1];
			// 0번은 사용하지 않더라도 배열에선 필수로 생성
			
			for(int i = 0; i < N; i++)
				Card2Height[ Card[i] ] = Height[i];
			
			int flag = 0; // 조건에 맞지 않는 경우가 있는가?
			for(int i = 1; i < N; i++)
				// 문제의 조건에 맞지 않는 경우
				if(Card2Height[i] < Card2Height[i + 1])
					flag = 1;
			if(flag == 1) // 맞지 않는 경우가 존재함
				System.out.println("NO");
			else if(flag == 0) // 맞지 않는 경우가 단 1개도 존재하지 X
				System.out.println("YES");
		}
	}
}