/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlcstudy;

import java.io.*;
import java.util.Arrays;

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
            int numRead = 0;
            FileReader fr = new FileReader("src//sdlcstudy//Quiz.txt");
            BufferedReader br = new BufferedReader(fr);
            numQuestions = Integer.parseInt(br.readLine());
            questions = new String[numQuestions];
            answers = new String[numQuestions * 4];
            correctAnswers = new int[numQuestions];
            for (int i = 0; i < numQuestions; i++) {
                questions[i] = br.readLine();
                for (int j = numRead * 4; j < (numRead * 4) + 4; j++) {
                    answers[j] = br.readLine();
                }
                correctAnswers[i] = Integer.parseInt(br.readLine());
                numRead++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @param i index of question you want
     * @return question at index i
     */
    public String getQuestion(int i) {
        return questions[i];
    }

    /**
     *
     * @param i index of the answer you want
     * @return A string of answers to question number "i"
     */
    public String[] getAnswers(int i) {
        String[] tArr = new String[4];
        for (int j = 0; j < 4; j++) {
            tArr[j] = answers[(i * 4) + j];
        }
        return tArr;
    }

    /**
     *
     * @param i index of the answer you want
     * @return number of the correct answer to question number "i"
     */
    public int getCorrectAnswer(int i) {
        return correctAnswers[i];
    }

    @Override
    public String toString() {
        return "Quiz{" + "\n questions=" + Arrays.toString(questions) + "\n answers=" + Arrays.toString(answers) + "\n correctAnswers=" + Arrays.toString(correctAnswers) + "\n numQuestions=" + numQuestions + "\n}";
    }

}
