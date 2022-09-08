package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void fuzzySearch() {

        assertEquals(true,ComplexExamples.fuzzySearch("car", "ca6$$#_rtwheel"));
        assertEquals(false,ComplexExamples.fuzzySearch(" ", "ca6$$#_rtwheel"));
        assertEquals(true,ComplexExamples.fuzzySearch(" ", "ca6$$#_ rtwheel"));
        assertEquals(false,ComplexExamples.fuzzySearch("carew", "ca"));
        assertEquals(true,ComplexExamples.fuzzySearch("carew", "car_e_w"));
        assertEquals(false,ComplexExamples.fuzzySearch("", "gfd"));
        assertEquals(false,ComplexExamples.fuzzySearch("fdsvc##", ""));
        assertEquals(false,ComplexExamples.fuzzySearch("", ""));
        assertEquals(false,ComplexExamples.fuzzySearch(null, null));
        assertEquals(false,ComplexExamples.fuzzySearch("ntedsfdc", null));
        assertEquals(false,ComplexExamples.fuzzySearch(null, "nfdsfvull"));
    }
}