import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//�ܾ������2
public class Main {

	public static void main(String[] args) /*throws IOException*/ {
		StringBuilder sb = new StringBuilder();
		Queue<String> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		String str  = sc.nextLine();
	
		char ch[] = new char[str.length()];
		ch = str.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		for(int i=0, size = str.length();i<size;i++) {
			if(ch[i] == '<') {
				while(true) {
					sb.append(ch[i]);
					if(ch[i] == '>') break;
					i++;
				}
				System.out.println("���� i �� :"+i);
				System.out.println("���� ť�� ���� �� :"+sb.toString());
				q.add(sb.toString());
				sb.delete(0, sb.length());
			}
			else {
				while(true) {
					sb.append(ch[i++]);
					if(ch[i] ==' ' || ch[i] =='<') break; //���� �������� break;
				}
				System.out.println("���� i �� :"+i);
				System.out.println("���� ť�� ���� �� :"+sb.toString());
				q.add(sb.toString());
				sb.delete(0, sb.length());
			}
		}



	}
}
