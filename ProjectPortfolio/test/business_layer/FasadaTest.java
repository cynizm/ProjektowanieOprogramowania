/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer;

import business_layer.entities.Klient;
import business_layer.entities.Osoba;
import business_layer.entities.Projekt;
import business_layer.entities.Rola;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mikolaj
 */
public class FasadaTest {

    public FasadaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public Klient klient(String dane_klient[]) {
        Klient klient = new Klient();
        klient.setNazwaFirmy(dane_klient[0]);
        klient.setNip(dane_klient[1]);
        klient.setUlica(dane_klient[2]);
        klient.setNrDomu(dane_klient[3]);
        klient.setNrLokalu(dane_klient[4]);
        klient.setMiejscowosc(dane_klient[5]);
        klient.setKodPocztowy(dane_klient[6]);

        return klient;
    }

    public ArrayList<Klient> klienci() {
        ArrayList<Klient> klienci = new ArrayList();
        String dane_klienta1[] = {"firma1", "1545183328", "ulica1", "1a", "12", "miejscowosc1", "11-111"};
        String dane_klienta2[] = {"firma2", "8195536504", "ulica2", "2b", "21", "miejscowosc2", "22-222"};
        klienci.add(klient(dane_klienta1));
        klienci.add(klient(dane_klienta2));

        return klienci;
    }

    public Osoba osoba(String dane_osoba[]) {
        Osoba osoba = new Osoba();
        osoba.setImie(dane_osoba[1]);
        osoba.setNazwisko(dane_osoba[2]);
        osoba.setEmail(dane_osoba[3]);
        osoba.setIdProjektu(Integer.parseInt(dane_osoba[4]));
        osoba.setRola(Rola.fromString(dane_osoba[5]));

        return osoba;
    }

    public ArrayList<Osoba> osoby() {
        ArrayList<Osoba> osoby = new ArrayList();
        String dane_osoba1[] = {"1", "imie1", "nazwisko1", "email1", "1", "Tester"};
        String dane_osoba2[] = {"1", "imie2", "nazwisko2", "email2", "2", "Programista"};
        osoby.add(osoba(dane_osoba1));
        osoby.add(osoba(dane_osoba2));

        return osoby;
    }

    /**
     * Test of getListaKlientow method, of class Fasada.
     */
    @Test
    public void testGetListaKlientow() {
        System.out.println("getListaKlientow");
        Fasada instance = new Fasada();
        ArrayList<Klient> expResult = klienci();
        instance.setListaKlientow(expResult);
        ArrayList<Klient> result = instance.getListaKlientow();
        assertEquals(expResult, result);

    }

    /**
     * Test of setListaKlientow method, of class Fasada.
     */
    @Test
    public void testSetListaKlientow() {
        System.out.println("setListaKlientow");
        ArrayList<Klient> klienci = klienci();
        Fasada instance = new Fasada();
        instance.setListaKlientow(klienci);

        assertEquals(klienci, instance.getListaKlientow());
    }

    /**
     * Test of getOsoby method, of class Fasada.
     */
    @Test
    public void testGetOsoby() {
        System.out.println("modelOsoby");
        Fasada instance = new Fasada();
        ArrayList<Osoba> expResult = osoby();
        instance.setOsoby(expResult);
        ArrayList<Osoba> result = instance.getOsoby();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOsoby method, of class Fasada.
     */
    @Test
    public void testSetOsoby() {
        System.out.println("setOsoby");
        ArrayList<Osoba> osoby = osoby();
        Fasada instance = new Fasada();
        instance.setOsoby(osoby);
        ArrayList<Osoba> expResult = instance.getOsoby();
        assertEquals(osoby, expResult);
    }

    /**
     * Test of modelProjekty method, of class Fasada.
     */
    @Test
    public void testGetProjekty() {
        System.out.println("getProjekty");
        Fasada instance = new Fasada();
        ArrayList<Projekt> expResult = null;
        ArrayList<Projekt> result = instance.getProjekty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjekty method, of class Fasada.
     */
    @Test
    public void testSetProjekty() {
        System.out.println("setProjekty");
        ArrayList<Projekt> projekty = null;
        Fasada instance = new Fasada();
        instance.setProjekty(projekty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRisk method, of class Fasada.
     */
    @Test
    public void testAddRisk() {
        System.out.println("addRisk");
        String daneKierownika = "";
        String[] daneRyzyka = null;
        Fasada instance = new Fasada();
        int expResult = 0;
        int result = instance.addRisk(daneKierownika, daneRyzyka);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelRisks method, of class Fasada.
     */
    @Test
    public void testGetRisks() {
        System.out.println("getRisks");
        Fasada instance = new Fasada();
        Object[][] expResult = null;
        Object[][] result = instance.modelRisks();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajOsobe method, of class Fasada.
     */
    @Test
    public void testSzukajOsobe_Osoba() {
        System.out.println("szukajOsobe");
        ArrayList<Osoba> osoby = osoby();
        Fasada instance = new Fasada();
        instance.setOsoby(osoby);
        Osoba expResult = osoby.get(0);
        Osoba result = instance.szukajOsobe(osoby.get(0));
        assertEquals(expResult, result);
    }

    /**
     * Test of szukajOsobe method, of class Fasada.
     */
    @Test
    public void testSzukajOsobe_StringArr() {
        System.out.println("szukajOsobe");
        String[] data = {"0", "email1"};
        ArrayList<Osoba> osoby = osoby();
        Fasada instance = new Fasada();
        instance.setOsoby(osoby);
        String expResult = osoby.get(0).toString();
        String result = instance.szukajOsobe(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of dodajOsobe method, of class Fasada.
     */
    @Test
    public void testDodajOsobe() {
        System.out.println("dodajOsobe");
        String dane_osoba1[] = {"1", "imie1", "nazwisko1", "email1", "1", "Tester"};
        String dane_osoba2[] = {"1", "imie2", "nazwisko2", "email2", "2", "Programista"};
        Fasada instance = new Fasada();
        Osoba expResultForCorrectData = osoba(dane_osoba1);
        Osoba reultForCorrectData = instance.dodajOsobe(dane_osoba1);
        instance.dodajOsobe(dane_osoba2);
        assertEquals(expResultForCorrectData, reultForCorrectData);
        int expListLength = 2;
        assertEquals(expListLength, instance.getOsoby().size());
    }

    /**
     * Test of getTablicaZDanymiOsob method, of class Fasada.
     */
    @Test
    public void testGetTablicaZDanymiOsob() {
        System.out.println("modelTablicaZDanymiOsob");
        Fasada instance = new Fasada();
        instance.setOsoby(osoby());
        Object[][] expResult = new Object[instance.getOsoby().size()][];
        String[] dane1 = {"imie1", "nazwisko1", "email1", "1", "Tester"};
        String[] dane2 = {"imie2", "nazwisko2", "email2", "2", "Programista"};
        expResult[0] = dane1;
        expResult[1] = dane2;
        Object[][] result = instance.modelTablicaZDanymiOsob();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of modelRole method, of class Fasada.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Fasada instance = new Fasada();
        String[] expResult = {"Kierownik projektu", "Analityk", "Programista", "Tester"};
        String[] result = instance.modelRole();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of dodajKlienta method, of class Fasada.
     */
    @Test
    public void testDodajKlienta() {
        System.out.println("dodajKlienta");
        String[] data = {"firma1", "1545183328", "ulica1", "1a", "12", "miejscowosc1", "11-111"};
        Fasada instance = new Fasada();
        Klient expResult = klient(data);
        instance.dodajKlienta(data);
        Klient result = instance.getKlienci().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of szukajKlienta method, of class Fasada.
     */
    @Test
    public void testSzukajKlienta() {
        System.out.println("szukajKlienta");
        Fasada instance = new Fasada();
        instance.setListaKlientow(klienci());
        // Klient expResult = instance.getListaKlientow().get(0);
        boolean result = instance.szukajKlienta(instance.getListaKlientow().get(0));
        assertEquals(true, result);
    }

    /**
     * Test of pobierzTabliceKierownikow method, of class Fasada.
     */
    @Test
    public void testPobierzTabliceKierownikow() {
        System.out.println("pobierzTabliceKierownikow");
        Fasada instance = new Fasada();
        Object[] expResult = null;
        Object[] result = instance.pobierzTabliceKierownikow();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
