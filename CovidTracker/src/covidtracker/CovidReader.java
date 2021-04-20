package covidtracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to read in covid data and display it in a GUIWindow
 * 
 * @author mattwilson
 * @version 04.19.21
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
     * @param fileName covid file
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
            Object whiteCase = list[1];
            Object blackCase = list[2];
            Object latinCase = list[3];
            Object asianCase = list[4];
            Object otherCase = list[5];
            Object whiteDeath = list[6];
            Object blackDeath = list[7];
            Object latinDeath = list[8];
            Object asianDeath = list[9];
            Object otherDeath = list[10];
            Race white = new Race("White", whiteCase, whiteDeath);
            Race black = new Race("Black", blackCase, blackDeath);
            Race latin = new Race("LatinX", latinCase, latinDeath);
            Race asian = new Race("Asian", asianCase, asianDeath);
            Race other = new Race("Other", otherCase, otherDeath);
            tempArray[index] = new State(name, white, black, latin, asian,
                other);
            index++;

        }

        return tempArray;
    }
    
    /**
     * Returns the read file in state array form
     * @return state array
     */
    public State[] getStates() {
        return states;
    }

}
