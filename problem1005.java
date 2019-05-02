package problem1005;
import java.util.Scanner;

public class problem1005 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt(); //테스트케이스 개수
		
		for(int i = 0; i < T; i++) {
			int N = scan.nextInt(); //건물의 개수
			int K = scan.nextInt(); //건설순서규칙의 개수
			
			int[] cost = new int[N + 1];
			int[][] order = new int[N + 1][N + 1];
			
			for(int j = 1; j < N + 1; j++) { //건물비용 저장
				cost[j] = scan.nextInt();
			}
			
			for(int j = 0; j < K; j++) { // 건설순서규칙 저장
				int x = scan.nextInt();
				int y = scan.nextInt();
				
				order[x][y] = cost[y];
			}
			
			int end = scan.nextInt(); // 승리하기 위해 지어야할 건물 번호
			
			int sum = cost[1];
			
			int[] where = new int[N];
			int cnt = 0;
			
			
			int temp = 0;
			for(int j = 1; j < N+1; j++) {
				if(order[1][j] != 0) {
					where[cnt] = j;
					cnt++;
//					System.out.println(j);
				}
				if(temp < order[1][j]) {
					temp = order[1][j];
				}
			}
			
			sum += temp;
//			System.out.println(sum);
			
			while(true) {
				if(isEnd(where, N, end)) {
					break;
				}
				else {
					int[] tmp_where = new int[N];
					int tmp_cnt = 0;
					
					int tmp = 0;
					
					for(int k = 0; k < N; k++) {
						if(where[k] == 0) {
							break;
						}
						else {
							int n = SearchCost(N, where[k], tmp_cnt, order, tmp_where);
							
							if(tmp < n) {
								tmp = n;
							}
						}
					}
					
					where = tmp_where;
					sum += tmp;
//					System.out.println(sum);
				}
			}
			
			System.out.println(sum);
			
		}
	}
	
	public static int SearchCost(int N, int n, int cnt, int[][] order, int[] where) {
		int temp = 0;
		for(int i = 1; i < N+1; i++) {
			if(order[n][i] == 0) {
				continue;
			}
			else {
				where[cnt] = i;
				cnt++;
				if(temp < order[n][i]) {
					temp = order[n][i];
				}
			}			
		}
		
		return temp;
	}
	
	public static boolean isEnd(int[] where, int N, int end) {
		for(int i = 0; i < N; i++) {
			if(where[i] == end) {
				return true;
			}
		}
		return false;
	}
}
