import java.io.*;
import java.util.*;

public class Main {

	static class Jewelry implements Comparable<Jewelry> {

		int idx, weight, price;
		
		public Jewelry(int idx, int weight, int price) {
			this.idx = idx;
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewelry o) {
			return weight - o.weight;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jewelries = new Jewelry[N];
		boolean[] checked = new boolean[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			jewelries[i] = new Jewelry(i, weight, price);
		}
		
		Arrays.sort(jewelries);
		
		PriorityQueue<Integer> bags = new PriorityQueue<Integer>();
		for (int i=0; i<K; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}
		
		long sum = 0;
		int idx = 0;
		PriorityQueue<Jewelry> temp = new PriorityQueue<Jewelry>(new Comparator<Jewelry>() {
			
			@Override
			public int compare(Main.Jewelry o1, Main.Jewelry o2) {
				return o2.price - o1.price ;
			}
			
		});
		
		while(!bags.isEmpty()) {
			int bagWeight = bags.poll();
			
			// 무게 작은 놈들만 골라서 뽑는다.
			while(idx < N && jewelries[idx].weight <= bagWeight) {
				temp.offer(jewelries[idx]);
				idx++;
			}
			
			// temp에서 뽑을 때는 가격 순으로
			if (!temp.isEmpty()) {
				Jewelry jewelry = temp.poll();
				sum += jewelry.price;
				checked[jewelry.idx] = true;
				
			}
 			
		}
		
		System.out.println(sum);

		
	}

}
