import processing.core.PApplet;

import java.util.EmptyStackException;

public class Board {
//    protected int row,col,size;
    protected PApplet screen;
    private int [][] grid;

    public Board(int row, int col){
        grid = new int [row][col];

    }

    public void markBoard(Snake s, Apple a){
        for (int r = 0; r < Main.ROW; r++) {
            for (int c = 0; c < Main.COL; c++) {
                grid[r][c] = Main.EMPTY;
            }
        }
        for (int i = 0; i < s.getSnakebody().size(); i++) {
            Coordinate current = s.getSnakebody().get(i);
            grid[current.getR()][current.getC()] = Main.SNAKE;
        }
        grid[a.getCoordinate().getR()][a.getCoordinate().getC()]=Main.APPLE;
    }

//    public int getRow() {
//        return row;
//    }
//
//    public void setRow(int row) {
//        this.row = row;
//    }
//
//    public int getCol() {
//        return col;
//    }
//
//    public void setCol(int col) {
//        this.col = col;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    public void set(int r, int c,int val){
        grid[r][c] = val;
    }
    public int getVal(int r, int c){
        return grid[r][c];
    }

}
