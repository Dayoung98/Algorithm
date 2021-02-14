import java.util.Scanner;
import java.util.Stack;

public class Solution_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		int TC = sc.nextInt();
		
		for(int t=0;t<TC;t++) {
			int sum = 0;
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == '(' && str.charAt(i+1)==')') {
					//��������
					sum += stack.size();
					i = i+1;
				}else if(str.charAt(i)=='(') {
					//�������� �ƴϰ� �׳� (
					stack.push('(');
				}else if(str.charAt(i) ==')'){
					//�ݴ� ��ư ������
					sum = sum+1; //1�� �����ְ�
					stack.pop(); //������ �ϳ� �����ϱ� ������ �ϳ� ���ֱ�
				}
			}
			
			System.out.println("#"+(t+1)+" "+sum);
		}
	}
}
