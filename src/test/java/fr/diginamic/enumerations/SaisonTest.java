package fr.diginamic.enumerations;

import org.junit.Test;

import static org.junit.Assert.*;

public class SaisonTest {

    @Test
    public void testValueOfLibelle(){
        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("Printemps"));
        assertEquals(Saison.ETE, Saison.valueOfLibelle("Eté"));
        assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("Automne"));
        assertEquals(Saison.HIVER, Saison.valueOfLibelle("Hiver"));

        //Robustesse
        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("PrintempS"));
        assertEquals(null, Saison.valueOfLibelle(null));
        assertNull(Saison.valueOfLibelle("null"));
    }
}