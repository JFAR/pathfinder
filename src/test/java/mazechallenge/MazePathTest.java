package mazechallenge;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import mazechallenge.Maze;
import mazechallenge.MazePath;
import mazechallenge.NextStepNotAdajcent;
import mazechallenge.Position;
import mazechallenge.PuzzleParser;

public class MazePathTest {

    private Maze maze;

    @Before
    public void before() throws IOException {
        PuzzleParser puzzleParser = new PuzzleParser("small.txt");
        maze = puzzleParser.getMaze();
    }

    @Test(expected = NextStepNotAdajcent.class)
    public void nextStepThrowsErrorIfNotAdjacent() {
        MazePath path = new MazePath(maze, new Position(1, 1));
        path.nextStep(new Position(1, 3));
    }

    @Test
    public void nextStepDoesNotThrowErrorIfAdjacent() {
        MazePath path = new MazePath(maze, new Position(1, 1));
        path.nextStep(new Position(1, 2));
    }
}
