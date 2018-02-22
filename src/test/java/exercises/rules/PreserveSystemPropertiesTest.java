package exercises.rules;

import org.junit.*;

public class PreserveSystemPropertiesTest {

    @Rule
    public PreserveSysPropertyTestRule preserveSysPropertyTestRule = new PreserveSysPropertyTestRule();

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass:" + System.getProperty("myKey"));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass:" + System.getProperty("myKey"));
    }

    @Test
    @Ignore
    public void createSysProperty() {
        System.setProperty("myKey", "myValue");
        System.out.println(System.getProperty("myKey"));
    }

    @Test
    @Ignore
    public void checkSysProperty() {
        //System.setProperty("myKey", "myValue");
        System.out.println(System.getProperty("myKey"));
    }

    @Test
    public void modifySysProperty() {
        System.setProperty("myKey", "myValue2");
        System.out.println("modifySysProperty:" + System.getProperty("myKey"));
    }
}
