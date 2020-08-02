import processing.core.*;

import java.util.ArrayList;

public class Main extends PApplet {
    public static final int ROW = 20;
    public static final int COL = 20;
    public static final int SIZE = 30;
    public static final int APPLE = 1;
    public static final int SNAKE = 2;
    public static final int EMPTY = 0;
    public static boolean ALIVE = true;
    public static int startingSnakeLength =10;

    Board board;
    Snake snake;
    Apple apple;
    String direction;

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main"});
    }

    public void setup() {
        ALIVE = true;
        size(600, 600);
        board = new Board(ROW, COL);
        apple = new Apple(15, 15);
        snake = new Snake(10, 8, startingSnakeLength, apple);
        direction = "right";
    }

    public void draw() {
        if (ALIVE) {
            snake.move(direction);
            if (ALIVE) {
                board.markBoard(snake, apple);
                drawBoard();
                delay(100);
            }
        } else {
            PFont f = createFont("Arial", 16, true);
            textFont(f, 50);
            fill(0);
            text("GAME OVER!", 150, 250);
            text("Your final score was " + (snake.getSnakebody().size()-startingSnakeLength), 90, 320);
        }

    }

    public void drawBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board.getVal(r, c) == APPLE) {
                    fill(color(101,255,87));
                } else if (board.getVal(r, c) == SNAKE) {
                    fill(color(52, 58, 237));
                } else if (board.getVal(r, c) == EMPTY) {
                    fill(color(101, 255, 87));
                }
                rect(c * SIZE, r * SIZE, SIZE, SIZE);
                if (board.getVal(r,c) == APPLE){
                    fill(color(217, 15, 15));
                    ellipse(c*SIZE+SIZE/2,r*SIZE+SIZE/2,SIZE,SIZE);
                }
            }
        }
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                if (!direction.equals("down")) direction = "up";
            }
            if (keyCode == DOWN) {
                if (!direction.equals("up")) direction = "down";
            }
            if (keyCode == LEFT) {
                if (!direction.equals("right")) direction = "left";
            }
            if (keyCode == RIGHT) {
                if (!direction.equals("left")) direction = "right";
            }
        }

    }
}
