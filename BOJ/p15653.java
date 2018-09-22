import java.util.*;

class dot{
    int x;
    int y;
    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class pair{
    dot red;
    dot blue;
    public pair(dot x, dot y) {
        this.red = x;
        this.blue = y;
    }
}

public class p15653 {
    static char[][] board;
    static int[][][][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int M;
    static int N;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //빨간구슬 구멍
        //파란구슬 구멍 x
        //방법 x -> -1
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로
        int rx = 0,ry = 0,bx = 0,by = 0; //,hx = 0,hy = 0; // r = 빨간구슬 / b = 파란구슬 / h = 구멍
        
        //보드 초기화
        board = new char[N][M];
        check = new int[N][M][N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=0; k<N; k++) {
                    Arrays.fill(check[i][j][k],-1);
                }
            }
        }
        
        for(int i = 0 ; i < N; i++) {
            String temp = sc.next();
            for(int j = 0; j <M; j++) {
                board[i][j] = temp.charAt(j);
//                if(temp.charAt(j)=='0') {
//                    hx = j;
//                    hy = i;
//                }
                if(temp.charAt(j)=='R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                }
                if(temp.charAt(j)=='B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
                    
            }
        }
        
        
        
        System.out.println(answer);
        
        
        

    }

}

        