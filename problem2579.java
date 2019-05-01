package problem2579;
import java.util.Scanner;
import java.lang.Math;

public class problem2579 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //계단의 개수
		
		int[] stair = new int[N];
		int[] cost = new int[N];
		
		for(int i = 0; i < N; i++) {
			stair[i] = scan.nextInt();
		}
		
//		System.out.println(currentValue(stair, N-1));
		
		for(int i = 0; i < N; i++) {
			storeValue(stair, cost, i);
		}
		
		System.out.println(cost[N-1]);
		
	}
	
	public static int currentValue(int[] stair, int n) { //재귀함수로 한 경우 : 시간 초과 발생
		if(n < 0) {
			return 0;
		}
		else if(n == 0) {
			return stair[0];
		}
		else {
			return Math.max(stair[n] + stair[n-1] + currentValue(stair, n-3), stair[n] + currentValue(stair, n-2));
		}
	}
	
	public static void storeValue(int[] stair, int[] cost, int n) {
		if(n == 0) {
			cost[n] = stair[0];
		}
		else if(n == 1) {
			cost[n] = Math.max(stair[n] + stair[n-1], stair[n]);
		}
		else if(n == 2){
			cost[n] = Math.max(stair[n] + stair[n-1], stair[n] + cost[n-2]);
		}
		else {
			cost[n] = Math.max(stair[n] + stair[n-1] + cost[n-3], stair[n] + cost[n-2]);
		}
	}
}
