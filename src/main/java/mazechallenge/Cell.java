package mazechallenge;

public class Cell {

    private boolean isWall;

    public Cell(String cell) {
        this.isWall = Integer.valueOf(cell) == 1;
    }

    public boolean isWall() {
        return isWall;
    }

}
