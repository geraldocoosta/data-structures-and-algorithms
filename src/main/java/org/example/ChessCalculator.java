package org.example;

public class ChessCalculator {
    interface Calculate {
        int calculate(int[][] board, int column, int row, int size);
    }

    enum Positions implements Calculate {
        UP {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, -1, 0, size);
            }
        }, DOWN {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, 1, 0, size);
            }
        }, LEFT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, 0, -1, size);
            }
        }, RIGHT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, 0, +1, size);
            }
        }, UPLEFT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, -1, -1, size);
            }
        }, UPRIGHT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, -1, +1, size);
            }
        }, DOWNLEFT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, +1, -1, size);
            }
        }, DOWNRIGHT {
            public int calculate(int[][] board, int column, int row, int size) {
                return calculate(board, column, row, +1, +1, size);
            }
        };

        public int calculate(int[][] board, int column, int row, int incrementRow, int incrementColumn, int size) {
            var result = 0;
            row += incrementRow;
            column += incrementColumn;


            while (column >= 0 && column < size &&
                    row >= 0 && row < size
            ) {

                if (board[row][column] == 1) {
                    break;
                }

                result++;
                row += incrementRow;
                column += incrementColumn;
            }

            return result;
        }
    }

    public int countQueenMovies(int[][] board, int row, int column) {
        var result = 0;
        var size = board.length;

        for (var position : Positions.values()) {
            result += position.calculate(board, row, column, size);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new ChessCalculator().countQueenMovies(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                }, 3, 3)

        );
    }
}
