package be.tim.vercruysse.adventofcode.exercise1;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FrequencyCalculation {


    public int calculate(String resourceName) {
        String input = readInput(resourceName);
        return split(input)
                .stream()
                .mapToInt(t -> t.intValue())
                .sum();
    }

    public List<Integer> split(String input){
        return Lists.newArrayList(input.split("\n"))
                .stream()
                .map(Integer::valueOf)
                .collect(toList());
    }

    public String readInput(String resourceName) {
        try {
            return Resources.toString(Resources.getResource(resourceName), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
