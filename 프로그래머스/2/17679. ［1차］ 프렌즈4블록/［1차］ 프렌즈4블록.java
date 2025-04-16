class Solution {
    static String[][] board;
    static int m;
    static int n;
    static boolean[][] deleteBoard;
    static int answer;

    public int solution(int m, int n, String[] inputBoard) {
        this.m = m;
        this.n = n;
        board = new String[m][n];
        answer = 0;

        for (int i = 0; i < m; i++) {
            board[i] = inputBoard[i].split("");
        }

        while (true) {
            deleteBoard = new boolean[m][n];
            checkDelete();

            int deleted = countDeleted();
            if (deleted == 0) break;
            answer += deleted;

            applyGravity();
        }

        return answer;
    }

    public static void checkDelete() {
        for (int y = 0; y < m - 1; y++) {
            for (int x = 0; x < n - 1; x++) {
                String current = board[y][x];
                if (current.equals(" ")) continue;

                if (current.equals(board[y][x + 1]) &&
                    current.equals(board[y + 1][x]) &&
                    current.equals(board[y + 1][x + 1])) {

                    deleteBoard[y][x] = true;
                    deleteBoard[y][x + 1] = true;
                    deleteBoard[y + 1][x] = true;
                    deleteBoard[y + 1][x + 1] = true;
                }
            }
        }
    }

    public static int countDeleted() {
        int count = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (deleteBoard[y][x]) {
                    board[y][x] = " ";
                    count++;
                }
            }
        }
        return count;
    }

    public static void applyGravity() {
        for (int x = 0; x < n; x++) {
            int emptyRow = m - 1;
            for (int y = m - 1; y >= 0; y--) {
                if (!board[y][x].equals(" ")) {
                    board[emptyRow][x] = board[y][x];
                    if (emptyRow != y) {
                        board[y][x] = " ";
                    }
                    emptyRow--;
                }
            }
        }
    }
}
