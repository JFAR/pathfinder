package mazechallenge;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class PuzzleParser {

    private Maze maze;
    private Position startingPosition;
    private Position endingPosition;

    public static void main(String[] argv) {
        try {
            PuzzleParser puzzleParser = new PuzzleParser(argv[0]);
            Maze maze = puzzleParser.getMaze();
            Position startingPosition = puzzleParser.getStartingPosition();
            Position endPosition = puzzleParser.getEndPosition();

            MazePath path = maze.findPathBetweenStartAndEndPoint(startingPosition, endPosition);

            System.out.println(maze.printPath(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PuzzleParser(String fileLocation) throws IOException {
        String inputAsString = Resources.toString(Resources.getResource(fileLocation), Charsets.UTF_8);
        List<String> rows = Arrays.asList(inputAsString.split("\n"));
        List<String> mazeRows = rows.subList(3, rows.size());

        maze = new Maze(mazeRows);
        startingPosition = new Position(rows.get(1).trim());
        endingPosition = new Position(rows.get(2).trim());
    }

    public Maze getMaze() {
        return maze;
    }

    public Position getStartingPosition() {
        return startingPosition;
    }

    public Position getEndPosition() {
        return endingPosition;
    }

}
