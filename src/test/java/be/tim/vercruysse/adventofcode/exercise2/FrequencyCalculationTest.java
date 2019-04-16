package be.tim.vercruysse.adventofcode.exercise2;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

public class FrequencyCalculationTest {
    private FrequencyCalculation frequencyCalculation = new FrequencyCalculation();

    @Test
    public void calculate() {
        int result = frequencyCalculation.calculateTotal("exercise2/input.txt");

        Assertions.assertThat(result).isEqualTo(497);
    }

    @Test
    public void readInput() {
        String result = frequencyCalculation.readInput("exercise2/test-input.txt");

        Assertions.assertThat(result).isEqualTo("-8\n" +
                "-18\n" +
                "-14\n" +
                "-10\n");
    }

    @Test
    public void getFirstDouble() {
        int result = frequencyCalculation.getFirstDoubleSum("exercise2/input.txt");

        Assertions.assertThat(result).isEqualTo(558);
    }

    @Test
    public void split() {
        List<Integer> split = frequencyCalculation.split("-8\n" +
                "-18\n" +
                "-14\n" +
                "-10\n");

        Assertions.assertThat(split).containsExactlyInAnyOrder(-8, -18, -14, -10);
    }

    @Test
    public void alreadyPassed() {
        List<Integer> result = frequencyCalculation.passedIntegers(Lists.newArrayList(3, 4, -1, 1));

        Assertions.assertThat(result).containsExactly(3, 7, 6, 7);
    }
}