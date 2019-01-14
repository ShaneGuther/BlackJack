//Import Scanner and exception

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {
    //count variable for while loops involved in hitting/standing.  if
    public static int count = 1;

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        //keepgoing variable for while loops
        boolean keepgoing = true;
        Deck deck = new Deck();
        Hand hand = new Hand();
        hand.setBuyIn(100);

        //All Thread.sleep() lines are there to make the program smoother rather than having large blocks loaded at once

        do {
            /*
             These setters are used to flush the variables after each iteration of the full do while loop.  Only used if
             the user chooses to play again -- will reset all variables(except buyin) to 0 before being assigned new values*/
            count = 1;
            hand.setHit(0);
            hand.setHitTotal(-hand.getHitTotal());
            hand.setDealerHitTotal(-hand.getDealerHitTotal());
            hand.setDealerHit(0);

            hand.setPlayerOne(0);
            hand.setPlayerTwo(0);

            hand.setDealerOne(0);
            hand.setDealerTwo(0);

            hand.setBet(0);

            //Validation for betting -- will not allow user to bet more than they currently have.
            boolean betting = true;
            System.out.println("Current balance is : $" + hand.getBuyIn());
            do {
                System.out.println("How much would you like to bet?");
                try {
                    hand.setBet(input.nextInt());
                    if (hand.getBet() > 0 && hand.getBet() <= hand.getBuyIn()) {
                        betting = false;
                    }
                } catch (InputMismatchException ex) {
                    input.nextLine();
                    System.out.println("Please enter a number.");
                }
            } while (betting);

            System.out.println("You have bet $" + hand.getBet());

            hand.setBuyIn((hand.getBuyIn() - hand.getBet()));

            //Deals the user and the dealer 2 cards each
            hand.setPlayerOne(deck.deal());
            hand.setPlayerTwo(deck.deal());

            hand.setDealerOne(deck.deal());
            hand.setDealerTwo(deck.deal());

            //toString method prints the user's hand and the 1 card the dealer shows
            System.out.println(hand);

            //Flushes input line after betting
            input.nextLine();

            //Adds the user's cards together and prints for easier gameplay
            System.out.println("You are at : " + (hand.getPlayerOne() + hand.getPlayerTwo()));

            //If statement will avoid the hit/stand switch block if the user's cards are over 21 at the beginning--only possible with 2 aces.
            if (hand.getPlayerOne() + hand.getPlayerTwo() > 21) ;
            else {
                //First do-while runs so that the player can continue hitting until they enter "stand"
                do {
                    //Assigns option variable for the first iteration and clears it for each iteration after so it may be used again
                    String option = "";
                    //Nested do-while is for validation purposes.  Will not continue unless the user enters a valid string
                    boolean validation = true;
                    do {
                        /*validation variable is reassigned to true value after each iteration of the loop if necessary, if anything
                        goes wrong it is assigned to false so that the loop continues to run.
                         */
                        validation = true;
                        try {
                            System.out.println("Hit or Stand?");
                            option = input.nextLine();
                            if (option.toLowerCase().equalsIgnoreCase("hit") || option.toLowerCase().equals("stand")) {
                                validation = true;
                            } else {
                                validation = false;
                            }
                        } catch (InputMismatchException x) {
                            System.out.println("Invalid input, please enter a valid option, hit or stand.");
                            validation = false;
                        }
                    } while (validation = false);

                    /*Switch block will allow the player to hit until they enter "stand" in which case count get set to 2 and the loop ends
                      the loop will also end if the user goes over 21.
                      */
                    switch (option) {
                        case "hit":
                            hand.setHit(deck.deal());
                            System.out.println(hand.getHit());
                            hand.setHitTotal(hand.getHit());
                            System.out.println("You are at : " + (hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal()));
                            System.out.println(hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal());
                            break;
                        case "stand":
                            count = 2;
                    }
                    if ((hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal()) > 21) {
                        count = 2;
                    }
                } while (count == 1);
            }
            if (hand.getPlayerTwo() + hand.getPlayerOne() + hand.getHitTotal() <= 21) {
                Thread.sleep(1500);
            }

            //If the user goes over 21 it will skip the dealer's portion completely and jump to the play again block
            if ((hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal()) > 21) {
                System.out.println("Hand is over 21, you lose your bet of $" + hand.getBet() + ".");
                System.out.println("You are at " + hand.getBuyIn());
                Thread.sleep(2000);
            } else {
                System.out.println("Dealer has " + hand.getDealerOne() + " " + hand.getDealerTwo());
                System.out.println("Dealer is at : " + (hand.getDealerOne() + hand.getDealerTwo()));
                //With regular casino rules in mind if the dealer is under 16 they must hit
                while ((hand.getDealerOne() + hand.getDealerTwo() + hand.getDealerHitTotal()) < 16) {
                    System.out.println("Dealer hits!");
                    hand.setDealerHit(deck.deal());
                    System.out.println(hand.getDealerHit());
                    hand.setDealerHitTotal(hand.getDealerHit());

                    System.out.println("Dealer has " + (hand.getDealerOne() + hand.getDealerTwo() + hand.getDealerHitTotal()));
                    Thread.sleep(1000);
                }
                /*Else if block below is to determine the winner of the hand based on hand comparisons, will be skipped if
                the user goes over 21 after dealing
                */
                Thread.sleep(2000);
                if ((hand.getDealerOne() + hand.getDealerTwo() + hand.getDealerHitTotal()) > (hand.getPlayerOne() +
                        hand.getPlayerTwo() + hand.getHitTotal())
                        && (hand.getDealerOne() + hand.getDealerTwo() + hand.getDealerHitTotal()) <= 21) {
                    System.out.println("Dealer wins!  You have lost your bet of $" + hand.getBet());
                    System.out.println("You have $" + hand.getBuyIn());
                } else if ((hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal() > (hand.getDealerOne() +
                        hand.getDealerTwo() + hand.getDealerHitTotal())) || (hand.getDealerOne() +
                        hand.getDealerTwo() + hand.getDealerHitTotal()) > 21 && hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal() < 21) {
                    System.out.println("You win!! You have doubled your bet of $" + hand.getBet());
                    hand.setBuyIn(hand.getBuyIn() + hand.getBet() * 2);
                    System.out.println("You have $" + hand.getBuyIn());
                } else if ((hand.getPlayerOne() + hand.getPlayerTwo() + hand.getHitTotal() == (hand.getDealerOne() +
                        hand.getDealerTwo() + hand.getDealerHitTotal()))) {
                    System.out.print("Hand results in a tie and all bets are returned.");
                    hand.setBuyIn((hand.getBuyIn() + hand.getBet()));
                    System.out.println("Your bet of $" + hand.getBet() + " was returned.  \nYou have $" + hand.getBuyIn());

                }
                Thread.sleep(1500);
                System.out.println("Thank you for playing!  Play again? Y/N");
                String entry = input.nextLine();
                if (entry.toLowerCase().charAt(0) == 'n') {
                    keepgoing = false;
                } else if (hand.getBuyIn() <= 0) {
                    System.out.println("You are out of money, please come back later.");
                    keepgoing = false;
                } else {
                    keepgoing = true;
                }
            }

        } while (keepgoing);

    }
}


