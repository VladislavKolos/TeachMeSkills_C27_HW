package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect to intercept method calls annotated with {@link org.example.annotation.AspectAnnotation}
 * and performing additional logic before executing them.
 */
@Aspect
@Component
public class ProcessingServiceAspect {

    /**
     * Method executed before calling any method annotated with {@link org.example.annotation.AspectAnnotation}.
     *
     * @param joinPoint information about the current connection, including the method that was called
     */
    @Before("@annotation(org.example.annotation.AspectAnnotation)")
    public void displayAGreeting(JoinPoint joinPoint) {
        String arg = (String) joinPoint.getArgs()[0];
        if (arg.equals("Vladislav")) {
            System.out.println("Hello " + arg + "\n");
        } else {
            System.out.println(arg + " - Invalid value\n");
        }
    }
}
