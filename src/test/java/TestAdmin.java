import api.IAdmin;
import api.core.impl.Admin;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 23/2/2017.
 */
public class TestAdmin {

    private IAdmin admin;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Begin testing of Admin class.");
    }

    @Before
    public void setup() {
        this.admin = new Admin();
    }

    @After
    public void afterTest() { System.out.println("The test has finished. See assertion messages."); }

    @AfterClass
    public static void afterClass(){
        System.out.println("Testing of Admin class has been completed.");
    }

    @Test
    public void testCreateClass() {
        System.out.println("Base test for assertion...");
        this.admin.createClass("a", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("a", 2017));
    }

    @Test
    public void testCreateClass2() {
        System.out.println("Testing for no class created prior to 2017...");
        this.admin.createClass("b", 2016, "Instructor", 15);
        assertFalse(this.admin.classExists("b", 2016));
    }

    @Test
    public void testCreateClass3() {
        System.out.println("Testing for no assigned instructor...");
        this.admin.createClass("c", 2017, "", 15);
        assertTrue(!this.admin.getClassInstructor("c", 2017).isEmpty());
    }

    @Test
    public void testCreateClass4() {
        System.out.println("Testing for valid capacity...");
        this.admin.createClass("d", 2017, "Yes", 1);
        assertTrue(this.admin.getClassCapacity("d", 2017) > 0);

        this.admin.createClass("e",2017,"Instructor", -2);
        assertTrue(this.admin.getClassCapacity("e",2017) > 0);

        this.admin.createClass("f",2017,"Instructor", 0);
        assertTrue(this.admin.getClassCapacity("e",2017) != 0);
    }

    @Test
    public void testCreateClass5() {
        System.out.println("Testing for invalid capacity change...");
        this.admin.createClass("g", 2017, "Yes", 1);
        this.admin.changeCapacity("g",2017, 0);
        assertTrue(this.admin.getClassCapacity("g",2017) > 0);
    }
}
