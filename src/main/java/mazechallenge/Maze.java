package mazechallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {

    private List<Row> rows;

    public Maze(List<String> mazeRows) {
        rows = new ArrayList<Row>();

        for (String row : mazeRows) {
            rows.add(new Row(row.trim()));
        }
    }

    public boolean hasWallAt(Position position) {
        return rows.get(position.x).getCell(position.y).isWall();
    }

    public Integer height() {
        return rows.size();
    }

    public Integer width() {
        return rows.get(0).width();
    }

    public Cell getCell(int x, int y) {
        try {
            return rows.get(y).getCell(x);
        } catch (Exception e) {
            return null;
        }
    }

    public Map<Position, MazePath> pathsToAvailableLocations(Position start, Position end) {
        Map<Position, MazePath> paths = new HashMap<Position, MazePath>();
        MazePath startingPath = new MazePath(this, start);
        paths.put(start, startingPath);

        Map<Position, MazePath> newPaths = new HashMap<Position, MazePath>();
        for (int i = 0; i < height() * width(); i++) {
            newPaths = newPathsFromOld(paths);

            if (newPaths.size() == 0 || paths.containsKey(end)) {
                return paths;
            }

            paths.putAll(newPaths);
        }
        return paths;
    }

    private Map<Position, MazePath> newPathsFromOld(Map<Position, MazePath> paths) {
        Map<Position, MazePath> newPaths = new HashMap<Position, MazePath>();
        for (MazePath path : paths.values()) {
            Collection<MazePath> neighbours = path.pathsToValidNeighbours();

            for (MazePath neighbour : neighbours) {
                if (!paths.containsKey(neighbour.last())) {
                    newPaths.put(neighbour.last(), neighbour);
                }
            }
        }
        return newPaths;
    }

    public MazePath findPathBetweenStartAndEndPoint(Position start, Position end) {
        Map<Position, MazePath> pathsToAvailableLocations = pathsToAvailableLocations(start, end);
        return pathsToAvailableLocations.get(end);
    }

    public String printPath(MazePath mazePath) {
        String output = "";
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            for (int j = 0; j < row.width(); j++) {
                if (row.getCell(j).isWall()) {
                    output += "#";
                } else {
                    Position position = new Position(j, i);
                    if (position.equals(mazePath.get(0))) {
                        output += "S";
                    } else if (position.equals(mazePath.last())) {
                        output += "E";
                    } else if (mazePath.contains(position)) {
                        output += "X";
                    } else {
                        output += " ";
                    }
                }
            }
            output += "\n";
        }
        return output;
    }

}
