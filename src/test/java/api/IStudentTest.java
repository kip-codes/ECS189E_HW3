package api;
import api.IStudent;
import api.core.impl.Instructor;
import api.core.impl.Student;
import org.junit.*;
import static org.junit.Assert.*;


import org.junit.Test;
import sun.font.TrueTypeFont;


import static org.junit.Assert.*;

/**
 * Created by kevinip on 3/8/17.
 */
public class IStudentTest {
    private IStudent student;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Begin testing of Student class.");
    }

    @Before
    public void setup() {
        this.student = new Student();
    }

    @After
    public void afterTest() { System.out.println("The test has finished. See assertion messages."); }

    @AfterClass
    public static void afterClass(){
        System.out.println("Testing of Student class has been completed.");
    }


    @Test
    public void testRegisterForClass() throws Exception {
        System.out.println("Base test for assertion in registerForClass()...");
        this.student.registerForClass("Student", "Class", 2017);
        assertTrue(this.student.isRegisteredFor("Student", "Class", 2017));
    }

    @Test
    public void testRegisterForClass2() throws Exception {
        System.out.println("Testing for incomplete / invalid registration...");
        this.student.registerForClass("", "Class", 2017);
        assertFalse(this.student.isRegisteredFor("", "Class", 2017));
    }

    @Test
    public void testDropClass() throws Exception {
        System.out.println("Base test for assertion in dropClass()...");
        this.student.registerForClass("S", "C", 2017);
        this.student.dropClass("S","C", 2017);
        assertFalse(this.student.isRegisteredFor("S","C", 2017));
    }

    @Test
    public void testDropClass2() throws Exception {
        int i = 0;
        System.out.println("Testing invalid dropping if not enrolled...");
        this.student.registerForClass("S", "C", 2017);
        if (!this.student.isRegisteredFor("S", "BasketWeaving", 2017)) i = 0;

        if (i == 0) {
            this.student.dropClass("S", "BasketWeaving", 2017);
            assertFalse(1==1);
        }
    }

    @Test
    public void testSubmitHomework() throws Exception {
        System.out.println("Base test for assertion in submitHomework()...");
        this.student.registerForClass("S", "C", 2017);
        this.student.submitHomework("S","HW", "Ans", "C",2017);
        assertTrue(this.student.hasSubmitted("S","HW","C",2017));
    }

    @Test
    public void testSubmitHomework2() throws Exception {
        System.out.println("Testing submission in unenrolled class...");
        this.student.registerForClass("S", "C", 2017);
        this.student.submitHomework("S","HW", "Ans", "Baskets",2017);
        assertFalse(this.student.isRegisteredFor("S","Baskets",2017));
    }

}