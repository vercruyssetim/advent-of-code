package be.tim.vercruysse.adventofcode.exercise4;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CorrectBoxes {

    public String readInput(String resourceName) {
        try {
            return Resources.toString(Resources.getResource(resourceName), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public List<String> split(String input) {
        return Lists.newArrayList(input.split("\n"))
                .stream()
                .collect(toList());
    }
}
