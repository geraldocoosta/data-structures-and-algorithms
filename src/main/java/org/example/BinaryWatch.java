package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public static void main(String[] args) {
        var teste = new BinaryWatch().readBinaryWatch(8);
        System.out.println(teste);
    }
    public List<String> readBinaryWatch(int turnedOn) {
        var values = new int[][]{
                {1, 0},
                {2, 0},
                {4, 0},
                {8, 0},
                {0, 1},
                {0, 2},
                {0, 4},
                {0, 8},
                {0, 16},
                {0, 32},
        };

        var res = new ArrayList<String>();
        backtracking(values, res, 0, 0, 0, 0, turnedOn);
        return res;
    }

    public void backtracking(int[][] values,
                             List<String> res,
                             int path,
                             int hour,
                             int minute,
                             int startIndex,
                             int turnedOn) {
        if (path == turnedOn) {
            res.add(String.format("%d:%02d", hour, minute));
            return;
        }
        for (int i = startIndex; i < values.length; i++) {
            var newHour = hour + values[i][0];
            var newMinute = minute + values[i][1];

            if (newHour >= 12) {
                continue;
            }
            if (newMinute >= 60) {
                break;
            }
            backtracking(values, res, path + 1,  newHour, newMinute, i + 1, turnedOn);
        }
    }
}
