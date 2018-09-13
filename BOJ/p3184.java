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
        
        