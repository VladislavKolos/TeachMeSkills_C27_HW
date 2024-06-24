# TeachMeSkills_C27_Lesson_40_HW
Homework for lesson #40

1. **Task #1**

A service has been written that contains two methods. An aspect is written that listens to one of the methods and if a name is entered, displays "Hello + name", otherwise displays "Invalid value".
Project contains:
- Annotation interface **"AspectAnnotation"** intended to indicate that a class is an aspect in an "AOP" system;
- "Spring" configuration class **"AppConfig"** for the application;
- Service class **"ProcessingService"** with **"returnFirstString"** and **"returnSecondString"** methods for string processing;
- Aspect class **"ProcessingServiceAspect"** to intercept method calls and performing additional logic before executing them;
- Main application class **"Main"** that starts the "Spring context" and calls service methods to process strings.
