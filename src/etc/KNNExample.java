package etc;

import java.util.*;

public class KNNExample {

	// 데이터 포인트를 나타내는 클래스
	static class DataPoint {
		double x, y;
		String category;

		public DataPoint(double x, double y, String category) {
			this.x = x;
			this.y = y;
			this.category = category;
		}
	}

	// 유클리드 거리 계산 메서드
	public static double euclideanDistance(DataPoint p1, DataPoint p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	// KNN 알고리즘 메서드
	public static String classify(DataPoint[] dataSet, DataPoint newPoint, int k) {
		// 거리와 데이터 포인트를 저장할 리스트
		List<DataPoint> neighbors = new ArrayList<>();

		// 모든 데이터 포인트에 대해 거리 계산
		for (DataPoint data : dataSet) {
			double distance = euclideanDistance(data, newPoint);
			neighbors.add(new DataPoint(distance, 0, data.category));
		}

		// 거리를 기준으로 정렬
		neighbors.sort(Comparator.comparingDouble(o -> o.x));

		// 가장 가까운 k개의 이웃 찾기
		Map<String, Integer> vote = new HashMap<>();
		for (int i = 0; i < k; i++) {
			String category = neighbors.get(i).category;
			vote.put(category, vote.getOrDefault(category, 0) + 1);
		}

		// 가장 많이 나타난 카테고리 찾기
		return Collections.max(vote.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static void main(String[] args) {
		// 예제 데이터셋
		DataPoint[] dataSet = { 
				new DataPoint(2, 3, "A"), 
				new DataPoint(5, 4, "B"), 
				new DataPoint(9, 6, "A"),
				new DataPoint(4, 7, "B"), 
				new DataPoint(8, 1, "A"), 
				new DataPoint(7, 2, "B") };

		// 새로운 데이터 포인트
		DataPoint newPoint = new DataPoint(5, 5, "");

		// KNN 알고리즘으로 분류
		String category = classify(dataSet, newPoint, 3);
		System.out.println("The category of the new data point is: " + category);
	}
}