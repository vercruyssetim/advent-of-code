package be.tim.vercruysse.adventofcode.exercise2;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class FrequencyCalculation {


    public int calculateTotal(String resourceName) {
        String input = readInput(resourceName);
        List<Integer> passedIntegers = passedIntegers(split(input));
        return passedIntegers.get(passedIntegers.size() - 1);
    }


    public int getFirstDoubleSum(String resourceName) {
        String input = readInput(resourceName);
        List<Integer> integers = passedIntegers(split(input));

        Integer sum = integers.get(integers.size() - 1);
        int minimum = getMinNumberUntilDouble(integers, sum);

        return integers.stream()
                .filter(t -> integers.contains(t + sum * minimum))
                .map(t -> t + sum * minimum)
                .findFirst()
                .orElse(0);
    }

    public int getMinNumberUntilDouble(List<Integer> integers, int sum) {

        return integers.stream()
                .flatMap(t1 -> integers.stream()
                        .filter(t2 -> !t1.equals(t2))
                        .filter(t2 -> t1 < t2)
                        .filter(t2 -> (t2 - t1) % sum == 0)
                        .map(t2 -> (t2 - t1) / sum)
                )
                .mapToInt(t -> t)
                .min()
                .orElse(0);
    }

    public List<Integer> passedIntegers(List<Integer> split) {
        return split.stream()
                .reduce(new ArrayList<>(), (list, element) -> {
                    list.add(element + (list.isEmpty() ? 0 : list.get(list.size() - 1)));
                    return list;
                }, (list, list2) -> list);
    }

    public List<Integer> split(String input) {
        return newArrayList(input.split("\n"))
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
