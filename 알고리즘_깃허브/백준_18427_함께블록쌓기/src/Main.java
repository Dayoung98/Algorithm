import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/18427
public class Main {

	static int N; //몇명인지
	static int M; //몇개까지
	static int H; //높이
	static int result; //경우의 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		Student student[] = new Student[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			student[i] = new Student();
			while(st.hasMoreTokens()) student[i].list.add(Integer.parseInt(st.nextToken()));
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<student[i].list.size();j++)
				System.out.print(student[i].list.get(j)+" ");
		System.out.println();}
	}
	
	
	static class Student{
		ArrayList<Integer> list = new ArrayList<>();
	}
}
