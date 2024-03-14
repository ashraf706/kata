package com.awesome.ash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DiamondTest {

    @Test
    void input_a_should_draw_1x1_array() {
        char[][] result = Diamond.draw('a');
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
        assertEquals('A', result[0][0]);
    }

    @Test
    void input_B_should_draw_2x3_array() {
        char[][] result = Diamond.draw('B');
        assertEquals(2, result.length);
        assertEquals(3, result[0].length);
    }

    @Test
    void input_C_should_draw_3x5_array() {
        char[][] result = Diamond.draw('C');
        assertEquals(3, result.length);
        assertEquals(5, result[0].length);
        assertEquals(5, result[1].length);
        assertEquals(5, result[2].length);
    }

    @Test
    void should_return_0_blank_space_for_0() {
        int result = Diamond.calculateBlankSpaces(0);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("lineNumberProvider")
    void should_return_spaces_for_given_line_number(int lineNumber, int spaces) {
        assertEquals(spaces, Diamond.calculateBlankSpaces(lineNumber));
    }

    @Test
    void test_alphabet_B() {
        char[][] result = Diamond.draw('B');
        char[] firstRow = new char[]{' ', 'A', ' '};
        char[] secondRow = new char[]{'B', ' ', 'B'};

        assertArrayEquals(secondRow, result[1]);
        assertArrayEquals(firstRow, result[0]);
    }

    @Test
    void test_alphabet_C() {
        char[][] result = Diamond.draw('C');
        char[] firstRow = new char[]{' ', ' ', 'A', ' ', ' '};
        char[] secondRow = new char[]{' ', 'B', ' ', 'B', ' '};
        char[] thirdRow = new char[]{'C', ' ', ' ', ' ', 'C'};

        assertArrayEquals(firstRow, result[0]);
        assertArrayEquals(secondRow, result[1]);
        assertArrayEquals(thirdRow, result[2]);
    }

    @Test
    void test_alphabet_D() {
        char[][] result = Diamond.draw('D');
        char[] firstRow = new char[]{' ', ' ', ' ', 'A', ' ', ' ', ' '};
        char[] secondRow = new char[]{' ', ' ', 'B', ' ', 'B', ' ', ' '};
        char[] thirdRow = new char[]{' ', 'C', ' ', ' ', ' ', 'C', ' '};
        char[] fourthRow = new char[]{'D', ' ', ' ', ' ', ' ', ' ', 'D'};

        assertArrayEquals(firstRow, result[0]);
        assertArrayEquals(secondRow, result[1]);
        assertArrayEquals(thirdRow, result[2]);
        assertArrayEquals(fourthRow, result[3]);
    }

    @Test
    void test_print_A() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        Diamond.draw('A');

        assertEquals("A\n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_B() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        Diamond.draw('B');

        assertEquals(" A \nB B\n A \n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_C() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        Diamond.draw('C');

        assertEquals("  A  \n" +
                " B B \n" +
                "C   C\n" +
                " B B \n" +
                "  A  \n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_D() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        Diamond.draw('D');

        assertEquals("   A   \n" +
                "  B B  \n" +
                " C   C \n" +
                "D     D\n" +
                " C   C \n" +
                "  B B  \n" +
                "   A   \n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void invalid_input_draw_nothing() {
        char[][] result = Diamond.draw('!');
        assertEquals(0, result.length);
    }

    private static Stream<Arguments> lineNumberProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(3, 5),
                Arguments.of(4, 7)
        );
    }
}
