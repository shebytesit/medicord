package edu.purdue.cs408.testify;

import java.io.Serializable;

/**
 * Represents a Question and provides general functionality common to all types
 * of questions.
 */
public abstract class Question implements Serializable {
    private String prompt;
    private String answer;
    private int ptsPossible;
    private int ptsEarned;
    
    /** Create a blank question. */
    protected Question() {
        
    }
    
    protected Question(String prompt) {
        this.prompt = prompt;
    }
    
    public int getPtsPossible() {
        return ptsPossible;
    }
    
    public int getPtsEarned() {
        return ptsEarned;
    }
    
    public String getPrompt() {
        return prompt;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /** Assign points earned to this question */
    public void grade(int ptsEarned) {
        this.setPtsEarned(ptsEarned);
    }

    /**
     * @param prompt the prompt to set
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * @param ptsPossible the ptsPossible to set
     */
    public void setPtsPossible(int ptsPossible) {
        this.ptsPossible = ptsPossible;
    }

    /**
     * @param ptsEarned the ptsEarned to set
     */
    public void setPtsEarned(int ptsEarned) {
        this.ptsEarned = ptsEarned;
    }

}
