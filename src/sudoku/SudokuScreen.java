/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class SudokuScreen extends JPanel {

    private GridLayout gridLaout;
    public final JButton[][] grid = new JButton[9][9];
    private int n = 1;
    private String number = String.valueOf(n);

    public void init() {

        makeBox();
    }

    public void makeBox() {
        gridLaout = new GridLayout(9, 9);

        setLayout(gridLaout);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                grid[x][y] = new JButton();
                grid[x][y].setActionCommand("Button" + x + y);
                grid[x][y].setFocusable(false);
                grid[x][y].setFont(new Font("Arial", Font.PLAIN, 40));
                grid[x][y].addActionListener((ActionEvent e) -> {
                    Object source = e.getSource();
                    for (JButton[] dim1 : grid) {
                        for (JButton button : dim1) {
                            if (button == source) {
                                int xy;
                                if (button.getText().isEmpty() || button.getText() == null) {
                                    xy = 0;
                                } else {
                                    xy = Integer.parseInt(button.getText());
                                }
                                if (xy < 9) {
                                    xy++;
                                    button.setText(String.valueOf(xy));
                                } else {
                                    xy = 1;
                                    button.setText(String.valueOf(xy));

                                }
                            }
                        }
                    }
                });

                this.add(grid[x][y]);
            }
        }
        generateBorders();
        // generateSudoku();
    }

    private void generateBorders() {
        //first box
        grid[0][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[0][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[0][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[2][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[2][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[2][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //second box
        grid[2][3].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[2][4].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[2][5].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[1][3].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[1][4].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[1][5].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[0][3].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[0][4].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        grid[0][5].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        //third box     
        grid[2][6].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[2][7].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[2][8].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[1][6].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[1][7].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[1][8].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[0][6].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[0][7].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        grid[0][8].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        //fourth box
        grid[3][0].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[3][1].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[3][2].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[4][0].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[4][1].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[4][2].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[5][0].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[5][1].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        grid[5][2].setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        //fifth box
        grid[3][3].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[3][4].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[3][5].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[4][3].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[4][4].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[4][5].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[5][3].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[5][4].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        grid[5][5].setBorder(BorderFactory.createLineBorder(new Color(132, 76, 27), 2));
        //sixth box
        grid[3][6].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[3][7].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[3][8].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[4][6].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[4][7].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[4][8].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[5][6].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[5][7].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        grid[5][8].setBorder(BorderFactory.createLineBorder(new Color(91, 25, 196), 2));
        //seventh box
        grid[6][0].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[6][1].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[6][2].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[7][0].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[7][1].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[7][2].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[8][0].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[8][1].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
        grid[8][2].setBorder(BorderFactory.createLineBorder(new Color(213, 67, 249), 2));
//        //eight box
        grid[6][6].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[6][7].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[6][8].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[7][6].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[7][7].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[7][8].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[8][6].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[8][7].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
        grid[8][8].setBorder(BorderFactory.createLineBorder(new Color(32, 91, 9), 2));
//        //ninth box
        grid[6][3].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[6][4].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[6][5].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[7][3].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[7][4].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[7][5].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[8][3].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[8][4].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        grid[8][5].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
    }

    public void generateSudoku() {

        int[][] table = new int[9][9];
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int x = 0; x < 9; x++) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    Random rn = new Random();
                    int range = 9 - 1 + 1;
                    int randomNum = rn.nextInt(range) + 1;
                    table[0][randomNum - 1] = numbers[x];
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (String.valueOf(table[i][j]).equals(String.valueOf(0))) {
                    grid[i][j].setText("");
                } else {
                    grid[i][j].setText(String.valueOf(table[i][j]));
                }
            }
        }

    }

    public void buttonActionPerformed(ActionEvent ea) {
        if (n < 9) {
            n++;
            System.out.println(n);

        } else {
            n = 1;
            System.out.println(n);
        }

    }

    public boolean checkForDuplicatesColumn(int[][] arr) {
        int current;
        int previous;
        boolean check = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                previous = arr[j][i];
                for (int x = 0; x < 9; x++) {
                    current = arr[x][i];
                    if (x == j) {
                        continue;
                    }
                    if (current == previous) {
                        System.out.println("Current Column num is: " + i + j + x);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkForDuplicatesRow(int[][] arr) {
        int current;
        int previous;
        boolean check = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                previous = arr[i][j];
                for (int x = 0; x < 9; x++) {
                    current = arr[i][x];
                    if (x == j) {
                        continue;
                    }
                    if (current == previous) {
                        System.out.println("Current Row num is: " + i + j + x);
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public SudokuScreen() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SudokuScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        init();
    }

}
