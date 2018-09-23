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
        
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(new dot(rx,ry),new dot(bx,by)));
        boolean found = false;
        int answer = -1;
        while(!queue.isEmpty()) {
            pair temp = queue.remove();
            dot red = temp.red;
            dot blue = temp.blue;
            check[red.x][red.y][blue.x][blue.y] = 0;
            
            for(int k = 0; k < 4; k++) {
                int nrx = red.x + dx[k];
                int nry = red.y + dy[k];
                int nbx = blue.x + dx[k];
                int nby = blue.y + dy[k];
                
                //범위 밖이면
                if(nrx < 0 || nry < 0 || nbx < 0 || nby < 0)
                    continue;
//                if(nrx >= N || nbx >= N || nry >= M || nby >= M)
//                    continue;
                
                
                if(board[nrx][nry] == '#') {
                    nrx = red.x;
                    nry = red.y;
                }
                
                if(board[nbx][nby] == '#') {
                    nbx = blue.x;
                    nby = blue.y;
                }
                
                
                //이미 방문?
                if(check[nrx][nry][nbx][nby] != -1)
                    continue;
                //같은 위치?
                if(nrx == nbx && nry == nby)
                    continue;
                
                //파랑이 구멍으로 나가면 망
                if(board[nbx][nby] == 'O')
                    continue;
                else
                    if(board[nrx][nry] == 'O') {
                        found = true;
                        answer = check[red.x][red.y][blue.x][blue.y] + 1;
                        break;
                    }
                
                check[nrx][nry][nbx][nby] = check[red.x][red.y][blue.x][blue.y] + 1;
                queue.add(new pair(new dot(nrx,nry),new dot(nbx,nby)));
                
            }
            if(found)
                break;
        }
        
        System.out.println(answer);
        

    }

}

        