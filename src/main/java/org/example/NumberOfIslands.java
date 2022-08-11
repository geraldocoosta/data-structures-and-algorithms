package org.example;

public class NumberOfIslands {


    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }

    //Complexity Analysis
    //
    //Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
    //
    //Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
    void deepFirstSearch(char[][] grid, int axisY, int axisX, int totalHeight, int totalWidth) {
        if (axisY < 0 || axisX < 0 || axisY > totalHeight || axisX > totalWidth || grid[axisY][axisX] == '0') {
            return;
        }
        grid[axisY][axisX] = '0';
        deepFirstSearch(grid, axisY - 1, axisX, totalHeight, totalWidth);
        deepFirstSearch(grid, axisY + 1, axisX, totalHeight, totalWidth);
        deepFirstSearch(grid, axisY, axisX - 1, totalHeight, totalWidth);
        deepFirstSearch(grid, axisY, axisX + 1, totalHeight, totalWidth);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int totalHeight = grid.length - 1;
        int totalWidth = grid[0].length - 1;
        int numIslands = 0;

        for (int axisY = 0; axisY < totalHeight; ++axisY) {
            for (int axisX = 0; axisX < totalWidth; ++axisX) {
                if (grid[axisY][axisX] == '1') {
                    ++numIslands;
                    deepFirstSearch(grid, axisY, axisX, totalHeight, totalWidth);
                }
            }
        }

        return numIslands;
    }
}

/*
*
* Number of Islands
*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*
* */