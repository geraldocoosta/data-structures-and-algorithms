package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent {

    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        new CutOffTreesForGolfEvent().cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5)));
    }

    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> treeHeights = getAllTreeHights(forest);
        Collections.sort(treeHeights, (o1, o2) -> o1[2] - o2[2]);
        int minSteps = 0;
        int curX = 0, curY = 0;
        while (!treeHeights.isEmpty()) {
            int[] curTree = treeHeights.remove(0);
            int steps = getMinimumSteps(forest, curX, curY, curTree[0], curTree[1]);
            if (steps == -1) {
                return -1;
            }
            minSteps += steps;
            curX = curTree[0];
            curY = curTree[1];
            forest.get(curX).set(curY, 1);
        }
        return minSteps;
    }

    private int getMinimumSteps(List<List<Integer>> forest, int curX, int curY, int aimX, int aimY) {

        int minSteps = 0;
        int rows = forest.size(), cols = forest.get(0).size();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();
        int startVal = forest.get(curX).get(curY);
        queue.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                if (curCell[0] == aimX && curCell[1] == aimY) {
                    return minSteps;
                }
                for (int[] direction : directions) {
                    int nx = curCell[0] + direction[0];
                    int ny = curCell[1] + direction[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private List<int[]> getAllTreeHights(List<List<Integer>> forest) {
        List<int[]> treeHeights = new LinkedList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int tmpVal = forest.get(i).get(j);
                if (tmpVal > 1) {
                    int[] element = new int[3];
                    element[0] = i;
                    element[1] = j;
                    element[2] = tmpVal;
                    treeHeights.add(element);
                }
            }
        }
        return treeHeights;
    }

}

/*
Cut Off Trees for Golf Event

 You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:

0 means the cell cannot be walked through.
1 represents an empty cell that can be walked through.
A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.

You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).

Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.

Note: The input is generated such that no two trees have the same height, and there is at least one tree needs to be cut off.




 */