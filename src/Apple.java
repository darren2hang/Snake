import java.util.ArrayList;

public class Apple {
    private Coordinate coordinate;
    private boolean eaten = false;

    public Apple(int row, int col) {
        coordinate = new Coordinate(row, col);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate c) {
        this.coordinate = c;
    }

    public void setRow(int r) {
        coordinate.setR(r);
    }

    public void setCol(int col) {
        coordinate.setC(col);
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }
    public void scramble(ArrayList<Coordinate> s){
        boolean notOverlapping = true;
        int r = (int)(Math.random()*Main.ROW);
        int c = (int)(Math.random()*Main.COL);
        Coordinate coordinate1 = new Coordinate(r,c);
        if (coordinate1.equals(coordinate)){
            notOverlapping=false;
        }
        for (int i = 0; i < s.size(); i++) {
            if (coordinate1.equals(s.get(i))){
                notOverlapping=false;
            }
        }
        if (notOverlapping) {
            setRow(r);
            setCol(c);
        }else{
            scramble(s);
        }
    }
}
