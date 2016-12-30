package mazechallenge;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import mazechallenge.Maze;
import mazechallenge.Position;
import mazechallenge.PuzzleParser;

public class PuzzleParserTest {

    PuzzleParser fileParser;

    @Before
    public void setup() throws IOException {
        fileParser = new PuzzleParser("small.txt");
    }

    @Test
    public void createsMazeWithRightDimensionsForFileReadIn() throws IOException {
        Maze maze = fileParser.getMaze();
        assertThat(maze.height(), is(6));
        assertThat(maze.width(), is(5));
    }

    @Test
    public void createsMazeWithStartPosition() {
        Position startingPosition = fileParser.getStartingPosition();
        assertThat(startingPosition, is(new Position(1, 1)));
    }

    @Test
    public void createsMazeWithEndPosition() {
        Position endPosition = fileParser.getEndPosition();
        assertThat(endPosition, is(new Position(3, 4)));
    }

}
