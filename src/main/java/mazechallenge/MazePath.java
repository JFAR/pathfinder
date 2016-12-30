package mazechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import common.Equals;
import common.HashCode;
import common.ToString;

public class MazePath {

    private List<Position> path;
    private Maze maze;
    private List<Position> neighbours = Arrays.asList(new Position(1, 0), new Position(0, 1), new Position(0, -1), new Position(-1, 0));

    public MazePath(Maze maze) {
        this(maze, new ArrayList<Position>());
    }

    public MazePath(Maze maze, Position start) {
        this(maze, Arrays.asList(start));
    }

    public MazePath(Maze maze, List<Position> path) {
        this.maze = maze;
        this.path = path;
    }

    public Object get(int i) {
        return path.get(i);
    }

    public Position last() {
        return path.get(path.size() - 1);
    }

    public MazePath nextStep(Position nextStep) {
        List<Position> newPath = new ArrayList<Position>(path);
        if (!last().isAdjacent(nextStep)) {
            throw new NextStepNotAdajcent();
        } else if (!nextStep.isOnPathFor(maze)) {
            throw new NextStepNotInMaze();
        } else {
            newPath.add(nextStep);
        }
        return new MazePath(maze, newPath);
    }

    public Set<Position> neighbours(Maze maze) {
        return neighbours.stream().map(n -> new Position(last().x + n.x, last().y + n.y)).filter(n -> n.isOnPathFor(maze))
                .collect(Collectors.toSet());
    }

    public Collection<MazePath> pathsToValidNeighbours() {
        Collection<MazePath> pathsToNeighbours = new ArrayList<MazePath>();
        for (Position neighbour : neighbours(maze)) {
            MazePath nextStep;
            try {
                nextStep = nextStep(neighbour);
                pathsToNeighbours.add(nextStep);
            } catch (NextStepNotAdajcent e) {
                e.printStackTrace();
            } catch (NextStepNotInMaze e) {
                e.printStackTrace();
            }
        }
        return pathsToNeighbours;
    }

    public List<Position> positions() {
        return path;
    }

    public boolean contains(Position position) {
        return path.contains(position);
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
