/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author falcu
 */
public class Sudoku {

    public static void main(String[] args) {
        int dif = 40;
        
        JRadioButton jrb = new JRadioButton("EASY");
        JRadioButton jrb1 = new JRadioButton("MEDIUM");
        JRadioButton jrb2 = new JRadioButton("HARD");
        JRadioButton jrb3 = new JRadioButton("EXTREME");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb);
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.setSelected(jrb.getModel(), true);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 1;
        panel.add(jrb, c);
        c.gridy = 2;
        panel.add(jrb1, c);
        c.gridy = 3;
        panel.add(jrb2, c);
        c.gridy = 4;
        panel.add(jrb3, c);
        
        if (jrb.isSelected()) {
            dif = 40;
        }
        if (jrb1.isSelected()) {
            dif = 32;
        }
        if (jrb2.isSelected()) {
            dif = 28;
        }
        if (jrb3.isSelected()) {
            dif = 22;
        }

        SudokuScreen ss = new SudokuScreen(dif);
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
        bl.addLayoutComponent(panel, BorderLayout.EAST);

        frame.add(ss);
        frame.add(jb);
        frame.add(jb1);
        frame.add(panel);

        frame.setLayout(bl);
        frame.setSize(620, 680);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        jb1.addActionListener((ActionEvent e) -> {
            ss.generateSudoku();
        });

        jb.addActionListener((ActionEvent e) -> {
            ss.win();
        });

    }

}
