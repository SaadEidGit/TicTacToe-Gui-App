import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame implements TicTacToeView{

    private JButton[][] buttons;
    private TicTacToeModel model;
    private JOptionPane optionPane;
    public TicTacToeFrame(){
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));
        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        optionPane = new JOptionPane();
        model = new TicTacToeModel();
        model.addTicTacToeView(this);
        TicTacToeController tttc = new TicTacToeController(model);

        for(int i = 0; i < TicTacToeModel.SIZE; i++){
            for(int j = 0; j < TicTacToeModel.SIZE; j++){
                JButton b = new JButton(" ");
                b.setActionCommand(i + " " + j);
                buttons[i][j] = b;
                b.addActionListener(tttc);
                this.add(b);
            }
        }
        this.setSize(300, 300);
        this.setVisible(true);
    }
    @Override
    public void update(TicTacToeEvent e) {
        String label = e.isTurn()? "X": "O";
        buttons[e.getX()][e.getY()].setText(label);
        if (model.getStatus() != TicTacToeModel.Status.UNDECIDED){
            String message = model.getStatus().name();
            optionPane.showMessageDialog(this, message);
        }
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
