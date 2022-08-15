package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    }

    // Como as células têm um tamanho fixo de 8,
    // mas a primeira e a última célula não serão atualizadas porque não possuem dois vizinhos adjacentes,
    // temos no máximo 2^6 = 64 estados.
    // Portanto, independentemente da entrada N, temos complexidades de espaço e tempo como O(1).
    public int[] prisonAfterNDays(int[] cells, int days) {
        if (cells == null || cells.length == 0 || days <= 0) return cells;

        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < days; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) { //store cell state
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if (hasCycle) {
            days = days % cycle;
            for (int i = 0; i < days; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return tmp;
    }
}

/*

There are 8 prison cells in a row and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.

Return the state of the prison after n days (i.e., n such changes described above).



Example 1:

Input: cells = [0,1,0,1,1,0,0,1], n = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
Example 2:

Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
Output: [0,0,1,1,1,1,1,0]


Constraints:

cells.length == 8
cells[i] is either 0 or 1.
1 <= n <= 109




*/