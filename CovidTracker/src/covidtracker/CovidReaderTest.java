package covidtracker;

/**
 * Class to test the Covid Reader class
 * @author mattwilson
 * @version 04.20.21
 *
 */
public class CovidReaderTest extends student.TestCase {
    Race whiteDC;
    Race blackDC;
    Race latinDC;
    Race asianDC;
    Race otherDC;
    Race whiteGA;
    Race blackGA;
    Race latinGA;
    Race asianGA;
    Race otherGA;
    Race whiteMD;
    Race blackMD;
    Race latinMD;
    Race asianMD;
    Race otherMD;
    Race whiteNC;
    Race blackNC;
    Race latinNC;
    Race asianNC;
    Race otherNC;
    Race whiteTN;
    Race blackTN;
    Race latinTN;
    Race asianTN;
    Race otherTN;
    Race whiteVA;
    Race blackVA;
    Race latinVA;
    Race asianVA;
    Race otherVA;
    State dc;
    State ga;
    State md;
    State nc;
    State tn;
    State va;
    State[] states;
    
    
    
    /**
     * Set up tests
     */
    public void setUp() {
        Race whiteDC = new Race("White",70678,1924);
        Race blackDC = new Race("Black",179563,13365);
        Race latinDC = new Race("LatinX",97118,2269);
        Race asianDC = new Race("Asian",5407,254);
        Race otherDC = new Race("Other",108784,170);
        Race whiteGA = new Race("White",1122398,51012);
        Race blackGA = new Race("Black",1199125,50296);
        Race latinGA = new Race("LatinX",601778,6152);
        Race asianGA = new Race("Asian",60426,1846);
        Race otherGA = new Race("Other",1542083,1848);
        Race whiteMD = new Race("White",534910,44759);
        Race blackMD = new Race("Black",764514,42863);
        Race latinMD = new Race("LatinX",635420,11343);
        Race asianMD = new Race("Asian",47733,3999);
        Race otherMD = new Race("Other",539893,2103);
        Race whiteNC;
        Race blackNC;
        Race latinNC;
        Race asianNC;
        Race otherNC;
        Race whiteTN;
        Race blackTN;
        Race latinTN;
        Race asianTN;
        Race otherTN;
        Race whiteVA;
        Race blackVA;
        Race latinVA;
        Race asianVA;
        Race otherVA;
        State dc = new State("DC",whiteDC,blackDC,latinDC,asianDC,otherDC);
        State ga = new State("GA",whiteGA,blackGA,latinGA,asianGA,otherGA);
        State md = new State("MD",whiteMD,blackMD,latinMD,asianMD,otherMD);
        State nc;
        State tn;
        State va;
        State[] states = new State[6];
        states[0] = dc;
        states[1] = ga;
        states[2] = md;
        states[3] = nc;
        states[4] = tn;
        states[5] = va;
    }
}
