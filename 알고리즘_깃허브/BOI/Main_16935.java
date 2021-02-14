import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935 {

	static int N,M,R;
	static int arr[][];
	static int operation[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //����
		M =Integer.parseInt(st.nextToken()); //����
		R = Integer.parseInt(st.nextToken());  //�����ؾ� �� ������ �� 
		
		arr = new int[N][M];
		operation = new int[R];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //�迭 �Է�
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<R;i++) {
			if(operation[i] == 1)
				func1();
			else if(operation[i] == 2)
				func2();
			else if(operation[i] == 3)
				func3();
			else if(operation[i] == 4)
				func4();
			else if(operation[i] == 5)
				func5();
			else if(operation[i] == 6)
				func6();
			
			/*switch (operation[i]) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				 break;

			}*/
			/*System.out.println("case #"+(i+1));
			for(int j=0;j<arr.length;j++)
				System.out.println(Arrays.toString(arr[j]));*/
		}

		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
	}
	
	static void func1() {
		//���� ����
		N = arr.length;
		M =arr[0].length;
		int temp[] = new int[M];
		for(int i=0;i<N/2;i++) {
			temp = arr[i];
			arr[i] = arr[(N-1)-i];
			arr[(N-1)-i] = temp;
		}		
	}
	
	static void func2() {
		//�¿� ����
		N = arr.length;
		M =arr[0].length;
		int temp[] = new int[N];
		for(int i=0;i<M/2;i++) {
			for(int j=0;j<N;j++) {
				temp[j] = arr[j][i];
				arr[j][i] = arr[j][(M-1)-i];
				arr[j][(M-1)-i] = temp[j];
			}
		}
	}
	
	static void func3() {
		//������ 90�� ȸ��
		func4();
		func1();
		func2();
	}
	static void func4() {
		N = arr.length;
		M = arr[0].length;
		int arr2[][] = new int[M][N]; //���� ���� ����
		int temp[]; //���� �迭 ������ temp
		
		for(int i=0;i<N;i++) {
			int cnt = 0;
			temp = arr[i]; //���� �迭�� ù��° ������
			for(int j=M-1;j>=0;j--) {
				//ù��° �������� N�� ����.
				//������ �������� 0�� ����.
				arr2[j][i] = temp[cnt++];
			}
		}//�迭 ���� ��
		
		arr = new int[M][N]; //���� ���� ���ֱ�
		for(int i=0;i<M;i++)
			arr[i] = arr2[i];
	}
	static void func5() {
		
		//�迭�� 4��ȹ���� ���� �� �ű���
		N = arr.length;
		M = arr[0].length;
		int arr2[][] =new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i<=(N/2-1) && j<=(M/2-1))
					arr2[i][j] = arr[i+(N/2)][j];//1�� �������� 4�� �־��ֱ�
				else if(i<=(N/2-1) && j>=(M/2))
					arr2[i][j] = arr[i][j-(M/2)];//2�� �������� 1�� �־��ֱ�
				else if(i>=(N/2) && j<=(M/2-1))
					arr2[i][j] = arr[i][j+(M/2)];//4�� �������� 3�� �־��ֱ�
				else if(i>=(N/2) && j>=(M/2))
					arr2[i][j] = arr[i-(N/2)][j];//3�� �������� 2�� �־��ֱ�
					
			}
		}
		
		for(int i=0;i<N;i++)
			arr[i] = arr2[i];

	}
	
	static void func6() {
		//1->4
		//4->3 3->2 2->1
		N = arr.length;
		M = arr[0].length;
		int arr2[][] =new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i<=(N/2-1) && j<=(M/2-1))
					arr2[i][j] = arr[i][j+(M/2)];//1�� �������� 2�� �־��ֱ�
				else if(i<=(N/2-1) && j>=(M/2))
					arr2[i][j] = arr[i+(N/2)][j];//2�� �������� 3�� �־��ֱ�
				else if(i>=(N/2) && j<=(M/2-1))
					arr2[i][j] = arr[i-(N/2)][j];//4�� �������� 1�� �־��ֱ�
				else if(i>=(N/2) && j>=(M/2))
					arr2[i][j] = arr[i][j-(M/2)];//3�� �������� 4�� �־��ֱ�
					
			}
		}
		for(int i=0;i<N;i++)
			arr[i] = arr2[i];
	}
}
