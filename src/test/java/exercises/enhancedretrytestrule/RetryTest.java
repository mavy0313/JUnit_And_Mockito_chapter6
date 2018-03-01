package exercises.enhancedretrytestrule;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RetryTest {
    int retryNb();
}
