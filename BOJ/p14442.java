﻿import java.util.*;

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

    private static void bfs() {
        q.add(new point(0,0,0,1));
        visit[0][0] = 1;
        int x = 0, y = 0, bCount = 0, dist = 0;
        while(!q.isEmpty()) {
            point temp = q.remove();
            x = temp.x;
            y = temp.y;
            bCount = temp.count;
            dist = temp.dist;
            
            if(x==N-1 && y == M-1) {
                System.out.println(dist);
                return;
            }
            
            for(int i = 0; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                
                if(isRange(nx,ny) && visit[nx][ny] != 1) {
                    
                    if(map[nx][ny] == 1) {
                        if(bCount+1 <= K) {
                            map[nx][ny] = 0;
                            bCount++;
                            q.add(new point(nx,ny,bCount,dist+1));
                            visit[nx][ny] = 1;
                        }
                        else
                            continue;
                    }
                    
                    else{
                        q.add(new point(nx,ny,bCount,dist+1));
                        visit[nx][ny] = 1;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isRange(int nx, int ny) {
        return (nx >= 0 && nx < N) && (ny >= 0 && ny < M);
    }

}
