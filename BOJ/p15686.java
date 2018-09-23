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
        
        
