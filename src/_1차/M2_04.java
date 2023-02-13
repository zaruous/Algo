package _1차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/********************************
 *	프로젝트 : Algo
 *	패키지   : 
 *	작성일   : 2022. 11. 28.
 *	작성자   : KYJ (callakrsos@naver.com)
 *******************************/

/**
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class M2_04 {

	public static void main(String[] args) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				String[] split = br.readLine().split(" ");
				String command = split[0];
				int val = Integer.parseInt(split[1]);

				switch (command) {
				case "push":
					priorityQueue.add(val);
					break;
				case "add":
					priorityQueue.add(priorityQueue.poll() + val);
					break;
				case "pop":
					for (int j = 0; j < val; j++) {
						System.out.print(priorityQueue.poll() + " ");
					}
					System.out.println();
					break;
				}
			}

			// System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}