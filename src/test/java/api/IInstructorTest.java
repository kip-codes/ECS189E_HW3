package api;
import api.IInstructor;
import api.core.impl.Instructor;
import org.junit.*;
import static org.junit.Assert.*;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinip on 3/8/17.
 */
public class IInstructorTest {
    private IInstructor instructor;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Begin testing of Instructor class.");
    }

    @Before
    public void setup() {
        this.instructor = new Instructor();
    }

    @After
    public void afterTest() { System.out.println("The test has finished. See assertion messages."); }

    @AfterClass
    public static void afterClass(){
        System.out.println("Testing of Instructor class has been completed.");
    }

    @Test
    public void testAddHomework() throws Exception {
        System.out.println("Base test for assertion...");
        this.instructor.addHomework("Instructor", "Class", 2017, "Homework", "Description");
        assertTrue(this.instructor.homeworkExists("Class",2017, "Homework"));
    }

    @Test
    public void testAddHomework2() throws Exception {
        System.out.println("Testing for invalid year...");
        this.instructor.addHomework("Instructor", "Class", 2016, "Homework", "Description");
        assertFalse(this.instructor.homeworkExists("Class",2016, "Homework"));
    }

    @Test
    public void testAddHomework3() throws Exception {
        System.out.println("Testing for blank elements...");
        this.instructor.addHomework("Instructor", "", 2017, "Homework", "Description");
        assertFalse(this.instructor.homeworkExists("",2017, "Homework"));
    }

    @Test
    public void testAddHomework4() throws Exception {
        System.out.println("Testing for blank elements...");
        this.instructor.addHomework("Instructor", "Class", 2017, "", "Description");
        assertFalse(this.instructor.homeworkExists("Class",2017, ""));
    }

    @Test
    public void assignGrade() throws Exception {

    }

    @Test
    public void homeworkExists() throws Exception {

    }

    @Test
    public void getGrade() throws Exception {

    }

}