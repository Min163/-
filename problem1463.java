package problem1463;
import java.util.Scanner;

public abstract class problem1463 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //����� ������ �ʿ����� ����� �� ����
		
		int[] count = new int[N+1]; //�� �ε����� �ʿ��� ������� ����
		
		count[0] = 0;
		count[1] = 0;
		
		for(int i = 2; i < N + 1; i++) {
			count[i] = 1 + count[i-1];
			
			if(i % 2 == 0 && 1 + count[i/2] < count[i]) {
				count[i] = 1 + count[i/2];
			}
				
			if(i % 3 == 0 && 1 + count[i/3] < count[i]) {
				count[i] = 1 + count[i/3];
			}
		}

		System.out.println(count[N]);
	}
}
