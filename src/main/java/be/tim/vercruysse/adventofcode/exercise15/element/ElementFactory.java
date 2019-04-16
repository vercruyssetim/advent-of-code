package be.tim.vercruysse.adventofcode.exercise15.element;

public class ElementFactory {
    public Element createElement(char character) {
        switch (character) {
            case '#':
                return new Wall();
            case '.':
                return new EmptySpace();
            case 'G':
                return new Goblin();
            case 'E':
                return new Elf();
            default:
                throw new RuntimeException(String.format("Could not map %s", character));
        }
    }
}
