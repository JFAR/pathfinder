package mazechallenge;

import java.io.IOException;

import org.junit.Test;

import mazechallenge.PuzzleParser;

public class PuzzleTest {

    @Test
    public void inputTest() throws IOException {
        solveMazeAt("input.txt");
    }

    @Test
    public void smallTest() throws IOException {
        solveMazeAt("small.txt");
    }

    @Test
    public void mediumTest() throws IOException {
        solveMazeAt("medium_input.txt");
    }

    @Test
    public void sparseTest() throws IOException {
        solveMazeAt("sparse_medium.txt");
    }

    @Test
    public void largeTest() throws IOException {
        solveMazeAt("large_input.txt");
    }

    private void solveMazeAt(String... fileLocation) throws IOException {
        PuzzleParser.main(fileLocation);
    }
}
