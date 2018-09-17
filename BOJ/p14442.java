import java.util.*;

//class point{
//    int x;
//    int y;
//    int count;
//    int dist;
//    public point(int x, int y,  int count, int dist) {
//        this.x = x;
//        this.y = y;
//        this.count = count;
//        this.dist = dist;
//    }
//}

public class p14442 {
    
    static int[][] map;
    static int[][] visit;
    static Queue<point> q = new LinkedList<point>();
    static int N;
    static int M;
    static int K;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로
        K = sc.nextInt();   //기회
        map = new int[N][M];
        visit = new int[N][M];
        
        for(int i = 0; i<N; i++) {
            String temp = sc.next();
            for(int j = 0; j<M; j++) {
                map[i][j] = (int)temp.charAt(j)-'0';
                visit[i][j] = -1;
            }
        }
        
        bfs();
        
    }

    