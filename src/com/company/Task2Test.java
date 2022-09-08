package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void findSumm() {

        int itog1 = 5;
        int[] test1 = new int[]{5,6,3,2,5,1,4,9};
        int itog2 = 442;
        int[] test2 = new int[]{11,25,33,25,11,54,4,4,54,25};
        int itog3 = 6;
        int[] test3 = new int[]{};
        int itog4 = -7;
        int[] test4 = new int[]{-5,8,3,-3,-11,3,2,-4};
        int itog5 = 42;
        int[] test5 = new int[]{-5,21,3,-3,-11,3,0,22};

        assertArrayEquals(new String[]{"3","2"}, ComplexExamples.findSum(test1,itog1));
        assertArrayEquals(new String[]{"Нет подходящих пар чисел"}, ComplexExamples.findSum(test2,itog2));
        assertArrayEquals(new String[]{"Нет подходящих пар чисел"}, ComplexExamples.findSum(test3,itog3));
        assertArrayEquals(new String[]{"-3","-4"}, ComplexExamples.findSum(test4,itog4));
        assertArrayEquals(new String[]{"Нет подходящих пар чисел"}, ComplexExamples.findSum(test5,itog5));

    }
}