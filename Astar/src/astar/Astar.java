package astar;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author Masaya Misaizu
 */
public class Astar {

    //Structure
    class City{
        String name;
        int Traincost;
        int Buscost;
        
        }
    class Position implements Comparable<Position>{
        int x;               //latitude
        int y;              //longitude
        int cost;            //Estimated cost from starting point
        int estimate;        //Estimated value(Manhattan+Moving cost)
        String path = "";    //Way(移動方向の記録)

        //コンストラクタ
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //比較関数
        @Override
        public int compareTo(Position o) {
            return this.estimate - o.estimate;    //推定値で小さい順
        }
    }
    
    public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    String str = scan.next();
    int i = Integer.parseInt(str);
    System.out.println(i);

    str = scan.next();
    int j = Integer.parseInt(str);
    System.out.println(j);
//         String input example
//            "S..#...#..",
//            ".#.#.#.#.#",
//            "...#.#....",
//            "##...#.##.",
//            ".....#.#..",
//            ".#####.#.#",
//            ".......#..",
//            "##.######.",
//            "...#...#..",
//            ".#...#...G",
//        S:Start G:Goal .:Road(cell) #:Wall(cannot penetrate)
    
    List<String> abc = new ArrayList<String>();
    for(int count = 0;count < j; count++){
        str = scan.next();
        if(str.length() == i)
        abc.add(str);
    }
    System.out.println(abc);
    String maze = String.join(",", abc);
        System.out.println(maze);
    new Astar(i,j,maze);
    }

    static final int INF = Integer.MAX_VALUE;    //INF値

    //Search 4 ways
    static final int[] dx = { 0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1,  0};
    static final char[] dir = {'u', 'r', 'd', 'l'};

    String path = "";    //Ways(return)

    //Calculate Mannhattan Distance
    static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    //Calculate ChevyshevDistance
    static int getChevyshevDistance(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public Astar(int n,int m,String abc) {
        String[] maze = new String[]{abc};
        int ans = astaralgo(n, m, maze);
        System.out.println(ans);
        System.out.println(path);
    }

    //A*(A-star)探索アルゴリズム
    int astaralgo(int n, int m, String[] maze) {
        int[][] grid = new int[n][m];    //Store the data of the cost of moving(length)
        int sx, sy, gx, gy;              //Start/Goal position store
        sx = sy = gx = gy = 0;

        //迷路データのパース
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i].charAt(j) == '#') {
                    grid[i][j] = -1;       //Wall
                } else if (maze[i].charAt(j) == 'S') {
                    grid[i][j] = 0;        //Start lenght is ZERO
                    sy = i;
                    sx = j;
                } else if (maze[i].charAt(j) == 'G') {
                    grid[i][j] = INF;
                    gy = i;
                    gx = j;
                } else {
                    grid[i][j] = INF;
                }
            }
        }

        //A*(A-star) 探索
        Queue<Position> q = new PriorityQueue<Position>();

        Position p = new Position(sx, sy);
        p.estimate = getManhattanDistance(sx, sy, gx, gy);    //estimated cost as manhattan
        q.add(p);

        while (!q.isEmpty()) {
            p = q.poll();
            if (p.cost > grid[p.y][p.x]) {
                continue;
            }
            if (p.y == gy && p.x == gx) {    //if reach to the goal
                path = p.path;        //Way road(戻値用)
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || m <= nx || ny < 0 || n <= ny) {    //範囲外
                    continue;
                }
                if (grid[ny][nx] > grid[p.y][p.x] + 1) {
                    grid[ny][nx] = grid[p.y][p.x] + 1;
                    
                    Position p2 = new Position(nx, ny);
                    p2.cost = grid[ny][nx];        //Moving cost(how long did you come to the place which you are in)
                    p2.estimate = getManhattanDistance(nx, ny, gx, gy) + p2.cost;    //estimated cost as manhattan
                    p2.path = p.path + dir[i];     //移動経路(移動方向の記録)
                    q.add(p2);
                }
            }
        }

        return grid[gy][gx];    //見つからないときは INF 値になる
    }

}
    

