/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import covidtracker.State;
import covidtracker.CovidReader;
import covidtracker.GUIWindow;

/**
 * 
 * @author Alip Arslan
 * @version 04.20.2021
 *
 */
public class Input {

    /**
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            CovidReader reader = new CovidReader(args[0]);
            State[] states = reader.getStates();
            GUIWindow window = new GUIWindow(states);

            }

        else {
            CovidReader reader = new CovidReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            State[] states = reader.getStates();
            GUIWindow window = new GUIWindow(states);

        }
    }
}
