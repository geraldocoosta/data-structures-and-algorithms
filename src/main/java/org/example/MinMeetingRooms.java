package org.example;

import java.util.Arrays;

public class MinMeetingRooms {

    public static void main(String[] args) {

        System.out.println(new MinMeetingRooms().minMeetingRooms(new int[][]{
                {2,10},
                {5,15},
                {10,18},
                {15,13}
        }));
    }

    // Complexidade Spacial -> O (N) + O(N) -> por que criamos dois arrays de tamanho N auxiliares
    // Complexidade Tempo -> O(n log n) +  O(n log n) + O(n) onde n é quantidade de reuniões

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // horario que começa uma reunião e horario que termina uma reunião
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Ordenando arrays com os horarios de entrada e horarios de saidas das reuniões
        Arrays.sort(starts);
        Arrays.sort(ends);

        // Para encontrar o menor numero de salas
        int rooms = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < len) {
            // se uma reunião começar antes de outra terminar, aumentamos o numero de salas
            if (starts[startIndex] < ends[endIndex]) {
                rooms++;
            } else {
                // se não, vamos verificar a proxima reunião que irá terminar
                endIndex++;
            }
            startIndex++;
        }

        return rooms;
    }
}

/*
Meeting Rooms II

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106


perguntas a se fazer
qual os valores maximos de entrada e saida reuniões?
quais o maximo de reuniões que vou receber?

 */