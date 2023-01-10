package classPackage;
import interfaces.CellInterface;
import java.util.ArrayList;
import interfaces.RatInterface;

public class Cell implements CellInterface {
    // Location of the cell on the grid
    private final int[] location;
    // Type of the cell
    private final char cellType;
    // List of dead rats in the cell
    private ArrayList<RatInterface> deadRats;
    // Rat currently in the cell
    private RatInterface rat;

    public Cell(int[] location, char cellType) {
        this.location = location;
        this.cellType = cellType;
        this.deadRats = new ArrayList<>();
    }

    // Returns the type of the cell
    public char getCellType() {
        return cellType;
    }

    // Receives a rat and stores it in the cell
    public int[] receiveRat(RatInterface rat) {
        this.rat = rat;
        return location;
    }

    // Returns the rat currently in the cell, if any
    public RatInterface retrieveRat() {
        return rat;
    }

    // Stores the dead rat in the cell
    public void storeTheDead(RatInterface rat) {
        deadRats.add(rat);
    }

    // Returns a list of the dead rats in the cell
    public ArrayList<RatInterface> returnTheDead() {
        return deadRats;
    }

    // Randomly wears down or refreshes the rat in the cell
    public void wearDownOrRefreshRat() {
        if (rat != null) {
            // Generate a random number between 0 and 1
            double rand = Math.random();
            if (rand < 0.5) {
                // Wear down the rat
                rat.wearDown();
            } else {
                // Refresh the rat
                rat.refresh();
            }
        }
    }
}


