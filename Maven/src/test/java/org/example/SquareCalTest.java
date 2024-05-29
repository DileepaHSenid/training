package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareCalTest {

    @Test
    public void testCalculateTheSquare() {
        double input = 4.0;
        double expected = 16.0;
        double result = SquareCal.calculateTheSquare(input);
        assertEquals(expected, result, "The square calculation is incorrect");
    }
}
