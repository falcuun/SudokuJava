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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class SudokuScreen extends JPanel {

    private GridLayout gridLaout;
    public JButton[][] grid = new JButton[9][9];
    private int n = 1;
    private String number = String.valueOf(n);
    private int[][] table = new int[9][9];
    public int DIFFICULTY;
    private StartingScreen startScreen;
    private GameScreen gs;

    public void init() {
        makeBox();
        nextBoard();
    }

    private MouseListener ms = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (SwingUtilities.isRightMouseButton(e)) {
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
                            if (xy > 1) {
                                xy--;
                                button.setText(String.valueOf(xy));
                            } else {
                                xy = 9;
                                button.setText(String.valueOf(xy));
                            }
                        }
                    }
                }
            }

            if (SwingUtilities.isMiddleMouseButton(e)) {
                Object source = e.getSource();
                for (JButton[] dim1 : grid) {
                    for (JButton button : dim1) {
                        if (button == source) {
                            int xy;
                            if (!button.getText().isEmpty()) {
                                xy = 0;
                                button.setText("");
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }
    };

    private void lockedKeys() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (!grid[x][y].getText().isEmpty()) {
                    grid[x][y].setEnabled(false);
                    grid[x][y].removeMouseListener(ms);

                }
            }
        }
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
                grid[x][y].addMouseListener(ms);
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
        //third box     
        grid[2][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[2][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[2][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[1][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[0][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[0][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[0][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //fifth box
        grid[3][3].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[3][4].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[3][5].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[4][3].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[4][4].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[4][5].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[5][3].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[5][4].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[5][5].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //seventh box
        grid[6][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[6][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[6][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//        //ninth box
        grid[6][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[6][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[6][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[7][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][6].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        grid[8][8].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public int[][] nextBoard() {
        nextCell(0, 0);
        makeHoles(DIFFICULTY);
        return table;
    }

    public void generateSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (String.valueOf(table[i][j]).equals(String.valueOf(0))) {
                    grid[i][j].setText("");
                } else {
                    grid[i][j].setText(String.valueOf(table[i][j]));
                }
            }
        }
        lockedKeys();
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

    public SudokuScreen(int dif) {
        this.DIFFICULTY = dif;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SudokuScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        init();
    }

    private boolean nextCell(int x, int y) {
        int nextX = x;
        int nextY = y;
        int[] toCheck = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random r = new Random();
        int tmp = 0;
        int current = 0;
        int top = toCheck.length;

        for (int i = top - 1; i > 0; i--) {
            current = r.nextInt(i);
            tmp = toCheck[current];
            toCheck[current] = toCheck[i];
            toCheck[i] = tmp;
        }

        for (int i = 0; i < toCheck.length; i++) {
            if (legalMove(x, y, toCheck[i])) {
                table[x][y] = toCheck[i];
                if (x == 8) {
                    if (y == 8) {

                        return true;//We're done!  Yay!
                    } else {
                        nextX = 0;
                        nextY = y + 1;
                    }
                } else {
                    nextX = x + 1;
                }
                if (nextCell(nextX, nextY)) {
                    return true;
                }
            }
        }
        table[x][y] = 0;

        return false;
    }

    private boolean legalMove(int x, int y, int current) {
        for (int i = 0; i < 9; i++) {
            if (current == table[x][i]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (current == table[i][y]) {
                return false;
            }
        }
        int cornerX = 0;
        int cornerY = 0;
        if (x > 2) {
            if (x > 5) {
                cornerX = 6;
            } else {
                cornerX = 3;
            }
        }
        if (y > 2) {
            if (y > 5) {
                cornerY = 6;
            } else {
                cornerY = 3;
            }
        }
        for (int i = cornerX; i < 10 && i < cornerX + 3; i++) {
            for (int j = cornerY; j < 10 && j < cornerY + 3; j++) {
                if (current == table[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void makeHoles(int holesToMake) {
        double remainingSquares = 81;
        double remainingHoles = (double) holesToMake;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                double holeChance = remainingHoles / remainingSquares;
                if (Math.random() <= holeChance) {
                    table[i][j] = 0;
                    remainingHoles--;
                }
                remainingSquares--;
            }
        }
    }

}
