package AlgorithmsRealisation.LeetCode.BFS;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RottingOranges {


    // 994. Rotting Oranges https://leetcode.com/problems/rotting-oranges/?envType=study-plan&id=algorithm-i
            public static int orangesRotting(int[][] grid) {
            final int ROTTEN = 2;
            final int FRESH = 1;
            final int[] DELTAS = {0, 1, 0, -1, 0};
            Queue<int[]> rotten = new LinkedList<>();
            List<int[]> fresh = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == ROTTEN) rotten.add(new int[]{i, j});
                    else if(grid[i][j] == FRESH) fresh.add(new int[]{i, j});
                }
            }
            if (fresh.isEmpty()) return 0;
            int counter = 0;
            while (!fresh.isEmpty() && !rotten.isEmpty()) {
                for (int i = rotten.size(); i > 0; i--) {
                    int[] rottenChainElement = rotten.remove();
                    List<int[]> freshNear = new ArrayList<>();
                    for (int q = 0; q < 4; q++) {
                        int[] temp = new int[]{rottenChainElement[0] + DELTAS[q], rottenChainElement[1] + DELTAS[q + 1]};
                        if (temp[0] >= 0 && temp[0] < grid.length && temp[1] >= 0 && temp[1] < grid[0].length && grid[temp[0]][temp[1]] == FRESH) freshNear.add(temp);
                    }
                    for (int[] point : freshNear) {
                        fresh.removeIf(integer -> integer[0] == point[0] && integer[1] == point[1]);
                        grid[point[0]][point[1]] = ROTTEN;
                        rotten.add(point);
                    }
                }
                counter++;
            }
            if(rotten.isEmpty()) return -1;
            return counter;
        }


    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}}; // 4
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}}; // -1
        int[][] grid3 = {{0,2}};                   // 0
        System.out.println(orangesRotting(grid1));
        System.out.println(orangesRotting(grid2));
        System.out.println(orangesRotting(grid3));
    }
}
