public class Hand {
    //All private variables that dea
    private int dealerOne;
    private int dealerTwo;
    private int playerOne;
    private int playerTwo;
    private int hit;
    private int dealerHit;
    private int hitTotal;
    private int dealerHitTotal;
    private int buyIn;
    private int bet;

    //Getters used to retrieve variable values
    public int getBet(){
        return bet;
    }

    public int getBuyIn(){
        return buyIn;
    }

    public int getHit(){
        return hit;
    }

    public int getDealerHit(){
        return dealerHit;
    }

    public int getDealerHitTotal(){
        return dealerHitTotal;
    }

    public int getDealerOne() {
        return dealerOne;
    }

    public int getDealerTwo() {
        return dealerTwo;
    }

    public int getPlayerOne() {
        return playerOne;
    }

    public int getPlayerTwo() {
        return playerTwo;
    }

    public int getHitTotal(){
        return hitTotal;
    }

    //Setters used to set variable values
    public void setBet(int bet){
        this.bet = bet;
    }

    public void setBuyIn(int buyIn){
        this.buyIn = buyIn;
    }

    public void setHit(int hit){
        this.hit = hit;
    }

    public void setDealerHit(int dealerHit){
        this.dealerHit = dealerHit;
    }

    public void setDealerHitTotal(int dealerHitTotal){
        this.dealerHitTotal += dealerHitTotal;
    }

    public void setDealerOne(int dealerOne){
        this.dealerOne = dealerOne;
    }

    public void setDealerTwo(int dealerTwo) {
        this.dealerTwo = dealerTwo;
    }

    public void setPlayerOne(int playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(int playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void setHitTotal(int hitTotal){
        this.hitTotal += hitTotal;
    }

    //toString used to show user the initial card values that are shown -- their own and 1 of the dealer's
    public String toString(){
        return "Your hand is : " + getPlayerOne() + " " + getPlayerTwo() + " \n" + "Dealer shows : " + getDealerOne();
    }

}
