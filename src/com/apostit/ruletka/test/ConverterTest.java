package com.apostit.ruletka.test;

import com.apostit.ruletka.client.Converter;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Тесты конвертирования
 */
public class ConverterTest {

    @Test
    public void testClick() {
        assertEquals("40-42", Converter.go("Международный", "Россия", "XS"));
        assertEquals("42-44", Converter.go("Международный", "Россия", "S"));
        assertEquals("44-46", Converter.go("Международный", "Россия", "M"));


        String[] strings = {"XS", "S", "M", "L", "XL", "XXL", "XXXL"};
        assertArrayEquals(strings, Converter.getSizes());
    }
}
