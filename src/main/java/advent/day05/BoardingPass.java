package advent.day05;

public class BoardingPass implements Comparable<BoardingPass> {
    public final int row, column;

    public BoardingPass(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getSeatId() {
        return row * 8 + column;
    }

    @Override
    public int compareTo(BoardingPass o) {
        return getSeatId() - o.getSeatId();
    }
}