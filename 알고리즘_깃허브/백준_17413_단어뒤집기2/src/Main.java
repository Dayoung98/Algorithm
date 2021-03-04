import java.util.Arrays;
import java.util.Scanner;

//단어뒤집기2
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		char c[] = new char[str.length()];
		for(int i=0;i<str.length();i++)
			c[i] = str.charAt(i);
		for(int i=0;i<str.length();i++) {
			if(c[i] =='<') {
				while(true) {
					sb.append(c[i]);
					if(c[i]=='>') break;
					i++;	
				}
			}
			else if(c[i]==' ') sb.append(c[i]);
			else {
				//그냥 문자열 일때
				int j = i;
				while(true) {
					if(i>=str.length() || c[i]==' '||c[i]=='<') break;
					i++;
				}
				for(int m =(i-1);m>=j;m--)
					sb.append(c[m]);
				i--;
			}
		}
		System.out.println(sb);
	}
}
