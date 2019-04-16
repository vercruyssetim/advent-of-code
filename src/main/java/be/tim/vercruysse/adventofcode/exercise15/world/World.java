package be.tim.vercruysse.adventofcode.exercise15.world;

import java.util.List;

public class World {
    private PlayingField playingField;

    public World(PlayingField playingField) {
        this.playingField = playingField;
    }


    public World calculateNextWorld(){
        List<Position> list = playingField.getListOfMovablePositionsInOrder();
        list.forEach(p -> playingField.moveElement(p, getBestMove(p)));
        return new World(playingField);
    }

    private Position getBestMove(Position position) {
        return position.getPossibleMoves().stream()
                .filter(p -> playingField.canMoveTo(p))
                .findFirst()
                .orElse(position);
    }

    @Override
    public String toString() {
        return playingField.toString();
    }
}
