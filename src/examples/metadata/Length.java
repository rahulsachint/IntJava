package examples.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Length {

	int min() default 0; 
	int max() default Integer.MAX_VALUE;
}