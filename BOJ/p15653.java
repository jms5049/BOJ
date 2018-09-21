import java.util.*;

class dot{
    int x;
    int y;
    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class pair{
    dot red;
    dot blue;
    public pair(dot x, dot y) {
        this.red = x;
        this.blue = y;
    }
}

public class p15653 {
    static char[][] board;
    static int[][][][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int M;
    static int N;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //빨간구슬 구멍
        //파란구슬 구멍 x
        //방법 x -> -1
        
        