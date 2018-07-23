package org.rap.prgtests;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// The annotation declaration
@Retention(RetentionPolicy.RUNTIME)
@interface NewAnnotationType {
	String value();
}

@NewAnnotationType("A parameter")
public class Annotations {
// Empty class!

	public static void main(String[] args) {
		// Not instantiating! using just the class!
    	Class<Annotations> newClass = Annotations.class;

    	// Accessing the annotation
    	System.out.println(newClass.getAnnotation(NewAnnotationType.class).value());
    	
    	// Accessing all annotations
		for (Annotation annotation : newClass.getDeclaredAnnotations()) {
		    System.out.println(annotation.toString());
		}

		// Or, using an object
    	Annotations object=new Annotations();
    	Class<? extends Annotations> clazz=object.getClass();
    	System.out.println(clazz.getAnnotation(NewAnnotationType.class).value());
	}
}