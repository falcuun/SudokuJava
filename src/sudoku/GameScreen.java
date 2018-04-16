/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author falcu
 */
public class GameScreen {

    private int DIF;

    public GameScreen(int dif) {
        this.DIF = dif;
    }

    public void startGame() {
        SudokuScreen ss = new SudokuScreen(DIF);
        JButton jb = new JButton("RESULTS");
        JButton jb1 = new JButton("GENERATE NEW");

        // Easy = 40 
        // Medium = 30
        // Hard = 26
        // Extreme = 21
        jb.setFont(new Font("ARIEL", Font.PLAIN, 40));
        jb1.setFont(new Font("ARIEL", Font.PLAIN, 40));

        JFrame frame = new JFrame("Sudoku");

        BorderLayout bl = new BorderLayout();
        bl.addLayoutComponent(jb, BorderLayout.SOUTH);
        bl.addLayoutComponent(ss, BorderLayout.CENTER);
        bl.addLayoutComponent(jb1, BorderLayout.NORTH);

        frame.add(ss);
        frame.add(jb);
        frame.add(jb1);

        frame.setLayout(bl);
        frame.setSize(620, 680);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ss.generateSudoku();
        jb1.addActionListener((ActionEvent e) -> {
            frame.dispose(); 
            start = new StartingScreen();
            start.choosingDif();;
        });

        jb.addActionListener((ActionEvent e) -> {
            ss.win();
        });
    }
    StartingScreen start;
}
