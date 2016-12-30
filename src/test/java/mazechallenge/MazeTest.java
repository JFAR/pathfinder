package mazechallenge;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mazechallenge.Maze;
import mazechallenge.MazePath;
import mazechallenge.Position;
import mazechallenge.PuzzleParser;

public class MazeTest {

    private static final String filename = "small.txt";
    private static final Position startPosition = new Position(1, 1);
    private static final Position wallPosition = new Position(0, 0);
    private static final Position endPosition = new Position(3, 4);
    private Maze maze;
    private static final String prettyPrintedString = "#####\n#SXX#\n# #X#\n# #X#\n# #E#\n#####\n";

    @Before
    public void setup() throws IOException {
        PuzzleParser fileParser = new PuzzleParser(filename);
        maze = fileParser.getMaze();
    }

    @Test
    public void mazeHasPathAtGivenCoordinates() throws IOException {
        assertThat(maze.hasWallAt(wallPosition), is(true));
        assertThat(maze.hasWallAt(startPosition), is(false));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void pathsToAvailableLocationsReturnsMap() {
        Map<Position, MazePath> pathsToAvailableLocations = maze.pathsToAvailableLocations(startPosition, endPosition);
        assertThat(pathsToAvailableLocations, is(Map.class));
        assertThat(pathsToAvailableLocations.get(endPosition), is(MazePath.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void returnsNullWhenNoPathAvailable() {
        Map<Position, MazePath> pathsToAvailableLocations = maze.pathsToAvailableLocations(startPosition, endPosition);
        assertThat(pathsToAvailableLocations, is(Map.class));
        assertThat(pathsToAvailableLocations.get(wallPosition), is(nullValue()));
    }

    @Test
    public void returnValidPathToLocation() {
        Map<Position, MazePath> pathsToAvailableLocations = maze.pathsToAvailableLocations(startPosition, endPosition);
        for (Position position : pathsToAvailableLocations.get(endPosition).positions()) {
            assertThat(position.isOnPathFor(maze), is(true));
        }
    }

    @Test
    public void printMazePath() {
        Map<Position, MazePath> pathsToAvailableLocations = maze.pathsToAvailableLocations(startPosition, endPosition);
        String printPath = maze.printPath(pathsToAvailableLocations.get(endPosition));
        System.out.println(printPath);
        assertThat(printPath, is(prettyPrintedString));
    }
}
