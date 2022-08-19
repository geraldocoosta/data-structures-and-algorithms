package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] ints = new KClosestPointsToOrigin().kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }

    //Time Complexity: O(NlogN), where N is the length of points.
    //
    //Space Complexity: O(N).
    public int[][] kClosest(int[][] points, int k) {
        // Priority queue implementa um heap
        // se é max ou min será decidido com o comparator que eu passo como parametro
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> getDistance(a) - getDistance(b));

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }

        return result;
    }


    public int getDistance(int[] distance) {
        return distance[0] * distance[0] + distance[1] * distance[1];
    }
}

/*
*
* K Closest Points to Origin
*
* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.


Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
* */