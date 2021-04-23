package covidtracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to read in covid data and display it in a GUIWindow
 * 
 * @author mattwilson
 * @version 04.23.21
 *
 */
public class CovidReader {
    private State[] states;

    /**
     * Class constructor
     * 
     * @param file
     *            with COVID data
     * @throws FileNotFoundException
     */
    public CovidReader(String file) throws FileNotFoundException {
        states = this.readCovidFile(file);
    }


    /**
     * Reads covid file
     * 
     * @param fileName
     *            covid file
     * @return states array
     * @throws FileNotFoundException
     */
    private State[] readCovidFile(String fileName)
        throws FileNotFoundException {
        State[] tempArray = new State[6];
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        int index = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] list = line.split(",");
            String name = list[0];
            String whiteCase = list[1];
            String blackCase = list[2];
            String latinCase = list[3];
            String asianCase = list[4];
            String otherCase = list[5];
            String whiteDeath = list[6];
            String blackDeath = list[7];
            String latinDeath = list[8];
            String asianDeath = list[9];
            String otherDeath = list[10];
            Race white = new Race("white", whiteCase, whiteDeath);
            Race black = new Race("black", blackCase, blackDeath);
            Race latin = new Race("latinX", latinCase, latinDeath);
            Race asian = new Race("asian", asianCase, asianDeath);
            Race other = new Race("other", otherCase, otherDeath);
            tempArray[index] = new State(name, white, black, latin, asian,
                other);
            index++;

        }

        return tempArray;
    }


    /**
     * Returns the read file in state array form
     * 
     * @return state array
     */
    public State[] getStates() {
        return states;
    }

}
