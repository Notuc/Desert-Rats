package classPackage;

import java.util.List;
import interfaces.RatStatusInterface;
import interfaces.DesertInterface;
import java.util.ArrayList;

public class ControlDriver {
  private static DesertInterface desert;
  private static List<Integer> ratIds;

  public static void main(String[] args) {
    // Create the desert object
    desert = ObjectGenerator.createNewDesert();

    // Create a list to store the rat IDs
    ratIds = new ArrayList<>();

    // Loop until the desert is empty
    while (!desert.isEmpty()) {
      // For each rat in the desert, move it and update its status
      for (int id : ratIds) {
        RatStatusInterface ratStatus = desert.moveRat(id);
        if (ratStatus.getRatState() == RatStatus.DEAD) {
          // If the rat is dead, remove it from the list of rat IDs
          ratIds.remove((Integer) id);
        }
      }

      // Create a new rat and add its ID to the list of rat IDs
      RatStatusInterface newRatStatus = desert.startRat();
      ratIds.add(newRatStatus.getId());
    }
  }
}
