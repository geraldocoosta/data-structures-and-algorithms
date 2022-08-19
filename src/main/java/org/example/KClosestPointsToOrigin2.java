package org.example;

import java.util.Arrays;

public class KClosestPointsToOrigin2 {

    //Time Complexity: O(N), in best and medium case, is O(N²) in worst case.
    //
    //Space Complexity: O(N) in worst case.


    public static void main(String[] args) {
        int[][] ints = new KClosestPointsToOrigin2().kClosest(new int[][]{{5, 0},{4, 0}, {1, 0}, {7,0}, {3,0}}, 3);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        // Priority queue implementa um heap
        // se é max ou min será decidido com o comparator que eu passo como parametro
        sort(points, k, 0, points.length - 1);

        int[][] ints = new int[k][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = points[i];
        }

        return ints;
    }


    public void sort(int[][] points, int k, int lower, int highest) {
        if (lower >= highest) {
            return;
        }

        int pivot = partition(points, lower, highest);

        if (pivot > k) {
            // se meu pivot é maior que K, o pivot tem que vir para a esquerda
            sort(points, k, lower, pivot - 1);
        } else if (pivot < k) {
            // Se meu pivot é menor que K, o pivot tem que ir para a direita
            sort(points, k, pivot + 1, highest);
        }
    }

    private int partition(int[][] points, int left, int right) {
        // meu pivo vai ser o elemento da direita
        int pivot = getDistance(points[right]);
        // auxiliar é um segundo ponteiro que marca a posição que vai switar com o pivo
        int aux = left;

        // pra cada elemento
        for (int i = left; i < right; i++) {
            // se o elemento points[i] for menor que o pivo
            // quer dizer que esse elemento tem que estar a esquerda do pivo
            if (getDistance(points[i]) <pivot) {

                // dito isso, eu faço um swap
                int[] temp = points[aux];

                // aux recebe um elemento menor que o pivo
                points[aux] = points[i];
                // i recebe o elemento que é maior que o pivo
                points[i] = temp;

                // aux anda uma casa, pois marca pois depois desse for
                // farei um swit entre o aux e o pivot, garantindo que a esquerda do pivo tenha apenas elementos
                // menores que ele
                aux++;
            }
        }

        // aqui, nos pegamos o pivo, e colocamos na posição correta, pois
        int[] temp = points[aux];
        points[aux] = points[right];
        points[right] = temp;

        return aux;
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