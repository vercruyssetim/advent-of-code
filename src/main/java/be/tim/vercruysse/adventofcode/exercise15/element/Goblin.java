package be.tim.vercruysse.adventofcode.exercise15.element;

public class Goblin implements Element {

    @Override
    public String toString() {
        return "Goblin{}";
    }

    @Override
    public boolean isMoveable() {
        return true;
    }

    @Override
    public boolean canMoveOnto() {
        return false;
    }

    @Override
    public char getCharacter() {
        return 'G';
    }
}
