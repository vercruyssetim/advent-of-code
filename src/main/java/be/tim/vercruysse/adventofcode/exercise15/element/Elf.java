package be.tim.vercruysse.adventofcode.exercise15.element;

public class Elf implements Element {

    @Override
    public String toString() {
        return "Elf{}\t";
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
        return 'E';
    }
}
