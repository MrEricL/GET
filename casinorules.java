public interface casinorules{

    //this runs the entire thing
    //it also returns the bet to the driver file
    double play(); 

    //this just sets up everything
    // ie for bingo this intializes all the boards
    void start();


    //this allows the running part of the game
    //ie for blackjack asking for cards
    void go(); 
}
