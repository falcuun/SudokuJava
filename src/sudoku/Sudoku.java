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
import javax.swing.JOptionPane;

/**
 *
 * @author falcu
 */
public class Sudoku {

    public static void main(String[] args) {

        SudokuScreen ss = new SudokuScreen();
        JButton jb = new JButton("RESULTS");
        JButton jb1 = new JButton("GENERATE NEW");
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
        frame.setSize(600, 680);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        jb1.addActionListener((ActionEvent e) -> {
            ss.generateSudoku();
        });

        jb.addActionListener((ActionEvent e) -> {
            int[][] table = new int[9][9];
            try {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        table[col][row] = Integer.parseInt(ss.grid[row][col].getText());

                    }
                }
                System.out.println(ss.checkForDuplicatesRow(table));
                System.out.println(ss.checkForDuplicatesColumn(table));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You don't have all the numbers, mate");
            }
        });

    }

}
