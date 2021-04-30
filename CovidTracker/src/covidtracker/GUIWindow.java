package covidtracker;

import java.util.Iterator;

/**
 * 
 * @author Alip Arslan
 * @version 04.20.2021
 *
 */
public class GUIWindow {

    // Fields ........................................

    private LinkedList<State> states;
    private Window window;
    private State currentlyDisplayed;
    private String currentComparator;

    // Constructor ...................................

    /**
     * 
     */
    public GUIWindow() { // leaving parameters empty for now for testing
        this.states = states;
        currentlyDisplayed = null;
        currentComparator = "alpha";
        window = new Window();
        window.setTitle("Covid Statistics Tracker");
        
        // Initialize buttons
        Button sortByAlphaButton = new Button("Sort by Alpha");
        sortByAlphaButton.onClick(this, "sortByAlpha");
        window.addButton(sortByAlphaButton, WindowSide.NORTH);
        
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        
        Button sortByCFRButton = new Button("Sort by CFR");
        sortByCFRButton.onClick(this,"sortByCFR");
        window.addButton(sortByAlphaButton, WindowSide.NORTH);
        
        Button showDCButton = new Button("Represent DC");
        showDCButton.onClick(this,"showDC");
        window.addButton(showDCButton, WindowSide.SOUTH);
        
        Button showGAButton = new Button("Represent GA");
        showGAButton.onClick(this,"showGA");
        window.addButton(showGAButton, WindowSide.SOUTH);
        
        Button showMDButton = new Button("Represent MD");
        showMDButton.onClick(this,"showMD");
        window.addButton(showMDButton, WindowSide.SOUTH);
        
        Button showNCButton = new Button("Represent NC");
        showNCButton.onClick(this,"showNC");
        window.addButton(showNCButton, WindowSide.SOUTH);
        
        Button showTNButton = new Button("Represent TN");
        showTNButton.onClick(this,"showTN");
        window.addButton(showTNButton, WindowSide.SOUTH);
        
        Button showVAButton = new Button("Represent VA");
        showVAButton.onClick(this,"showVA");
        window.addButton(showVAButton, WindowSide.SOUTH);
    }

    // Methods .......................................
    
    /**
     * Displays DC covid data
     * @param button Represent DC
     */
    public void showDC(Button button) {
        currentlyDisplayed = states.get(0);
        updateGraph();
    }
    
    /**
     * Displays GA covid data
     * @param button Represent GA
     */
    public void showGA(Button button) {
        currentlyDisplayed = states.get(1);
        updateGraph();
    }
    
    /**
     * Displays MD covid data
     * @param button Represent MD
     */
    public void showMD(Button button) {
        currentlyDisplayed = states.get(2);
        updateGraph();
    }
    
    /**
     * Displays NC covid data
     * @param button Represent NC
     */
    public void showNC(Button button) {
        currentlyDisplayed = states.get(2);
        updateGraph();
    }
    
    /**
     * Displays TN covid data
     * @param button Represent TN
     */
    public void showTN(Button button) {
        currentlyDisplayed = states.get(3);
        updateGraph();
    }
    
    /**
     * Displays VA covid data
     * @param button Represent VA
     */
    public void showVA(Button button) {
        currentlyDisplayed = states.get(4);
        updateGraph();
    }


    /**
     * Quits out of the program
     * @param button Quit
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * Sorts the races in alphabetic order
     * @param button Sort by Alpha
     */
    public void sortByAlpha(Button button) {
        currentComparator = "alpha";
        updateGraph();
    }
    
    /**
     * Sorts the races in descending CFR order
     * @param button Sort by CFR
     */
    public void sortByAlpha(Button button) {
        currentComparator = "cfr";
        updateGraph();
    }
    
    
    
    private void updateGraph() {
        // Start by sorting the races
        if (currentComparator.equals("alpha")) {
            currentlyDisplayed.sortRacesAlpha();
        } else {
            currentlyDisplayed.sortRacesCfr();
        }
        LinkedList<Race> races = currentlyDisplayed.getRaces();
        Iterator<Race> iterator = races.iterator();
        int graphStartX = window.getGraphPanelWidth() / 10;
        int graphStartY = window.getGraphPanelWidth() / 10;
        while (iterator.hasNext()) {
            
        }
        
        
        
        
        
    }

}
