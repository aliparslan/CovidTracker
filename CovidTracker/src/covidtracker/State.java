package covidtracker;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Class for creating state objects
 * 
 * @author Matt Wilson
 * @version 04.18.21
 *
 */
public class State implements Comparable<State> {
    private String name;
    private Race white;
    private Race black;
    private Race latin;
    private Race asian;
    private Race other;
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
        this.white = whiteRace;
        this.black = blackRace;
        this.latin = latinRace;
        this.asian = asianRace;
        this.other = otherRace;
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
     * String representation of state
     * 
     * @return String of state information
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        builder.append("\n");
        this.sortAlpha();
        Iterator<Race> iterator = races.iterator();
        while (iterator.hasNext()) {
            Race tempRace = iterator.next();
            builder.append(tempRace.getName());
            builder.append(": ");
            builder.append(String.valueOf(tempRace.getCases()));
            builder.append(", ");
            DecimalFormat format = new DecimalFormat("0.0");
            String cleanCFR = format.format(tempRace.getCFR());
            builder.append(cleanCFR);
            builder.append("% CFR");
            builder.append("\n");
        }
        builder.append("=====");
        builder.append("\n");
        this.sortCFR();
        Iterator<Race> iterator2 = races.iterator();
        while (iterator2.hasNext()) {
            Race tempRace = iterator2.next();
            builder.append(tempRace.getName());
            builder.append(": ");
            builder.append(String.valueOf(tempRace.getCases()));
            builder.append(", ");
            DecimalFormat format = new DecimalFormat("0.0");
            String cleanCFR = format.format(tempRace.getCFR());
            builder.append(cleanCFR);
            builder.append("% CFR");
            builder.append("\n");
        }
        builder.append("=====");

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


    @Override
    public int compareTo(State newState) {

        return 0;
    }
}
