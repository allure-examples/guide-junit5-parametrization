package org.example.junit_parameterization;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
// import org.junit.jupiter.params.Parameter
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        assertEquals(1 + 2, 3);
    }

    @Test
    public void testSumLoop() {
        final int[][] data = new int[][]{
                {1, 2, 3},
                {-1, 1, 0},
                {0, 0, 0}
        };
        for (int[] datum : data) {
            assertEquals(datum[0] + datum[1], datum[2]);
        }
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 1, 0),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSumParameterized(int x, int y, int sum) {
        assertEquals(x + y, sum);
    }
}
