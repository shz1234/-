import javax.swing.*;
import java.awt.*;

public class GOFGUI extends JFrame{

    public static void main(String[] args) {
        int i, j;
        GameOfLife.InitCELLS();
        GameOfLife.SyncTemp();
        JFrame MainUI = new JFrame();
        GridLayout layout = new GridLayout(GameOfLife.SIZE, GameOfLife.SIZE);
        MainUI.setLayout(layout);
        JButton[][] CellsView = new JButton[GameOfLife.SIZE][GameOfLife.SIZE];
        for (i = 0; i < GameOfLife.SIZE; i++)
            for (j = 0; j < GameOfLife.SIZE; j++) {
                CellsView[i][j]=new JButton();
                MainUI.add(CellsView[i][j]);
            }
        MainUI.setSize(500,500);
        MainUI.setTitle("ÉúÃüÓÎÏ·");
        MainUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainUI.setVisible(true);
        while(true){
            for (i = 0; i < GameOfLife.SIZE; i++)
                for (j = 0; j < GameOfLife.SIZE; j++){
                    if(GameOfLife.isCell(i,j)==0)
                        CellsView[i][j].setBackground(Color.WHITE);
                    else
                        CellsView[i][j].setBackground(Color.cyan);
                }
            try {
                    GameOfLife.nextStage();
                    GameOfLife.SyncTemp();
                    Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.exit(1);
            }
        }
    }
}
