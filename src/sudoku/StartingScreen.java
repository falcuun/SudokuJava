/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author falcu
 */
public class StartingScreen extends JFrame {

    public void choosingDif() {
        JRadioButton jrb = new JRadioButton("EASY");
        JRadioButton jrb1 = new JRadioButton("MEDIUM");
        JRadioButton jrb2 = new JRadioButton("HARD");
        JRadioButton jrb3 = new JRadioButton("EXTREME");
        JButton start = new JButton("START THE GAME!");

        start.setFont(new Font("Arial", Font.PLAIN, 40));
        jrb.setFont(new Font("Arial", Font.PLAIN, 26));
        jrb1.setFont(new Font("Arial", Font.PLAIN, 26));
        jrb2.setFont(new Font("Arial", Font.PLAIN, 26));
        jrb3.setFont(new Font("Arial", Font.PLAIN, 26));
        
        jrb.setFocusable(false);
        jrb1.setFocusable(false);
        jrb2.setFocusable(false);
        jrb3.setFocusable(false);
        start.setFocusable(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb);
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

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
        c.gridy = 5;
        panel.add(start, c);

        jrb.addActionListener((ActionEvent e) -> {
            dif = 41;
        });
        jrb1.addActionListener((ActionEvent e) -> {
            dif = 49;
        });
        jrb2.addActionListener((ActionEvent e) -> {
            dif = 53;
        });
        jrb3.addActionListener((ActionEvent e) -> {
            dif = 59;
        });

        add(panel);
        setSize(620, 680);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        start.addActionListener((ActionEvent e) -> {
            if (dif != 0) {
                GameScreen gs = new GameScreen(dif);
                this.setVisible(false);
                gs.startGame();
            } else {
                JOptionPane.showMessageDialog(this, "Choose Difficulty");
            }
        });
    }

    public int dif;
}
