package edu.purdue.cs408.testify;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

/**
 * Represents a multiple choice question.
 */
public class MultipleChoice extends Question implements Serializable {
    private List<String> choices;
    private String correctAnswer;

    /** Create a blank multiple choice question. */
    public MultipleChoice() {
        super();
        choices = new ArrayList<String>();
    }
    
    public void addChoice(String choice) {
        choices.add(choice);
    }
    
    public void removeChoice(String choice) {
        choices.remove(choice);
    }
    
    public List<String> getChoices() {
        return choices;
    }
    
    /**
     * 
     * @param prompt Question to ask
     * @param choices Possible answers
     * @param correctAnswer The answer that is correct
     * @throws IllegalArgumentException 
     */
    public MultipleChoice(String prompt, String[] choices, String correctAnswer) throws IllegalArgumentException {
        super(prompt);
        this.choices = new ArrayList<String>();
        if (!Arrays.asList(choices).contains(correctAnswer)) {
            throw new IllegalArgumentException("List of choices, " + 
                    Arrays.toString(choices) + String.format(" does not contain the indicated correct answer, %s", correctAnswer));
        }
        this.choices.addAll(Arrays.asList(choices));
        this.correctAnswer = correctAnswer;
    }
    
    /** Automatically grade this question. */
    public void grade() {
        if (getCorrectAnswer().equals(getAnswer())) {
            grade(getPtsPossible());
        } else {
            grade(0);
        }
    }
    
    public String toString() {
        return String.format(
                "Multiple Choice Question\nPrompt: %s\nChoices: %s\n, Answer: %s\nPoss: %d\nEarned: %d\n", getPrompt(), Arrays.toString(choices.toArray()), getAnswer(), getPtsPossible(), getPtsEarned());
    }

    /**
     * @return the correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
