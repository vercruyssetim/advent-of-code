package be.tim.vercruysse.adventofcode.exercise3;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class CheckSumTest {

    private CheckSum checkSum = new CheckSum();

    @Test
    public void parse() {
        int strings = checkSum.checkSum("exercise3/input.txt");

        Assertions.assertThat(strings).isEqualTo(7936);
    }

    @Test
    public void checkNumbers() {
        Set<Integer> list = checkSum.checkNumbers("bababc");

        Assertions.assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    public void howManyTimes() {
        int howManyTimesIn = checkSum.howManyTimesIn('a', "bababc");

        Assertions.assertThat(howManyTimesIn).isEqualTo(2);
    }
}