package mazechallenge;

import common.Equals;
import common.HashCode;
import common.ToString;

public class Position {

    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String startPosition) {
        String[] position = startPosition.split(" ");
        this.x = Integer.valueOf(position[0].trim());
        this.y = Integer.valueOf(position[1].trim());
    }

    public boolean isAdjacent(Position nextStep) {
        int xDiff = nextStep.x - x;
        int yDiff = nextStep.y - y;

        if (xDiff * xDiff + yDiff * yDiff == 1) {
            return true;
        }
        return false;
    }

    public boolean isOnPathFor(Maze maze) {
        if (maze.getCell(x, y) != null) {
            return !maze.getCell(x, y).isWall();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToString.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return Equals.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCode.reflectionHashCode(this);
    }
}
