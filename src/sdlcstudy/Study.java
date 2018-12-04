/*
 * Justin VanderBerg and Lauren Thomas
 * December 4, 2018
 * This is a class used to read a file of study notes, and provide a convenient way for the study form
 * to display the notes
 */
package sdlcstudy;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin and Lauren
 */
public class Study {

    private String topics[];
    private String info[];

    public Study() {
        topics = null;
        info = null;
        readFile();
    }

    /**
     * Reads in the study notes from a data file and stores it in local
     * variables
     */
    private void readFile() {
        try {
            //InputStream in = Study.class.getResourceAsStream("Study.txt");
            //number of files read
            int numRead = 0;
            //initialize variables
            //InputStreamReader fr = new InputStreamReader(in);
            FileReader fr = new FileReader("src//sdlcstudy//Study.txt");
            BufferedReader br = new BufferedReader(fr);
            int numTopics = Integer.parseInt(br.readLine());
            topics = new String[numTopics];
            info = new String[numTopics];
            //loop through data file
            for (int i = 0; i < numTopics; i++) {
                topics[i] = br.readLine();
                info[i] = br.readLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }

    /**
     *
     * @param i index of title to get
     * @return Title of the topic
     */
    public String getTitle(int i) {
        return topics[i];
    }

    /**
     *
     * @param i index of information to get
     * @return information at the given index
     */
    public String getInfo(int i) {
        return info[i];
    }
}
