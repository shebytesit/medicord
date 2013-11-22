package edu.purdue.cs408.testify;

import java.io.Serializable;

/**
 * Represents a short answer question.
 * 
 */
public class ShortAnswer extends Question implements Serializable {
    public ShortAnswer(String prompt) {
        super(prompt);
    }
    
    public ShortAnswer() {
        super();
    }
    
    public String toString() {
        return String.format(
                "Short Answer Question\nPrompt: %s\nAnswer: %s\n", getPrompt(), getAnswer());
    }
}
