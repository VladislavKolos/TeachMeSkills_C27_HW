package org.example.service;

import org.example.annotation.AspectAnnotation;
import org.springframework.stereotype.Service;

/**
 * Service class for string processing.
 */
@Service
public class ProcessingService {

    /**
     * Returns the first string with additional text added.
     *
     * @param string1 string to process
     * @return processed string with added text
     */
    @AspectAnnotation
    public String returnFirstString(String string1) {
        System.out.println("Inside returnFirstString:");
        return string1 + " - First implementation\n";
    }

    /**
     * Returns the second string with additional text added.
     *
     * @param string2 string to process
     * @return processed string with added text
     */
    public String returnSecondString(String string2) {
        System.out.println("Inside returnSecondString:");
        return string2 + " - Second implementation\n";
    }
}
