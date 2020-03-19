public class Coordinate {
    private int r, c;
    public Coordinate(int r, int c){
        this.r = r;
        this.c = c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }
    public boolean overlaps(Coordinate coor){
        if (this.r ==coor.getR() && this.c == coor.getC()){
            return true;
        }
        return false;
    }
    public boolean isOutOfBounds(){
        if (this.getR()>=Main.ROW || this.getR()<0) {
            return true;
        }
        if (this.getC()>=Main.COL || this.getC() <0){
            return true;
        }
        return false;
    }
}
