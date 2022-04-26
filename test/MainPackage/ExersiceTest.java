/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MainPackage;

import MainPackage.Student;
import MainPackage.Exersice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zeeshan Ashir
 */
public class ExersiceTest {

    Exersice instance = new Exersice("Yoga", "Morning", 30,1,"Saturday");

    public ExersiceTest() {
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
     * Test of getName method, of class Exersice.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
//        instance = new Exersice("Yoga", "Morning", 30);
        String expResult = "Yoga";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
   

    /**
     * Test of getTime method, of class Exersice.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
//        Exersice instance = null;
        String expResult = "Morning";
        String result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTime method, of class Exersice.
     */
    

    /**
     * Test of addStudent method, of class Exersice.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student s = null;
//        Exersice instance = null;
        instance.addStudent(s);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCapacity method, of class Exersice.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int expResult = 3;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   

    /**
     * Test of removeStudent method, of class Exersice.
     */
    @Test
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        Student s = null;
        instance.removeStudent(s);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTotalCost method, of class Exersice.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        double expResult = 0.0;
        double result = instance.getTotalCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}
