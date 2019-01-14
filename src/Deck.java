import java.util.Scanner;

public class Deck {

    Scanner input = new Scanner(System.in);
    //suit, randomNum are used to deal and cards is used to return the value
    private int randomNum;
    private int suit;
    private int cards;
    //The 4 suit arrays run for 13 numbers starting with 2 including 4 10s for 10,Jack,Queen,King and 11 for Ace
    //Since suiting is not relevant in blackjack I chose not to include the suit on the card draws
    private int hearts[] = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    private int spades[] = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    private int clubs[] = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    private int diamonds[] = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    private int deck[] = {hearts[12],spades[12],clubs[12],diamonds[12]};

    Hand hand = new Hand();


    /*Deal method will do all the necessary card drawing for new hands and hitting if needed
    Will take a first random number 1-4 assigned depending on suit and then another random number from 1-14
    to assign a card value to each call of the deal method.
    */
    public int deal(){
        randomNum = (int)(Math.random() * (13-1) + 1);
        suit = (int)(Math.random() * (4 - 1) + 1);
        if(suit == 1) {
            cards = hearts[randomNum];
        }else if(suit == 2){
            cards = spades[randomNum];
        }else if(suit == 3){
            cards = clubs[randomNum];
        }else if(suit == 4){
            cards = diamonds[randomNum];
        }else{
            cards = 0;
        }
        return cards;
    }
    //Next improvement is to provide a way to use aces as high or low and switch between the two, for the user and dealer

    }
