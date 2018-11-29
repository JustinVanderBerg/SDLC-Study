/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlcstudy;

import java.io.*;

/**
 *
 * @author justin Added some test comments
 */
public class Quiz {

    private String[] questions;
    private String[] answers;
    private int[] correctAnswers;
    private int numQuestions;
    /**
     * Default constructor
     */
    public Quiz() {
        questions = null;
        answers = null;
        correctAnswers = null;
        numQuestions = 0;
        readFile();
    }

    private void readFile() {
        try {
            FileReader fr = new FileReader("src\\sdlcstudy\\Quiz.txt");
            BufferedReader br = new BufferedReader(fr);
            numQuestions = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < numQuestions; i++) {
                questions[i] = br.readLine();
                for (int j = 0; j < 4; j++) {
                    answers[j] = br.readLine();
                }
                correctAnswers[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
