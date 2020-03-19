import java.util.ArrayList;

public class Snake {
    private int length;
    private ArrayList<Coordinate> snakebody;
    private int startingSnakeLength;
    private Apple a;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSnakebody(ArrayList<Coordinate> snakebody) {
        this.snakebody = snakebody;
    }

    public Snake(int r, int c, int startingSnakeLength, Apple a) {
        this.startingSnakeLength = startingSnakeLength;
        this.a = a;
        snakebody = new ArrayList<>();
        for (int i = 0; i < startingSnakeLength; i++) {
            if (c - 1 > 0) {
                snakebody.add(new Coordinate(r, c - i));

            }
        }
    }

    public ArrayList<Coordinate> getSnakebody() {
        return snakebody;
    }

    public void move(String direction) {
        Coordinate head = snakebody.get(0);
        int x = 0;
        int y = 0;
        if (direction.equals("down")) y = 1;
        if (direction.equals("up")) y = -1;
        if (direction.equals("right")) x = 1;
        if (direction.equals("left")) x = -1;
        Coordinate nextSpot = new Coordinate(head.getR() + y, head.getC() + x);
        if (nextSpot.isOutOfBounds()) {
            Main.ALIVE = false;
        }
        for (int i = 0; i < snakebody.size()-1; i++) {
            if (nextSpot.overlaps(snakebody.get(i))) Main.ALIVE = false;
        }
        if (Main.ALIVE) {
            if (nextSpot.overlaps(a.getCoordinate())) {
                a.scramble(snakebody);
                snakebody.add(0, new Coordinate(head.getR() + y, head.getC() + x));
            } else {
                snakebody.remove(snakebody.size() - 1);
                snakebody.add(0, nextSpot);
            }
        }
    }

//    public ArrayList<Coordinate> getNextSnakePosition(String direction) {
//        ArrayList<Coordinate> newsnakebody = new ArrayList<>();
//        if (direction == "up") {
//            snakebody.add(0, new Coordinate(snakebody.get(0).getR() - 1, snakebody.get(0).getC()));
//            snakebody.remove(snakebody.size() - 1);
//            return snakebody;
//        } else if (direction == "down") {
//            snakebody.add(0, new Coordinate(snakebody.get(0).getR() + 1, snakebody.get(0).getC()));
//            snakebody.remove(snakebody.size() - 1);
//            return snakebody;
//        } else if (direction == "left") {
//            snakebody.add(0, new Coordinate(snakebody.get(0).getR(), snakebody.get(0).getC() - 1));
//            snakebody.remove(snakebody.size() - 1);
//            return snakebody;
//        } else if (direction == "right") {
//            snakebody.add(0, new Coordinate(snakebody.get(0).getR() - 1, snakebody.get(0).getC() + 1));
//            snakebody.remove(snakebody.size() - 1);
//            return snakebody;
//        } else {
//            return snakebody;
//        }
//
//    }
}
