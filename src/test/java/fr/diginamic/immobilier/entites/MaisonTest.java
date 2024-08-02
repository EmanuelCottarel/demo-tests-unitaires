package fr.diginamic.immobilier.entites;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MaisonTest {

    private static Salon salon;
    private static SalleDeBain salleDeBain;
    private Maison maison;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeClass
    public static void setUpBeforeClass() {
        salon = new Salon(1, 15);
        salleDeBain = new SalleDeBain(1, 15);
    }

    @Before
    public void setUp() {
        maison = new Maison();
    }

    @Test
    public void testAjouterPiece() {
        Assert.assertEquals(0, maison.getPieces().length);
        maison.ajouterPiece(salon);
        Assert.assertEquals(1, maison.getPieces().length);
        maison.ajouterPiece(salleDeBain);
        Assert.assertEquals(2, maison.getPieces().length);
        expectedException.expect(IllegalArgumentException.class);
        maison.ajouterPiece(null);
    }

    @Test
    public void testAjouterPieceNull() {
        expectedException.expect(IllegalArgumentException.class);
        maison.ajouterPiece(null);
    }

    @Test
    public void testNbPieces() {
        Assert.assertEquals(0, maison.nbPieces());
        maison.ajouterPiece(salon);
        Assert.assertEquals(1, maison.nbPieces());
    }

    @Test
    public void testSuperficieEtage() {
        Assert.assertEquals(0, maison.superficieEtage(0), 0);
        maison.ajouterPiece(new Salon(0, 20));
        Assert.assertEquals(20, maison.superficieEtage(0), 0);
        maison.ajouterPiece(new Salon(1, 30));
        Assert.assertEquals(20, maison.superficieEtage(0), 0);
        Assert.assertEquals(30, maison.superficieEtage(1), 0);
    }

    @Test
    public void testSuperficieTypePiece() {
        Assert.assertEquals(0, maison.superficieTypePiece(Piece.TYPE_SALON), 0);
        maison.ajouterPiece(new Salon(0, 20));
        Assert.assertEquals(20, maison.superficieTypePiece(Piece.TYPE_SALON), 0);
        maison.ajouterPiece(new Salon(0, 20));
        Assert.assertEquals(40, maison.superficieTypePiece(Piece.TYPE_SALON), 0);
        maison.ajouterPiece(new WC(0, 20));
        Assert.assertEquals(20, maison.superficieTypePiece(Piece.TYPE_WC), 0);
        maison.ajouterPiece(new Cuisine(0, 20));
        Assert.assertEquals(20, maison.superficieTypePiece(Piece.TYPE_CUISINE), 0);
        maison.ajouterPiece(new Chambre(0, 20));
        Assert.assertEquals(20, maison.superficieTypePiece(Piece.TYPE_CHAMBRE), 0);

        expectedException.expect(IllegalArgumentException.class);
        maison.superficieTypePiece(null);

    }

    @Test
    public void testSuperficieTypePieceNull() {
        expectedException.expect(IllegalArgumentException.class);
        maison.superficieTypePiece(null);
    }

    @Test
    public void testCalculerSurface() {
        Assert.assertEquals(0, maison.calculerSurface(), 0);
        maison.ajouterPiece(new Salon(0, 20));
        maison.ajouterPiece(new Salon(0, 20));
        maison.ajouterPiece(new WC(0, 20));
        maison.ajouterPiece(new Cuisine(0, 20));
        maison.ajouterPiece(new Chambre(0, 20));
        Assert.assertEquals(100, maison.calculerSurface(), 0);
    }

    @Test
    public void testGetPieces() {
        Assert.assertEquals(0, maison.getPieces().length);
    }
}