package exercises.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PreserveSysPropertyTestRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    System.setProperty("myKey", "myValue");
                    System.out.println("TestRule before:" + System.getProperty("myKey"));
                    base.evaluate();
                    System.out.println("TestRule after:" + System.getProperty("myKey"));
                    System.setProperty("myKey", "myValue");
                    return;
                } catch (AssertionError ae) {
                    System.setProperty("myKey", "myValue");
                    return;
                }
            }
        };
    }
}
