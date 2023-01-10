package classPackage;
import java.util.ArrayList;
import java.util.Scanner;
import interfaces.RatInterface;
import interfaces.CellInterface;
import interfaces.HoleInterface;
import interfaces.RatStatusInterface;
import interfaces.DesertInterface;

    public class Desert {
        private CellInterface[][] desertMap;
        private ArrayList<RatStatus> rats;
        private int[] CurrentRatPosition;

        // Constructor for Desert class
        public Desert() {
            // Query user for desert size
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the desert:");
            int size = scanner.nextInt();

            // Create desert map with given size
            desertMap = new CellInterface[size][size];

            // Create array list to store rat statuses
            rats = new ArrayList<RatStatus>();
        }

        /**
        new rat and introduces it at the start of the desert.
        * Id of Rat and its status as a tuple object.
        */
        public RatStatusInterface startRat() {
            
            RatInterface rat = ObjectGenerator.createNewRat();

            // Create new RatStatus for this rat and add it to rats list
            RatStatus ratStatus = new RatStatus(rat);
            rats.add(ratStatus);

            // Add rat to the (0, 0) position on the desert map
            desertMap[0][0].receiveRat(rat);

            return ratStatus;
        }
                public RatStatusInterface moveRat(String pRatID) {
                    // Find the rat with the given ID
                    RatStatus ratStatus = null;
                    for (RatStatus rs : rats) {
                        if (rs.getRatID().equals(pRatID)) {
                            ratStatus = rs;
                            break;
                        }
                    }
                
                    // If the rat with the given ID was not found, return null
                    if (ratStatus == null) {
                        return null;
                    }
                
                    // Get the rat from the rat status
                    RatInterface rat = ratStatus.getRatState();
                
                    // Instruct the rat to move
                    rat.move();
                
                    // Get the new position of the rat
                    int newRow = rat.getCurrentRow();
                    int newCol = rat.getCurrentColumn();
                
                    // Check if the rat has reached the exit
                    if (newRow == desertMap.length - 1 && newCol == desertMap.length - 1) {
                        // If the rat has reached the exit, remove it from the desert map and rats list
                        desertMap[newRow][newCol].removeRat();
                        rats.remove(ratStatus);
                
                        // Set the status of the rat to -1 (finished) and return it
                        ratStatus.setStatus(-1);
                        return ratStatus;
                    } else {
                        // If the rat has not reached the exit, move it to its new position on the desert map
                        desertMap[newRow][newCol].receiveRat(rat);
                
                        // Set the status of the rat to 0 (moved to a new cell) and return it
                        ratStatus.setStatus(0);
                        return ratStatus;
                    }
                }
                public void displayStatistics() {
                    // Initialize counters for the number of rats that have started, reached the exit, and are still in the desert
                    int started = 0;
                    int finished = 0;
                    int stillInDesert = 0;
                    
                    // Iterate through the rats list and update the counters based on the rat's status
                    for (RatStatus rs : rats) {
                        int status = rs.getRatState();
                        if (status == -1) {
                            finished++;
                        } else if (status == 0) {
                            stillInDesert++;
                        } else {
                            started++;
                        }
                    }
                    
                    // Print the statistics
                    System.out.println("Rats started: " + started);
                    System.out.println("Rats finished: " + finished);
                    System.out.println("Rats still in desert: " + stillInDesert);
                }
                public void displayRatPath(String pRatID) {
                    // Find the rat with the given ID
                    RatStatus ratStatus = null;
                    for (RatStatus rs : rats) {
                        if (rs.getRatID().equals(pRatID)) {
                            ratStatus = rs;
                            break;
                        }
                    }
                
                    // If the rat with the given ID was not found, return
                    if (ratStatus == null) {
                        return;
                    }
                
                    // Get the rat from the rat status
                    RatInterface rat = ratStatus.getRatState();
                
                    // Print the header
                    System.out.println("Rat ID: " + rat.getId());
                    System.out.println("Path: ");
                
                    // Iterate through the rat's path history and print each cell
                    for (CellInterface cell : rat.getPathHistory()) {
                        System.out.println("(" + cell.getRow() + ", " + cell.getColumn() + ")");
                    }
                }
                
        }
                