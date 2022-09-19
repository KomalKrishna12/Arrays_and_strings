import java.util.*;
// steps:
// get all x components [x1, x2]
// get all y components [y1, y2]
// sort both array which contains x and y components
// find mid of both array
// find distance
// we can avoid sorting both array by just traversing row wise to get all x componenst sorted
// similarly col wise to get all y componnets sorted
// now calculate distance 
// suppose mid is (x',y') so distance will be |x'- x1| + |x' - x2| + |y' - y1| + |y' - y|
public class Q17_Best_meeting_point{
    public static int minTotalDistance(int[][] grid) {
        // 1. get x components -> row wise traversal
        ArrayList<Integer> xlist = new ArrayList<>(); 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    xlist.add(i);
                }
            }
        }

        // 2. get y components -> col wise traversal
        ArrayList<Integer> ylist = new ArrayList<>(); 
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1) {
                    ylist.add(j);
                }
            }
        }

        // 3. get mid -> best meeting point
        int x = xlist.get(xlist.size()/2); // in even case assuming first meeting point
        int y = ylist.get(ylist.size()/2);


        // 4. calculate distance -> min distance (bcoz of median)
        int distance = 0;
        for(int val : xlist){
            distance += Math.abs(x - val);
        }

        for(int val : ylist){
            distance += Math.abs(y - val);
        }

        // 5. return ans
        return distance;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        scn.close();
        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}