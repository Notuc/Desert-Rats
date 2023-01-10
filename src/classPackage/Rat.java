package classPackage;
import interfaces.RatInterface;
import java.util.Random;

public class Rat implements RatInterface {
    private int exhaustion;
    private boolean alive;
    private String id;
    
    // Constructor
    public Rat(String id) {
        this.id = id;
        this.exhaustion = 0;
        this.alive = true;
    }
    
    // Getters
    public String getId() {
        return this.id;
    }
    
    public int getAliveState() {
        if (this.alive) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    // Other methods
    public String move() {
        // Generate a random number between 0 and 7
        Random rand = new Random();
        int direction = rand.nextInt(8);
        
        // Return the corresponding direction
        switch (direction) {
            case 0:
                return "N";
            case 1:
                return "NW";
            case 2:
                return "W";
            case 3:
                return "SW";
            case 4:
                return "S";
            case 5:
                return "SE";
            case 6:
                return "E";
            case 7:
                return "NE";
            default:
                return "Error";
        }
    }
    
    public void refresh() {
        this.exhaustion = 0;
    }
    
    public void wearDown() {
        this.exhaustion++;
        if (this.exhaustion >= 6) {
            this.alive = false;
        }
    }

    @Override
    public void escape() {
    }
    
}


