package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * 
 * 중앙의 값을 우선순위큐로 찾을 수 있다는게 색달랐던것같음.
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2_06_정중앙대학교_신선함 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int N = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> minq = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> maxq = new PriorityQueue<>();
			maxq.add(500);

			for (int i = 0; i < N; i++) {
				StringTokenizer sc = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(sc.nextToken());
				int b = Integer.parseInt(sc.nextToken());
				minq.add(a);
				maxq.add(b);

				Integer min = minq.poll();
				Integer max = maxq.poll();

				int temp = 0;
				if (min > max) {
					temp = min;
					min = max;
					max = temp;
				}
				minq.add(min);
				maxq.add(max);
				System.out.println(maxq.peek());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}