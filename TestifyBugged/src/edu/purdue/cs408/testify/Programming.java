package edu.purdue.cs408.testify;

import java.io.Serializable;

/**
 * Represents a programming question.
 */
public class Programming extends Question implements Serializable {
    private Language lang;
    private String fileName;
    private String compilerOutput = "";
    private String comments = "";
    private Boolean compiles;
    private int numOfCompiles = 0;
    public Programming(String prompt, Language lang) {
        super(prompt);
        this.lang = lang;
    }
    
    public Programming() {
        super();
    }
    
    public String getFile() {
        return fileName;
    }
    
    public Language getLang() {
        return lang;
    }
    
    public String getCompilerOutput() {
        return compilerOutput;
    }
    
    public void setFile(String file) {
        fileName = file;
    }
    /**
     * @param lang the lang to set
     */
    public void setLang(Language lang) {
        this.lang = lang;
    }
    
    public void setCompilerOutput(String output) {
        this.compilerOutput = output;
    }
    
    public void incrementNumOfCompiles() {
        numOfCompiles++;
    }
    
    public int getNumOfCompiles() {
        return ++numOfCompiles;
    }
    /**
     * @return the comments
     */
    public String getComments() {
        return comments + " " + comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Did the solution compile?
     * @return the compiles
     */
    public Boolean getCompiles() {
        return compiles;
    }

    /**
     * @param value 
     */
    public void setCompiles(boolean value) {
        this.compiles = value;
    }
}
