package covidtracker;

/**
 * Class for creating state objects
 * 
 * @author Matt Wilson
 * @version 04.18.21
 *
 */
public class State implements Comparable<State> {
    String name;
    Race white;
    Race black;
    Race latin;
    Race asian;
    Race other;
    LinkedList<Race> races;

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
     * Sorts the linked list of races by their respective CFR
     */
    public void sortCFR() {
        // TO-DO write comparator
    }


    /**
     * Sorts the linked list of races alphabetically
     */
    public void sortAlpha() {
        // TO-DO write comparator
    }


    /**
     * String representation of state
     * 
     * @return String of state information
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[State: ");
        builder.append(name);
        builder.append(", White CFR: ");
        builder.append(String.valueOf(white.getCFR()));
        builder.append(", Black CFR: ");
        builder.append(String.valueOf(black.getCFR()));
        builder.append(", Latin CFR: ");
        builder.append(String.valueOf(latin.getCFR()));
        builder.append(", Asian CFR: ");
        builder.append(String.valueOf(asian.getCFR()));
        builder.append(",Other CFR: ");
        builder.append(String.valueOf(other.getCFR()));
        builder.append("]");

        return builder.toString();

    }


    @Override
    public int compareTo(State newState) {

        return 0;
    }

}