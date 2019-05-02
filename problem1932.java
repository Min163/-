package problem1932;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class problem1932 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt(); //�� �� ���� �Է��� ���ΰ�
		
		ArrayList<Integer> previous = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				previous.add(scan.nextInt());
			}
			else {
				ArrayList<Integer> current = new ArrayList<Integer>();
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				for(int j = 0; j < i+1; j++) { //�Է¹��� ������ ����
					current.add(scan.nextInt());
				}
				
				for(int j = 0; j < i; j++) {
					if(j == 0 || j == i) {
						temp.add(previous.get(j) + current.get(j));
						temp.add(previous.get(j) + current.get(j+1));
					}
					else {
						int tmp = previous.get(j) + current.get(j);
						
						if(tmp > temp.get(j)) {
							temp.set(j, tmp);
						}
						
						temp.add(previous.get(j) + current.get(j+1));
					}
				}
				
				previous = temp;
				
			}
		}
		
		Collections.sort(previous);
		System.out.println(previous.get(previous.size()-1));	
		
	}
}
