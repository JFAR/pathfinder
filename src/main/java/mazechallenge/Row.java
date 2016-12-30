package mazechallenge;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Cell> cells;

    public Row(String row) {
        cells = new ArrayList<Cell>();
        for (String cell : row.split(" ")) {
            cells.add(new Cell(cell.trim()));
        }
    }

    public Cell getCell(int y) {
        try {
            return cells.get(y);
        } catch (Exception e) {
            return null;
        }
    }

    public Integer width() {
        return cells.size();
    }
}
