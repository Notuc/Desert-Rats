package classPackage;
import interfaces.RatStatusInterface;

public class RatStatus implements RatStatusInterface {
    // ID of the rat
    private final String ratID;
    // Current status of the rat
    private int ratState;

    public RatStatus(String ratID, int ratState) {
        this.ratID = ratID;
        this.ratState = ratState;
    }

    // Returns the ID of the rat
    public String getRatID() {
        return ratID;
    }

    // Returns the current status of the rat
    public int getRatState() {
        return ratState;
    }

    // Updates the current status of the rat
    public void setRatState(int ratState) {
        this.ratState = ratState;
    }
}