package fr.diginamic.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testLevenshteinDistance(){
        // Nominal
        assertEquals(1, StringUtils.levenshteinDistance("chat", "chats"));
        assertEquals(1, StringUtils.levenshteinDistance("machins", "machine"));
        assertEquals(1, StringUtils.levenshteinDistance("aviron", "avion"));
        assertEquals(2, StringUtils.levenshteinDistance("distance", "instance"));
        assertEquals(2, StringUtils.levenshteinDistance("Chien", "Chine"));

        // Robustesse
        assertEquals(2, StringUtils.levenshteinDistance("ChiEN", "Chine"));
//        assertEquals(2, StringUtils.levenshteinDistance(null, "Chine"));


        expectedException.expect(IllegalArgumentException.class);
        StringUtils.levenshteinDistance(null, "Chine");
        expectedException.expect(IllegalArgumentException.class);
        StringUtils.levenshteinDistance("Chine", null);
        expectedException.expect(IllegalArgumentException.class);
        StringUtils.levenshteinDistance(null, null);

    }

}