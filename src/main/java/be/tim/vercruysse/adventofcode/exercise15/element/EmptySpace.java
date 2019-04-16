package be.tim.vercruysse.adventofcode.exercise15.element;

public class EmptySpace implements Element {

    @Override
    public String toString() {
        return "EmptySpace{}";
    }

    @Override
    public boolean isMoveable() {
        return false;
    }

    @Override
    public boolean canMoveOnto() {
        return true;
    }

    @Override
    public char getCharacter() {
        return '.';
    }
}
