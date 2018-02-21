/*
 * File BankSimulator.java
 */

import java.util.*;
import javax.swing.*;

/**
 * Simulate the check-in process of an airline.
 * 
 * @author Koffman & Wolfgang, edited by J. A. Holey & I. M. Rahal
 * @version October 20, 2010
 */
public class BankSimulation {
  
  /** Queue of customers. */
  private CustomerQueue customerQueue =
    new CustomerQueue("Regular Customer");
  
  /** Maximum time to service a customer. */
  private int avgProcessingTime;
  
  /** Total simulated time. */
  private int totalTime;
  
  /** If set true, print additional output. */
  private boolean showAll = true;
  
  /** Simulated clock. */
  private int clock = 0;
  
  /** Array representing the time it takes to serve a customer. */
  private int timeDone[];
  
  /** Number of tellers in the simulation. */
  private int numTellers;
  
  /** Array of tellers in the simulation. */
  private Teller[] tellers;
  
  /**
   * Get the data for the simulation.
   */
  private void enterData() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter totalTime (an integer):" +
                       "The total time to run the simulation");
    totalTime = sc.nextInt();
    System.out.println("Enter avgProcessingTime (an integer): " +
                       "The average time to serve a customer");
    avgProcessingTime = sc.nextInt();
    Customer.setAvgProcessingTime(avgProcessingTime);
    System.out.println("Enter arrivalRate for customers (a double): " +
                       "The expected number of customer arrivals per unit of time");
    customerQueue.setArrivalRate(sc.nextDouble());
    System.out.println("Enter tellers for bank: (an integer): " +
                       "The number of tellers working at the bank");
    numTellers = (sc.nextInt());
    tellers = new Teller[numTellers];
    timeDone = new int[numTellers];
    for (int i = 0; i < numTellers; i++)
    {
      tellers[i] = new Teller();
      timeDone[i] = -1;
    }
  }
  
  /**
   * Run the simulation.
   */
  private void runSimulation() {
    for (clock = 0; clock < totalTime; clock++) {
      customerQueue.checkNewArrival(clock, showAll);
      for (int i = 0; i < timeDone.length; i++)
      {
        if (clock >= timeDone[i]) { //means that teller is ready to serve (i.e., not busy)
          if (tellers[i].getAvailability() == false)
          {
            tellers[i].setAvailability();
          }
          startServe(i);
        }
      }
    }
  }
  
  /**
   * Serve the queues in the simulation.
   */
  private void startServe(int tellerNum) {
    if (!customerQueue.isEmpty() && tellers[tellerNum].getAvailability() == true) {
      // Serve the next customer.
      timeDone[tellerNum] = customerQueue.update(clock, showAll, tellerNum);
      tellers[tellerNum].setAvailability();
      tellers[tellerNum].incrementNumServed();
    }
    else if (showAll) {
      System.out.println("Time is " + clock + "; server is idle");
      tellers[tellerNum].increaseTimeIdle(1);
    }
  }
  
  /**
   * Show the statistics after the simulation.
   */
  private void showStats() {
    System.out.println("\nThe number of customers served was " +
                       customerQueue.getNumServed());
    double averageWaitingTime =
      (double) customerQueue.getTotalWait() /
      (double) customerQueue.getNumServed();
    System.out.println(" with an average waiting time of " +
                       averageWaitingTime);
    System.out.println("Customers in queue: " +
                       customerQueue.size());
    for (int i = 0; i < tellers.length; i++)
    {
      System.out.println("Idle time for teller " + i + " was " + tellers[i].getTimeIdle() + "\n" +
                         " Served: " + tellers[i].getNumServed() + " customers.");
    }
  }
  
  /**
   * Main method for the simulation program.
   * 
   * @param args the command line arguments (not used)
   */
  public static void main(String args[] ){
    BankSimulation sim = new BankSimulation();
    sim.enterData();
    sim.runSimulation();
    sim.showStats();
  }
  
}
