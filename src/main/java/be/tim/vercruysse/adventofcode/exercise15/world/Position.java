package be.tim.vercruysse.adventofcode.exercise15.world;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;

public class Position implements Comparable<Position> {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position pos(int x, int y) {
        return new Position(x, y);
    }


    @Override
    public int compareTo(Position p) {
        int compare = Integer.compare(this.x, p.x);
        return compare != 0 ? compare : Integer.compare(this.y, p.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }

    public List<Position> getPossibleMoves() {
        return newArrayList(
                pos(x - 1, y),
                pos(x + 1, y),
                pos(x, y - 1),
                pos(x, y + 1)
        );
    }
}
