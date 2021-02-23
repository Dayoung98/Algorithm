import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//https://www.acmicpc.net/problem/13300
	//�����
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list[]  = new ArrayList[6];
		for(int i=0;i<6;i++)
			list[i] = new ArrayList<>();
		N = Integer.parseInt(st.nextToken()); //�л� ��
		K = Integer.parseInt(st.nextToken());  //�ִ� �ο���
		
		int room = 0;
		for(int i=0;i<N;i++) {
			//�л� ������ �г��� �������� �и��Ǿ �־���
			//0�� ���� 1�� ����
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list[year-1].add(gender);
		}
		
/*		for(int i=0;i<list.length;i++)
			System.out.println(list[i].toString());*/
		
		for(int i=0;i<list.length;i++) {
			//���� �г��� ���� ���� ���� �� ���Ƹ���
			int women=0,men=0;
			for(int j=0;j<list[i].size();j++) {
				if(list[i].get(j) ==0) women++;
				else men++;
			}
			if(women<K && women>0) room++;
			else {
				if(women % K ==0) room +=(women/K);
				else room +=(women/K)+1;
			}
			
			if(men<K && men>0) room++;
			else {
				if(men % K ==0) room +=(men/K);
				else room +=(men/K)+1;
			}
		}
		
		System.out.println(room);

	}
	

}
