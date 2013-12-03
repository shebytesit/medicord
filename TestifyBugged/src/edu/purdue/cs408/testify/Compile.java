/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.purdue.cs408.testify;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author CBIII
 */
public class Compile {
    
    public static ProcessBuilder getProcess (String fileName) {
        
        String OS = System.getProperty("os.name").toLowerCase();
        return new ProcessBuilder("/bin/bash", "-c", "make "); 
        

    }
    
    
    public static String compile (String fileName) {
        
        String compileMessage = "";
        int processOutput = 0;
        ProcessBuilder compile = getProcess(fileName);
        Process process;
        
        try {
            
            compile.directory(new File("automation"));
            compile.redirectErrorStream(true);
      
            process = compile.start();
            InputStream processOutputStream = process.getInputStream();
            
            if (processOutputStream == null) {
                return "Error: Input Stream was null.";
            }
          
          
            for(int i = 0; processOutput != -1; i++) {
                    
                 processOutput = processOutputStream.read();
                 if(i % 4 == 0)
                    compileMessage += (char)processOutput;
                
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
            compileMessage = e.getMessage();
        }
        return compileMessage;
    }

}
