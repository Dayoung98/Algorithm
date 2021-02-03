import java.util.Scanner;

/*
����	�ǹ�
.	����(������ �� �� �ִ�.)
*	������ ������� ��
#	��ö�� ������� ��
-	��(������ �� �� ����.)
^	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
v	�Ʒ����� �ٶ󺸴� ����(�Ʒ��� �����̴�.)
<	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
>	�������� �ٶ󺸴� ����(�Ʒ��� �����̴�.)*/

public class Solution_1873 {

	static int T;
	static int H,W; //Height, Width
	static int N; //input
	static int row,col; //���� ��ġ
	
	static char map[][]; //game map
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			
			H = sc.nextInt();
			W = sc.nextInt();
			
			map = new char[H][W];
			
			//map �Է�
			for(int i=0;i<H;i++) {
				String str = sc.next();
				for(int j=0;j<W;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
/*			System.out.println("map ���");
			for(int i=0;i<H;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			*/
			N = sc.nextInt(); //�Է� ũ��
			String input = sc.next();
			for(int i=0;i<input.length();i++) {
				
				char c = input.charAt(i);
	
				for(int h=0;h<H;h++) {
					for(int w=0;w<W;w++) {
						if(map[h][w] == '^') {
							row = h;
							col = w;
						}
						else if(map[h][w] == 'v') {
							row = h;
							col = w;
						}
						else if(map[h][w] == '<') {
							row = h;
							col = w;
						}
						else if(map[h][w] == '>') {
							row = h;
							col = w;
						}
					}
				} //���� ��ġ ���ϱ�
				
				switch (c) {
				case 'U':
					/*������ �ٶ󺸴� ������ �������� �ٲٰ�, 
					�� ĭ ���� ĭ�� ������� �� �� ĭ���� �̵��Ѵ�.*/
					map[row][col] = '^';
					if(row-1>=0 && map[row-1][col] == '.') {
						map[row][col] ='.';
						map[row-1][col] = '^';
						row = row-1;
					}
					break;
				case 'D':
					map[row][col] = 'v';
					if(row+1<H && map[row+1][col] == '.') {
						map[row][col] = '.';
						map[row+1][col] = 'v';
						row = row+1;
					}
					break;
				case 'L':
					map[row][col] = '<';
					if(col-1>=0 && map[row][col-1] == '.') {
						map[row][col] = '.';
						map[row][col-1] = '<';
						col = col-1;
					}
					break;
				case 'R':
					map[row][col] = '>';
					if(col+1<W && map[row][col+1] == '.') {
						map[row][col] = '.';
						map[row][col+1] = '>';
						col = col+1;
					}
					break;
				case 'S':
//					 ������ ���� �ٶ󺸰� �ִ� �������� ��ź�� �߻��Ѵ�.
					if(map[row][col] =='^') {
						for(int r = row;r>=0;r--) {
							if(map[r][col] =='#')
								break;
							if(map[r][col] =='*') {
								map[r][col] = '.';
								break;
							}
						}
					}
					else if(map[row][col] =='v') {
						for(int r=row;r<H;r++) {
							if(map[r][col] =='#')
								break;
							if(map[r][col] =='*') {
								map[r][col] = '.';
								break;
							}
						}
					}
					else if(map[row][col] =='<') {
						for(int c2 =col;c2>=0;c2--) {
							if(map[row][c2] =='#')
								break;
							if(map[row][c2] =='*') {
								map[row][c2] = '.';
								break;
							}
						}
					}
					else if(map[row][col] =='>') {
						for(int c2 = col;c2<W;c2++) {
							if(map[row][c2] =='#')
								break;
							if(map[row][c2]=='*') {
								map[row][c2] = '.';
								break;
							}
						}
					}
					break;

				default:
					break;
				}
			}
			
			
			
			
			
			
			System.out.print("#"+t+" ");
			/*for(int i=0;i<H;i++) {
				System.out.println(Arrays.toString(map[i]));
			}*/
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
