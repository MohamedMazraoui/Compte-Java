/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SiMo
 */
public class CompteServiceTest {
    
    public CompteServiceTest() {
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

    /**
     * Test of OuvrirCompte method, of class CompteService.
     */
    @Test
    public void testOuvrirCompte() {
        System.out.println("OuvrirCompte");
        CompteService instance = new CompteService();
        instance.ouvrirCompte("Sara", 1200.0);
        instance.ouvrirCompte("Fatima", 2500.0);
        instance.ouvrirCompte("Hamid", 5000.0);
    }

    

    /**
     * Test of fermerCompte method, of class CompteService.
     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        CompteService instance = new CompteService();
        instance.fermerCompte("Sara");

    }

    /**
     * Test of debiter method, of class CompteService.
     */
    @Test
    public void testDebiter() {
        System.out.println("debiter");
        Compte c1 = new Compte("EE1", 5000, true, 'a');
        CompteService instance = new CompteService();
        instance.debiter(c1, 200.0);
    }

    /**
     * Test of crediter method, of class CompteService.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        Compte c1 = new Compte("EE2", 4000, true, 'b');
        CompteService instance = new CompteService();
        instance.crediter(c1,200.0 );
    }

    /**
     * Test of transfer method, of class CompteService.
     */
    @Test
    public void testTransfer() {
        System.out.println("transfer");
        Compte c1 = new Compte("EE3", 4000, true, 'b');
        Compte c2 = new Compte("EE4", 6000, true, 'a');
        CompteService instance = new CompteService();
        instance.transfer(c1, c2, 2000.0);
    }
    public void testFermerCompte_String() {
        System.out.println("fermerCompte");
        CompteService instance = new CompteService();
        instance.fermerCompte("Hamid");
    }

//    /**
//     * Test of fermerCompte method, of class CompteService.
//     */
//    @Test
//    public void testFermerCompte_0args() {
//        System.out.println("fermerCompte");
//        CompteService instance = new CompteService();
//        int expResult = 0;
//        int result = instance.fermerCompte();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findBySolde method, of class CompteService.
     */
    @Test
    public void testFindBySolde() {
        System.out.println("findBySolde");
        CompteService instance = new CompteService();
        instance.findBySolde(5000.0);
    }

    /**
     * Test of findByRIb method, of class CompteService.
     */
    @Test
    public void testFindByRIb() {
        System.out.println("findByRIb");
        CompteService instance = new CompteService();
        instance.findByRIb("Ayoub");
    }

    /**
     * Test of findByClasse method, of class CompteService.
     */
    @Test
    public void testFindByClasse() {
        System.out.println("findByClasse");
        CompteService instance = new CompteService();
        instance.findByClasse('b');
    }

    /**
     * Test of findIndexByRIb method, of class CompteService.
     */
    @Test
    public void testFindIndexByRIb() {
        System.out.println("findIndexByRIb");
        CompteService instance = new CompteService();
        instance.findIndexByRIb("Mazraoui");
    }

    /**
     * Test of deleteByRib method, of class CompteService.
     */
    @Test
    public void testDeleteByRib() {
        System.out.println("deleteByRib");
        CompteService instance = new CompteService();
        instance.deleteByRib("Chtouki");
    }
    
}
