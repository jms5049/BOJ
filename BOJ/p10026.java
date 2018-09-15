import java.util.*;

//class point{
//    int x;
//    int y;
//    public point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class p10026 {
    static int N;
    static char[][] map;
    static int[][] visit;
    static int nCount = 0;
    static int bCount = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        map = new char[N][N];
        visit = new int[N][N];
        
        for(int i = 0; i<N ; i++) {
            String temp = sc.next();
            for(int j = 0; j<N; j++) {
                map[i][j] = temp.charAt(j);
                visit[i][j] = 0;
            }
        }
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(visit[i][j] == 0 ) {
                    bfs(i,j,0);
                }
            }            
        }
        
        init(visit);
        
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(visit[i][j] == 0 ) {
                    bfs(i,j,1);
                }
            }
        }
        
        System.out.println(nCount + " " + bCount);

    }

    