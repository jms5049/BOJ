import java.util.*;

class virus{
    int x;
    int y;
    public virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p14502 {
    
    static int M;
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int[][] copy;
    static int answer = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];
        
        //입력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1);
                    map[i][j] = 0;
                }
                    
            }
        }
        
        System.out.println(answer);

    }

    