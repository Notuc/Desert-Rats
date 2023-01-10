package classPackage;
import interfaces.RatInterface;
import interfaces.HoleInterface;

public class Hole extends Cell implements HoleInterface {
    // Counts the number of rats that disappear down the hole
    private int lostRats;

    public Hole(int[] location, char cellType) {
        super(location, cellType);
        this.lostRats = 0;
    }

    // Receives a rat and randomly determines if it goes down the hole
    // to another cell, escapes, or stays at this location
    @Override
    public int[] receiveRat(RatInterface pRat) {
        int[] newLocation = {-1, -1};

        // Generate a random number between 0 and 1
        double rand = Math.random();

        if (rand < 0.9) {
            // Transport the rat to another cell
            newLocation = transportRat(pRat);
        } else if (rand < 0.99) {
            // Rat escapes
            escapeRat(pRat);
        } else {
            // Rat stays at this location
            newLocation = location;
            receiveRat(pRat);
        }

        return newLocation;
    }

    // Randomly transports the rat to another hole
    private int[] transportRat(RatInterface pRat) {
        /* 
            // Generate a random row and column
            int randRow = (int)(Math.random() * Grid.MAX_ROW);
            int randCol = (int)(Math.random() * Grid.MAX_COL);
        
            // Check if the randomly generated location is a hole
            // If not, try again until we find a hole
            while (grid[randRow][randCol].getCellType() != 'H') {
                randRow = (int)(Math.random() * Grid.MAX_ROW);
                randCol = (int)(Math.random() * Grid.MAX_COL);
            }
        
            // Return the location of the hole
            return new int[] {randRow, randCol};
        }
        */

        return location;
    }

    // Makes the rat escape
    private void escapeRat(RatInterface pRat) {
        lostRats++;
        pRat.escape();
    }

    // Returns the count of rats that escape/disappear down the hole
    @Override
    public int countLostSouls() {
        return lostRats;
    }
}
