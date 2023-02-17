import static org.junit.Assert.*;

public class TicTacToeModelTest {

    @org.junit.Test
    public void initialStatusMustBeUndecided() {
        TicTacToeModel m = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
    }

    @org.junit.Test
    public void testXWonByRow() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,2);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testXWonByColumn() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testXWonDiagonally() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonByRow() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,2);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonByColumn() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,1);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonDiagonally() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    /*
    x o x
    o x x
    o x o
     */
    @org.junit.Test
    public void testGameTie() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(0,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(1,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
        m.play(2,1);
        assertEquals(TicTacToeModel.Status.TIE, m.getStatus());
    }
}