import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228 {
//  배열 : 메모리최적화, 선택작업 무지막지많음, 삽입 삭제에 불리
//  리스트 : 메모리 낭비, 선택작업 별로 없음, 삽입,삭제가 많으면 유리
	static int N; //원본 암호문의 길이
	static int R; //원본 함호문
	//명령어의 개수
	//명령어
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0;t<10;t++) {
			N = Integer.parseInt(br.readLine()); //암호문의 길이
			ArrayList<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(st.nextToken());
			}//원본 암호문 입력

			br.readLine();//명령어의 개수
			st = new StringTokenizer(br.readLine());//명령어
			
			while(st.hasMoreTokens()) {
				st.nextToken();
				int  idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				//System.out.println("\n삽입할 위치 : "+idx+" 덧붙일 숫자들 :"+num);
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
