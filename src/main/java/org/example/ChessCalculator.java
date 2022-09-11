package org.example;

public class ChessCalculator {

    public static void main(String[] args) {
        System.out.println(
                new ChessCalculator().countQueenMovies(new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                }, 3, 3)

        );
    }

    public int countQueenMovies(int[][] board, int row, int column) {
        var result = 0;
        var size = board.length;

        int[][] positions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };

        for (var position : positions) {
            result += calculate(board, row, column, size, position[0], position[1]);
        }

        return result;
    }

    private int calculate(int[][] board, int row, int column, int size, int rowIncreasing, int columnIncreasing) {
        var result = 0;
        row += rowIncreasing;
        column += columnIncreasing;

        while ( row >= 0 && column >= 0 && row < size && column < size) {
            if (board[row][column] == 1) {
                break;
            }
            result++;
            row += rowIncreasing;
            column += columnIncreasing;
        }
        return result;
    }
}
