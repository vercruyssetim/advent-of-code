package be.tim.vercruysse.adventofcode.exercise15.world;

import be.tim.vercruysse.adventofcode.exercise15.element.Element;
import be.tim.vercruysse.adventofcode.exercise15.element.ElementFactory;
import be.tim.vercruysse.adventofcode.exercise15.input.FileReader;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class WorldFactory {


    private List<String> input;
    private ElementFactory elementFactory;

    public WorldFactory(FileReader fileReader, ElementFactory elementFactory) {
        this.input = fileReader.readFile();
        this.elementFactory = elementFactory;
    }

    public World createWorld() {
        Map<Position, Element> result = Maps.newHashMap();
        for (int x = 0; x < input.size(); x++) {
            for (int y = 0; y < input.get(x).length(); y++) {
                result.put(Position.pos(x,y), elementFactory.createElement(input.get(x).charAt(y)));
            }
        }
        return new World(new PlayingField(result));
    }
}
