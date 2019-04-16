package be.tim.vercruysse.adventofcode.exercise3;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

public class CheckSum {

    public int checkSum(String resourceName) {
        List<String> split = split(readInput(resourceName));
        List<Set<Integer>> sets = split.stream()
                .map(t -> checkNumbers(t))
                .collect(toList());

        return range(2, 4)
                .map(t -> sets.stream()
                            .map(a -> a.stream().filter(b -> b == t).collect(toList()))
                            .filter(a -> !a.isEmpty())
                            .collect(toList())
                            .size()
                )
                .filter(t -> t != 0)
                .reduce(1, (t1, t2) -> t1*t2);
    }

    public Set<Integer> checkNumbers(String line) {
        return line.chars()
                .mapToObj(t -> (char) t)
                .map(t -> howManyTimesIn(t, line))
                .collect(toSet());

    }

    public int howManyTimesIn(char character, String line) {
        return line.chars()
                .mapToObj(t -> (char) t)
                .filter(t -> t == character)
                .collect(toList())
                .size();
    }

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
