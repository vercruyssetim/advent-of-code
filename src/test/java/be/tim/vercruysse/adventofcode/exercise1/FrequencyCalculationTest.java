package be.tim.vercruysse.adventofcode.exercise1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class FrequencyCalculationTest {

    private FrequencyCalculation frequencyCalculation = new FrequencyCalculation();

    @Test
    public void calculate() {
        int result = frequencyCalculation.calculate("exercise1/input.txt");

        Assertions.assertThat(result).isEqualTo(497);
    }

    @Test
    public void readInput() {
        String result = frequencyCalculation.readInput("exercise1/test-input.txt");

        Assertions.assertThat(result).isEqualTo("-8\n" +
                "-18\n" +
                "-14\n" +
                "-10\n");
    }

    @Test
    public void split() {
        List<Integer> split = frequencyCalculation.split("-8\n" +
                "-18\n" +
                "-14\n" +
                "-10\n");

        Assertions.assertThat(split).containsExactlyInAnyOrder(-8, -18, -14, -10);
    }
}