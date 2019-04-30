package problem1149;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


public class problem1149 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //총 몇 개의 집이 있는가
		
		int[][] previous = new int[3][2]; //이전 집(i-1)의 색깔별 비용
		
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				for(int j = 0; j < 3; j++) { //각각의 비용을 저장
					previous[j][1] = scan.nextInt(); //비용을 저장
					previous[j][0] = j; //rgb 구별용: 0 = r, 1 = g, 2 = b
					
				}
				
				insertionSort(previous);
			}
			
			else {
				int[][] current = new int[3][2]; //현재 집(i)의 색깔별 비용
				
				for(int j = 0; j < 3; j++) {
					
					current[j][1] = scan.nextInt();
					current[j][0] = j; 
					
					if(previous[0][0] == j) { //같은 색깔인 경우
						current[j][1] += previous[1][1];
					}
					else { //다른 색깔인 경우
						current[j][1] += previous[0][1];
					}
				
				}				
				previous = current;
				
				insertionSort(previous);
				
			}
		}
		
		System.out.println(previous[0][1]);
	}
	
	public static void insertionSort(int[][] arr) {
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
	}
}
