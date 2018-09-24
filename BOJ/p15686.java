import java.util.*;

class point{
    int x;
    int y;
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p15686 {
    static int N;
    static int M;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<point> chicken= new ArrayList<point>();
    static ArrayList<point> temp= new ArrayList<point>();
    static ArrayList<point> house= new ArrayList<point>();
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        
        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    //전체 집 등록
                    house.add(new point(i,j));
                }
                
                if(map[i][j] == 2) {
                    //전체 치킨집 등록
                    chicken.add(new point(i,j));
                }
            }
        }
        
        combination(0,0);
        System.out.println(answer);

    }
    
   
        
