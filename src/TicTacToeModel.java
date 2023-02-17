import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;
    private int numFreeSpaces = 8;
    private List<TicTacToeView> views;

    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
    }
    public void addTicTacToeView(TicTacToeView v){
        views.add(v);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {
        boolean haveWinner = false;
        if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] != ' '){
            haveWinner = true;
        }else if(grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] != ' '){
            haveWinner = true;
        }else if(grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] != ' '){
            haveWinner = true;
        }else if(grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[0][0] != ' '){
            haveWinner = true;
        }else if(grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[0][1] != ' '){
            haveWinner = true;
        }else if(grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[0][2] != ' '){
            haveWinner = true;
        }else if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' '){
            haveWinner = true;
        }else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' '){
            haveWinner = true;
        }

        if(haveWinner && getTurn()){
            status = Status.X_WON;
        }else if(haveWinner && !getTurn()){
            status = Status.O_WON;
        }else if(!haveWinner && numFreeSpaces == 0) {
            status = Status.TIE;
        }
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();

        for (TicTacToeView v: views){
            v.update(new TicTacToeEvent(this, x, y, turn, status));
        }
        numFreeSpaces--;
        changeTurn();
    }
}

