package be.tim.vercruysse.adventofcode.exercise15.element;

import be.tim.vercruysse.adventofcode.exercise15.element.Element;

public class Wall implements Element {

    public String toString(){
        return "Wall{}";
    }

    @Override
    public boolean isMoveable() {
        return false;
    }

    @Override
    public boolean canMoveOnto() {
        return false;
    }

    @Override
    public char getCharacter() {
        return '#';
    }
}
