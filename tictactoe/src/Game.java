import java.rmi.Remote;

public class Game implements Remote {

        private String[][] board = {{"   ","   ","   "}, {"   ","   ","   "}, {"   ","   ","   "}};
        private String currentPlayer = "X";
        private String winner = null;
        private int moveNum = 0;

        public String displayBoard() {
            String print = " ";
            for (String[] row : board){
                for (String cell : row){
                    print += "|" + cell;
                } print = "|\n----------------\n";
            }
            return print;
        }
        public boolean  setMove(int x, int y, String player) {

            if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3)){
                x= x - 1;
                y = y - 1;
            }
            if(!player.equals(currentPlayer))
                return false;

            if (board[x][y].equals("X") ||board[x][y].equals("O"))
                return false;

            String a = " " + player + " ";
            board[x][y] = a;

            if (board[x][0].equals(a) && board[x][1].equals(a) && board[x][2].equals(a))
                winner = player;

            if (board[0][y].equals(a) && board[1][y].equals(a) && board[2][y].equals(a))
                winner = player;

            if (x == y || x == (3 - y)) {
                if (board[0][0].equals(a) && board[2][2].equals(a))
                    winner = player;
                if (board[0][2].equals(a) && board[2][0].equals(a))
                    winner = player;
            }

            if (currentPlayer.equals("X"))
                currentPlayer = "O";
            else if (currentPlayer.equals("O"))
                currentPlayer = "X";

            System.out.println(currentPlayer);

            moveNum++;

            return true;

        }

        public String checkVictory() {
            if (moveNum == 9){
                return "draw";
            } return winner;
        }
    }

