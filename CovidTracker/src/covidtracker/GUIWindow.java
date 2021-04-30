package covidtracker;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Frontend representation of COVID data, shown in bar graphs.
 * View can be changed to be sorted by alphabet or by CFR, and
 * there are 6 states that can be alternated between to see data for.
 * 
 * @author Alip Arslan
 * @author Matt Wilson
 * @version 04.20.2021
 *
 */
public class GUIWindow {

    // Fields ........................................

    private State[] states;
    private Window window;
    private State currentlyDisplayed;
    private String currentComparator;

    // Constructor ...................................

    /**
     * Initializes buttons and the window
     */
    public GUIWindow(State[] states) { // leaving parameters empty for now for
                                       // testing
        this.states = states;
        currentlyDisplayed = null;
        currentComparator = "alpha";
        window = new Window();
        window.setTitle("Covid Statistics Tracker");
        window.setSize(600, 500);

        // Initialize buttons
        Button sortByAlphaButton = new Button("Sort by Alpha");
        sortByAlphaButton.onClick(this, "sortByAlpha");
        window.addButton(sortByAlphaButton, WindowSide.NORTH);

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        Button sortByCFRButton = new Button("Sort by CFR");
        sortByCFRButton.onClick(this, "sortByCFR");
        window.addButton(sortByCFRButton, WindowSide.NORTH);

        Button showDCButton = new Button("Represent DC");
        showDCButton.onClick(this, "showDC");
        window.addButton(showDCButton, WindowSide.SOUTH);

        Button showGAButton = new Button("Represent GA");
        showGAButton.onClick(this, "showGA");
        window.addButton(showGAButton, WindowSide.SOUTH);

        Button showMDButton = new Button("Represent MD");
        showMDButton.onClick(this, "showMD");
        window.addButton(showMDButton, WindowSide.SOUTH);

        Button showNCButton = new Button("Represent NC");
        showNCButton.onClick(this, "showNC");
        window.addButton(showNCButton, WindowSide.SOUTH);

        Button showTNButton = new Button("Represent TN");
        showTNButton.onClick(this, "showTN");
        window.addButton(showTNButton, WindowSide.SOUTH);

        Button showVAButton = new Button("Represent VA");
        showVAButton.onClick(this, "showVA");
        window.addButton(showVAButton, WindowSide.SOUTH);
    }

    // Methods .......................................


    /**
     * Displays DC covid data
     * 
     * @param button
     *            Represent DC
     */
    public void showDC(Button button) {
        currentlyDisplayed = states[0];
        updateGraph();
    }


    /**
     * Displays GA covid data
     * 
     * @param button
     *            Represent GA
     */
    public void showGA(Button button) {
        currentlyDisplayed = states[1];
        updateGraph();
    }


    /**
     * Displays MD covid data
     * 
     * @param button
     *            Represent MD
     */
    public void showMD(Button button) {
        currentlyDisplayed = states[2];
        updateGraph();
    }


    /**
     * Displays NC covid data
     * 
     * @param button
     *            Represent NC
     */
    public void showNC(Button button) {
        currentlyDisplayed = states[3];
        updateGraph();
    }


    /**
     * Displays TN covid data
     * 
     * @param button
     *            Represent TN
     */
    public void showTN(Button button) {
        currentlyDisplayed = states[4];
        updateGraph();
    }


    /**
     * Displays VA covid data
     * 
     * @param button
     *            Represent VA
     */
    public void showVA(Button button) {
        currentlyDisplayed = states[5];
        updateGraph();
    }


    /**
     * Quits out of the program
     * 
     * @param button
     *            Quit
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Sorts the races in alphabetic order
     * 
     * @param button
     *            Sort by Alpha
     */
    public void sortByAlpha(Button button) {
        currentComparator = "alpha";
        updateGraph();
    }


    /**
     * Sorts the races in descending CFR order
     * 
     * @param button
     *            Sort by CFR
     */
    public void sortByCFR(Button button) {
        currentComparator = "cfr";
        updateGraph();
    }


    /**
     * Updates the GUI when a button is pressed
     */
    private void updateGraph() {
        if (currentlyDisplayed != null) {
            // Start by sorting the races
            if (currentComparator.equals("alpha")) {
                currentlyDisplayed.sortRacesAlpha();
            }
            else {
                currentlyDisplayed.sortRacesCfr();
            }
            window.removeAllShapes();
            LinkedList<Race> races = currentlyDisplayed.getRaces();
            Iterator<Race> iterator = races.iterator();
            // Plotting Positions
            int graphStartX = window.getGraphPanelWidth() / 12;
            int textHeight = 8 * window.getGraphPanelHeight() / 10;
            int cfrHeight = 9 * window.getGraphPanelHeight() / 10;
            int currentPlottingX = graphStartX;

            // Adding bars and text
            while (iterator.hasNext()) {
                Race tempRace = iterator.next();
                float cfr = tempRace.getCFR();

                // Add race names
                TextShape shape = new TextShape(currentPlottingX - 20,
                    textHeight, tempRace.getName(), Color.black);
                window.addShape(shape);

                if (cfr == -1) {
                    // Add NA text
                    TextShape shapeNA = new TextShape(currentPlottingX - 10,
                        textHeight - 40, "NA", Color.black);
                    window.addShape(shapeNA);
                }
                else {
                    // Scales cfr to window size and plots
                    int calculatedHeight = (int)(cfr * 25);
                    Shape bar = new Shape(currentPlottingX, 275
                        - calculatedHeight, 10, calculatedHeight);
                    window.addShape(bar);

                    // Makes CFR value text presentable
                    DecimalFormat format = new DecimalFormat("0.0");
                    String cleanCFR = format.format(tempRace.getCFR());
                    if (cleanCFR.substring(cleanCFR.length() - 2, cleanCFR
                        .length()).equals(".0")) {
                        cleanCFR = cleanCFR.substring(0, cleanCFR.length() - 2);
                    }

                    // Add cfr text values
                    TextShape shapeCFR = new TextShape(currentPlottingX - 12,
                        cfrHeight, cleanCFR + '%', Color.black);
                    window.addShape(shapeCFR);

                }

                // Shifts start position for next column
                currentPlottingX = currentPlottingX + (1 * window
                    .getGraphPanelWidth() / 5);

            }

        }

    }

}
