package covidtracker;

import java.text.DecimalFormat;
import java.util.Iterator;

/**
 * Class for creating state objects
 * 
 * @author Matt Wilson
 * @author Carly Daffam
 * @version 04.23.21
 *
 */
public class State {
    private String name;
    private LinkedList<Race> races;

    /**
     * Class constructor
     * 
     * @param stateName
     *            name
     * @param whiteRace
     *            white
     * @param blackRace
     *            black
     * @param latinRace
     *            latin
     * @param asianRace
     *            asian
     * @param otherRace
     *            other
     */
    public State(
        String stateName,
        Race whiteRace,
        Race blackRace,
        Race latinRace,
        Race asianRace,
        Race otherRace) {
        this.name = stateName;
        Race white = whiteRace;
        Race black = blackRace;
        Race latin = latinRace;
        Race asian = asianRace;
        Race other = otherRace;
        races = new LinkedList<Race>();
        races.add(white);
        races.add(black);
        races.add(latin);
        races.add(asian);
        races.add(other);
    }


    /**
     * Returns the name of the state
     * 
     * @return name of state
     */
    public String getName() {
        return name;
    }


    /**
     * Sorts the races linked list within the class into alphabetical order
     */
    public void sortRacesAlpha() {
        races.sort(new CompareAlpha());
    }


    /**
     * Sorts the races linked list within the class into decreasing CFR
     */
    public void sortRacesCfr() {
        races.sort(new CompareCFR());
    }


    /**
     * Returns the linked list of races to then display
     * 
     * @return linked list of races
     */
    public LinkedList<Race> getRaces() {
        return races;
    }


    /**
     * String representation of state
     * 
     * @return String of state information
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        builder.append("\n");
        races.sort(new CompareAlpha()); // change
        Iterator<Race> iterator = races.iterator();
        while (iterator.hasNext()) {
            Race tempRace = iterator.next();
            builder.append(tempRace.getName());
            builder.append(": ");
            builder.append(String.valueOf(tempRace.getCases()));
            builder.append(" cases, ");
            DecimalFormat format = new DecimalFormat("0.0");
            String cleanCFR = format.format(tempRace.getCFR());
            if (cleanCFR.substring(cleanCFR.length() - 2, cleanCFR.length())
                .equals(".0")) {
                cleanCFR = cleanCFR.substring(0, cleanCFR.length() - 2);
            }
            builder.append(cleanCFR);
            builder.append("% CFR");
            builder.append("\n");
        }
        builder.append("=====");
        builder.append("\n");
        races.sort(new CompareCFR()); // change
        Iterator<Race> iterator2 = races.iterator();
        while (iterator2.hasNext()) {
            Race tempRace = iterator2.next();
            builder.append(tempRace.getName());
            builder.append(": ");
            builder.append(String.valueOf(tempRace.getCases()));
            builder.append(" cases, ");
            DecimalFormat format = new DecimalFormat("0.0");
            String cleanCFR = format.format(tempRace.getCFR());
            if (cleanCFR.substring(cleanCFR.length() - 2, cleanCFR.length())
                .equals(".0")) {
                cleanCFR = cleanCFR.substring(0, cleanCFR.length() - 2);
            }
            builder.append(cleanCFR);
            builder.append("% CFR");
            builder.append("\n");
        }
        builder.append("=====");
        builder.append("\n");
        return builder.toString();

    }


    /**
     * Checks to see if two states are identical
     * 
     * @return boolean if the same or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }

        else {
            return (this.toString().equals(((State)obj).toString()));
        }
    }

}
