import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228 {
//  �迭 : �޸�����ȭ, �����۾� ������������, ���� ������ �Ҹ�
//  ����Ʈ : �޸� ����, �����۾� ���� ����, ����,������ ������ ����
	static int N; //���� ��ȣ���� ����
	static int R; //���� ��ȣ��
	//��ɾ��� ����
	//��ɾ�
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0;t<10;t++) {
			N = Integer.parseInt(br.readLine()); //��ȣ���� ����
			ArrayList<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(st.nextToken());
			}//���� ��ȣ�� �Է�

			br.readLine();//��ɾ��� ����
			st = new StringTokenizer(br.readLine());//��ɾ�
			
			while(st.hasMoreTokens()) {
				st.nextToken();
				int  idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				//System.out.println("\n������ ��ġ : "+idx+" ������ ���ڵ� :"+num);
				for(int i=0;i<num;i++) {
					//System.out.print((idx+i)+" ");
					list.add(idx+i,st.nextToken());
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			list.clear();
		}
	}
}
