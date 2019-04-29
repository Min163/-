package problem1003;
import java.util.Scanner;
import java.util.ArrayList;

public class problem1003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //총 몇 개의 숫자를 받을 것인가
		
		ArrayList<Integer> ZeroCnt = new ArrayList<Integer>(); //0의 개수를 담는 배열
		ZeroCnt.add(1); // 0일때 0의 개수 1
		ZeroCnt.add(0); // 1일때 0의 개수 0
		ArrayList<Integer> OneCnt = new ArrayList<Integer>(); //1의 개수를 담는 배열
		OneCnt.add(0); //0일때 1의 개수 0
		OneCnt.add(1); //1일때 1의 개수 1
		
		int[] testcase = new int[N];
		for(int i = 0; i < N; i++) {
			testcase[i] = scan.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			
			if(testcase[i] == 0) {
				System.out.println("1 0");
			}
			else if(testcase[i] == 1) {
				System.out.println("0 1");
			}
			else {
				Count(testcase[i], ZeroCnt, OneCnt);
			}
		}
	}
	
	public static void Count(int num, ArrayList zero, ArrayList one) {
		if(zero.size() >= num) {
			int n0 = (int)zero.get(num-1) + (int)zero.get(num-2);
			int n1 = (int)one.get(num-1) + (int)one.get(num-2);
			
			System.out.println(n0 + " " + n1);
			
			return;
		}
		else {
			while(zero.size() < num) {
				int size = zero.size() - 1;
				zero.add((int)zero.get(size) + (int)zero.get(size - 1));
				one.add((int)one.get(size) + (int)one.get(size - 1));
				
				if(zero.size() == num) {
					int n0 = (int)zero.get(num-1) + (int)zero.get(num-2);
					int n1 = (int)one.get(num-1) + (int)one.get(num-2);
					
					System.out.println(n0 + " " + n1);
					
					return;
				}
			}
		}
	}
}
