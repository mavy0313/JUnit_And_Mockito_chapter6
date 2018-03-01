package exercises.enhancedretrytestrule;

import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RetryTestEnhancedRule implements TestRule {

    private int retryNumber;
    private boolean retryTest;

//    @Override
//    public Statement apply(Statement base, FrameworkMethod frameworkMethod, Object o) {
//        return new Statement() {
//            @Override
//            public void evaluate() throws Throwable {
//                try {
//                    base.evaluate();
//                } catch (AssertionError ae) {
////                    int retryNumber = description.getTestClass()
////                            .getMethod(description.getMethodName())
////                            .getAnnotation(RetryTest.class).retryNb();
////
////                    boolean retryTest = description.getTestClass()
////                            .getMethod(description.getMethodName())
////                            .isAnnotationPresent(RetryTest.class);
////
////                    for (int i = 0; retryTest && i < retryNumber; i++) {
////                        base.evaluate();
////                    }
//                }
//            }
//        };
//    }

    @Override
    public Statement apply(final Statement base, final Description description) {

        System.out.println("Inside rule");

        try {
            retryTest = description.getTestClass()
                    .getMethod(description.getMethodName())
                    .isAnnotationPresent(RetryTest.class);
            if (retryTest) {
                retryNumber = description.getTestClass()
                        .getMethod(description.getMethodName())
                        .getAnnotation(RetryTest.class).retryNb();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                for (int i = 0; retryTest && i < retryNumber; i++) {
                    try {
                        base.evaluate();
                    } catch (AssertionError ae) {
//                    int retryNumber = description.getTestClass()
//                            .getMethod(description.getMethodName())
//                            .getAnnotation(RetryTest.class).retryNb();
//
//                    boolean retryTest = description.getTestClass()
//                            .getMethod(description.getMethodName())
//                            .isAnnotationPresent(RetryTest.class);

//                    for (int i = 1; retryTest && i < retryNumber; i++) {
//                        base.evaluate();
//                    }
                        //base.evaluate();
                    }
                }
            }
        };
    }
}
