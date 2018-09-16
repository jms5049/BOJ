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

    private static void init(int[][] visit2) {
        for(int i = 0; i<N ; i++) {
            for(int j = 0; j<N; j++) {
                visit[i][j] = 0;
            }
        }
    }

    private static void bfs(int i, int j, int flag) {
        // TODO Auto-generated method stub
        boolean isBlind = false;
        int x = 0, y = 0;
        
        //색약 여부
        if(flag == 0)
            isBlind = false;
        else
            isBlind = true;
        
        Queue<point> q = new LinkedList<point>();
        q.add(new point(i,j));
        visit[i][j] = 1;
        
        while(!q.isEmpty()) {
            point temp = q.remove();
            x = temp.x;
            y = temp.y;
            char color = map[x][y];
            
            for(int k = 0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                //유효범위
                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                
                //체크
                if(!isBlind) {
                    if(color == map[nx][ny] && visit[nx][ny] != 1) {
                        q.add(new point(nx,ny));
                        visit[nx][ny] = 1;
                    }
                }
                else {
                    if(color == 'R' || color == 'G') {
                        if((map[nx][ny] == 'R' || map[nx][ny] == 'G') && visit[nx][ny] != 1) {
                            q.add(new point(nx,ny));
                            visit[nx][ny] = 1;
                        }
                    }
                    else {
                        if(color == map[nx][ny] && visit[nx][ny] != 1) {
                            q.add(new point(nx,ny));
                            visit[nx][ny] = 1;
                        }
                    }
                    
                }
            }
        }
        
        if(isBlind)
            bCount++;
        else
            nCount++;
        
    }

}
        