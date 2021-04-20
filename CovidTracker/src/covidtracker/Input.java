package covidtracker;

/**
 * Class to run the whole project
 * 
 * @author mattwilson
 * @version 04.20.21
 */
public class Input {
    
    public static void main(String[] args) {
        CovidReader reader;

        if (args.length == 1) {
            reader = new CovidReader(args[0]);
        }
        else {
            reader = new CovidReader("input.txt");
        }

    }
}