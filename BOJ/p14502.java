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

    private static void dfs(int k) {
        
        if(k == 3) {
            spread();
            calculate(copy);
            
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(k+1);
                    map[i][j] = 0;
                }
                    
            }
        }
        
    }

    private static void calculate(int[][] copy) {
        int max = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 0)
                    max++;
            }
        }
        
        if(max > answer)
            answer = max;
    }

    private static void spread() {
        
        Queue<virus> q = new LinkedList<virus>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
                if(copy[i][j] == 2)
                    q.add(new virus(i,j));
            }
        }
        
        while(!q.isEmpty()) {
            
            virus temp = q.remove();
            int x = temp.x;
            int y = temp.y;
            
            for(int k = 0; k < 4 ; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || copy[nx][ny] == 1) 
                    continue;
                
                if(copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.add(new virus(nx,ny));
                }
            }
        }
    }

}


    