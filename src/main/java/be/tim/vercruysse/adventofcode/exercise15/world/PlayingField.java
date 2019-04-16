package be.tim.vercruysse.adventofcode.exercise15.world;

import be.tim.vercruysse.adventofcode.exercise15.element.Element;
import be.tim.vercruysse.adventofcode.exercise15.element.EmptySpace;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static be.tim.vercruysse.adventofcode.exercise15.world.Position.pos;
import static java.util.stream.Collectors.toSet;

public class PlayingField {

    private final Map<Position, Element> elementMap;

    public PlayingField(Map<Position, Element> elementMap) {
        this.elementMap = elementMap;
    }

    public List<Position> getListOfMovablePositionsInOrder() {
        return elementMap.entrySet().stream()
                .filter(t -> t.getValue().isMoveable())
                .map(Entry::getKey)
                .sorted(Comparator.comparing(t -> t, Position::compareTo))
                .collect(Collectors.toList());
    }

    public void moveElement(Position positionFrom, Position positionTo) {
        System.out.println(String.format("%s: %s -> %s", elementMap.get(positionFrom), positionFrom, positionTo));
        elementMap.put(positionTo, elementMap.get(positionFrom));
        elementMap.put(positionFrom, new EmptySpace());
    }

    public boolean canMoveTo(Position position) {
        return elementMap.get(position).canMoveOnto();
    }

    public String toString() {
        Integer maxX = elementMap.keySet().stream().map(Position::getX).max(Comparator.comparing(t -> t, Integer::compareTo)).orElse(0);
        Integer maxY = elementMap.keySet().stream().map(Position::getY).max(Comparator.comparing(t -> t, Integer::compareTo)).orElse(0);

        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {
                stringBuilder.append(elementMap.get(pos(x, y)).getCharacter());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Optional<Position> getClosestEnemyPosition(Position startingPosition){
        return recursiveSearch(Sets.newHashSet(startingPosition.getPossibleMoves()), Sets.newHashSet());
    }

    private Optional<Position> recursiveSearch(Set<Position> nextPositions, Set<Position> searchedPositions) {
        if(nextPositions.isEmpty()){
            return Optional.empty();
        }

        Set<Position> nextNextPositions = nextPositions.stream()
                .filter(t -> elementMap.get(t).canMoveOnto())
                .flatMap(t -> t.getPossibleMoves().stream())
                .filter(t -> !searchedPositions.contains(t))
                .collect(toSet());
        searchedPositions.addAll(nextPositions);
        return recursiveSearch(nextNextPositions, searchedPositions);
    }
}
