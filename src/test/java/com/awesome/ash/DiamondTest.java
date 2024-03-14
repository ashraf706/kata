package com.awesome.ash;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DiamondTest {

    @Test
    void should_draw_1x1_array() {
        char[][] result = Diamond.draw('a');
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
        assertEquals('A', result[0][0]);
    }

    @Test
    void should_draw_2x3_array() {
        char[][] result = Diamond.draw('B');
        assertEquals(2, result.length);
        assertEquals(3, result[0].length);
    }

    @Test
    void should_draw_3x5_array() {
        char[][] result = Diamond.draw('C');
        assertEquals(3, result.length);
        assertEquals(5, result[0].length);
        assertEquals(5, result[1].length);
        assertEquals(5, result[2].length);
    }

    @Test
    void should_get_odd_0_for_0() {
        int result = Diamond.calculateBlankSpace(0);
        assertEquals(0, result);
    }

    @Test
    void should_get_odd_1_for_1() {
        int result = Diamond.calculateBlankSpace(1);
        assertEquals(1, result);
    }

    @Test
    void should_get_odd_3_for_2() {
        int result = Diamond.calculateBlankSpace(2);
        assertEquals(3, result);
    }

    @Test
    void should_get_odd_5_for_3() {
        int result = Diamond.calculateBlankSpace(3);
        assertEquals(5, result);
    }

    @Test
    void array_equal_B() {
        char[][] result = Diamond.draw('B');
        char[] firstRow = new char[]{ '-','A','-'};
        char[] secondRow = new char[]{ 'B','-','B'};

        assertArrayEquals(secondRow, result[1]);
        assertArrayEquals(firstRow, result[0]);
    }

    @Test
    void array_equal_C() {
        char[][] result = Diamond.draw('C');
        char[] firstRow = new char[]{  '-','-','A','-','-'};
        char[] secondRow = new char[]{ '-','B','-','B', '-'};
        char[] thirdRow = new char[]{  'C','-','-','-','C'};

        assertArrayEquals(firstRow, result[0]);
        assertArrayEquals(secondRow, result[1]);
        assertArrayEquals(thirdRow, result[2]);

    }

    @Test
    void array_equal_D() {
        char[][] result = Diamond.draw('D');
        char[] firstRow = new char[]{  '-','-','-','A','-','-','-'};
        char[] secondRow = new char[]{ '-','-','B','-','B', '-','-'};
        char[] thirdRow = new char[]{  '-','C','-','-','-','C','-'};
        char[] fourthRow = new char[]{  'D','-','-','-', '-','-','D'};

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

        char[][] result = Diamond.draw('A');

        assertEquals("A\n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_B() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        char[][] result = Diamond.draw('B');

        assertEquals("-A-\nB-B\n-A-\n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_C() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        char[][] result = Diamond.draw('C');

        assertEquals("--A--\n-B-B-\nC---C\n-B-B-\n--A--\n", tempOut.toString());
        System.setOut(originalOut);
    }

    @Test
    void test_print_D() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));

        char[][] result = Diamond.draw('D');

        assertEquals("---A---\n" +
                "--B-B--\n" +
                "-C---C-\n" +
                "D-----D\n" +
                "-C---C-\n" +
                "--B-B--\n" +
                "---A---\n", tempOut.toString());
        System.setOut(originalOut);
    }

}
