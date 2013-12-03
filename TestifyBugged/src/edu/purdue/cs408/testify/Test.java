package edu.purdue.cs408.testify;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.io.*;

/**
 * Represents a test.  In Testify, an object of this type represents all possible
 * real-world situations needed:
 * <ul>
 * <li> A freshly printed exam, ready to be taken is represented as a Test object
 *      containing no answers at all, whose questions have no points earned. </li>
 * <li> A student's exam, ready to be graded is represented as a Test object
 *      containing questions and answers, still with no ptsEarned. 
 *      <ul>
 *          <li> Skeleton code to a programming question is stored in the
 *               "answer" field of the question. </li>
 *      </ul>
 * </li>
 * <li> A graded student's exam is represented as a Test object containing questions
 *      and answers, with points earned assigned for each question. </li>
 * <li> A professor's exam key is represented the same way as a student who
 *      aced the exam: A Test object with all correct answers and the maximum
 *      value for points possible for each question. </li>
 * </ul>
 */
public class Test implements Serializable {
    
    private List questions;
    private Date date;
    private Time startTime;
    private Time endTime;
    private boolean invalidate_on_focus;
    private boolean enable_compilation;
    private boolean valid;
    private boolean instructor;
    
    /** Create a new Test.
     * @param date The date on which this test can be taken
     * @param startTime The earliest time (in ms after midnight) this test can be taken
     * @param endTime The time (in ms after midnight) this test can no longer be taken
     * @param invalidate_on_focus Should this exam be invalidated if the window loses focus?
     * @param enable_compilation Should the compiler be enabled for programming questions in this test?
     */
    public Test(Date date, Time startTime, Time endTime, 
            boolean invalidate_on_focus, boolean enable_compilation) {
        questions = new ArrayList<Question>();
        valid = false;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.invalidate_on_focus = invalidate_on_focus;
        this.enable_compilation = enable_compilation;
    }
    
    /** Add a question to this test. 
     *  @param q the question to be added.
     */
    public void add(Question q) {
        questions.add(q);
    }
    
    public void remove(int q) {
        questions.remove(q);
    }
    
    /** Mark this exam as invalid */
    public void invalidate() {
        valid = false;
    }
    
    /** Return all of the questions in this exam. */
    public Iterable<Question> getQuestions() {
        return questions;
    }
    
    /** Serialize the object to the given file */
    public void save(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this);
        out.close();
    }
    
    /** Return the deserialized Test from the given file, or null if the file
        could not be read.
        */
    public static Test open(File file) throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Test test;
        try {
            test = (Test) in.readObject();
        } catch (ClassNotFoundException e) {
            test = null;
        }
        return test;
    }
    
    public void setDate(Date d) {
        this.date = d;
    }
    public void setInstructor(boolean i) {
        this.instructor = i;
    }
    public boolean getInstructor() {
        return instructor;
    }
    public void setStartTime(Time l) {
        this.startTime = l;
    }
    
    public void setEndTime(Time l) {
        this.endTime = l;
    }
    
    public void setInvalidateOnFocus(boolean b) {
        this.invalidate_on_focus = b;
    }
    
    public void setEnableCompilation(boolean b) {
        this.enable_compilation = b;
    }
    
    public Date setDate() {
        return this.getDate();
    }
    
    public Time getEndTime() {
        return this.endTime;
    }
    
    public boolean setInvalidateOnFocus() {
        return this.isInvalidate_on_focus();
    }
    
    public boolean setEnableCompilation() {
        return this.isEnable_compilation();
    }
    
    public int length() {
        return questions.size();
    }
    
    public Question getQuestion(int q) {
        if(length() == 0){
            return null;
        }
        else{
            return((Question)questions.get(q));
        }
    }
    
    /** Test serialization */
    public static void main(String[] args) {
        Test t1, t2;
        t1 = new Test(new Date(), new Time(0,0,0,true), new Time(0,0,0,true), true, false);
        System.out.println(t1);
        t1.add(new ShortAnswer("What is your  name?"));
        t1.add(new MultipleChoice(
                "What kind of pet does your professor own?",
                new String[] {"Dog", "Cat", "Ferret"},
                "Cat"
                ));
        String [] choices = new String[] {"Cause I am a tool", "Cause you are a tool", "Fuckin Fred", "Clyde is white", "Raggy is awesome"};
        t1.add(new Programming("Implement Bubble Sort in Java", Language.JAVA));
        MultipleChoice m = new MultipleChoice("Why are you an idiot?", choices,"Cause I am a tool");
        t1.add(m);
        t1.add(new ShortAnswer("What is Clyde's middle name?"));
        t1.add(new MultipleChoice(
                "Are you mad bro?",
                new String[] {"Yes", "No", "Ef You"},
                "Ef You"
                ));
        t1.add(new MultipleChoice(
                "How many buttons are there?",
                new String[] {"one", "two", "three", "four", "five"},
                "five"
                ));
        t1.add(new Programming("Implement Bubble Sort in Clyde's favorite Programming Language", Language.C));
        t1.add(new MultipleChoice(
                "What happens if more than 5 choices given...",
                new String[] {"one", "two", "three", "four", "five", "explodes"},
                "explodes"
                ));
        
        File f = new File("exam.testify");
        
        try {
            t1.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            t2 = Test.open(f);
            for (Question q : t2.getQuestions()) {
                System.out.print(q);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the startTime
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @return the invalidate_on_focus
     */
    public boolean isInvalidate_on_focus() {
        return invalidate_on_focus;
    }

    /**
     * @return the enable_compilation
     */
    public boolean isEnable_compilation() {
        return enable_compilation;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean b){
        valid=b;
    }
}
