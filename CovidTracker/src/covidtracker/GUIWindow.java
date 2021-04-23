package covidtracker;

import cs2.*;

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

    // Constructor ...................................

    /**
     * 
     */
    public GUIWindow() { // leaving parameters empty for now for testing
        this.states = states;
        window = new Window();
        window.setTitle("Covid Statistics Tracker");

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        Button sortByAlphaButton = new Button("Sort by Alpha");
        sortByAlphaButton.onClick(this, "sortByAlpha");
        window.addButton(sortByAlphaButton, WindowSide.EAST);

        // and so on for these
        Button sortByCFRButton;
        Button sortByDCButton;
        Button sortByGAButton;
        Button sortByMDButton;
        Button sortByNCButton;
        Button sortByTNButton;
        Button sortByVAButton;
    }

    // Methods .......................................


    /**
     * 
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
