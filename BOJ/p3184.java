import java.util.*;

public class p3184 {
    static char[][] map;
    static int[][] visit;
    static Queue<point> q = new LinkedList<point>();
    //오,왼,아래,위
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int totalSheep=0;
    static int totalWolf=0;
    static int countWolf = 0;
    static int countSheep = 0;
    static int R;
    static int C;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();   //세로
        C = sc.nextInt();   //가로
        
        //보드 초기화
        map = new char[R][C];
        visit = new int[R][C];
        int x=0;
        int y=0;
        
        for(int i = 0 ; i < R; i++) {
            String temp = sc.next();
            for(int j = 0; j <C; j++) {
                visit[i][j] = -1;
                map[i][j] = temp.charAt(j);
            }
        }
        
        for(int i = 0 ; i < R; i++) {
            for(int j = 0; j <C; j++) {
                if(visit[i][j] == -1) {
                    bfs(i,j);


    private static void bfs(int i, int j) {
        
        q.add(new point(i,j));
        visit[i][j] = 1;
        
        while(!q.isEmpty()) {
            point temp = q.remove();
            int x = temp.x;
            int y = temp.y;
            
            for(int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                //유효범위
                if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;
                if(map[nx][ny] == '#')
                    continue;

                if(map[nx][ny] != '#' && visit[nx][ny] != 1) {
                    
                    if(map[nx][ny] == 'o') {
                        countSheep++;
                    }
                    else if(map[nx][ny] == 'v') {
                        countWolf++;
                    }
                    visit[nx][ny] = 1;
                    q.add(new point(nx,ny));
                }                
            }
        }
    }
}
