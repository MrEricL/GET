# GET

Woo.java is the driver file, ignore everything else


Instructions
============

Launch Instructions
-------------------
$ javac Woo.java     
$ java Woo

Blackjack
---------
**Introduction**

Blackjack is a classic casino card game with the goal to to get a total of 21. Suits don't matter in this version 
with all JACK/QUEEN/KING/ACE being worth 10.

**Notes**

The game will stop when you don't want to get hit or when your hand is too large.
If you win your prize money depends on the other winners. If only you win, and no body else wins, you get your bet by six fold more, 
or if everyone wins, you get your bet amount.

**Difficulty Levels**

You are in easy mode: the game will only use one deck. The bots are extremely simple and rely on guessing more.
    
You are in medium mode: the game will use six decks (to prevent card counting). The bots will use basic logic and calculations to make their choice

You are in hard  mode: the game will use six deck. The bots have seeming omniscience and will likely win
      
Slots
-----
Slots employs machines that turn rolls of pictures until it stops. Your goal is to get a set of matching pictures or a set of three completely different pictures to win.

**Notes**
Slots also divides into different slots machines. All machines allow you to win a miniwin (three different pictures in the slots) or a jackpot (all three are the same). However, the different slots machines have additional features (except the normal slots). In fruit Slots, you can double your earnings if your jackpot is with the apples picture. In number Slots, you add 1000 to your earnings if your jackpot lands on the "thousand" picture.

**Difficulty Levels**
Easy mode: There are only three different pictures being cycled.

Medium mode: Six different pictures are available.

Hard mode: Nine different pictures are running. Good luck getting that jackpot!

Dice
-----
Dice is the simplest game in the casino. It employs a simple dice roll of two equal dice, and your objective is to guess what each die will roll.

**Difficulty Levels**        

Easy mode: The dice each have 6 sides.

Medium mode: The dice each have 9 sides.

Hard mode: The dice each have 12 sides. Good luck guessing that one!

Keno
----

The pay table for keno is provided by the British-Columbia Lottery Corporation: http://lotto.bclc.com/keno-and-keno-bonus/prizes-and-odds.html

<img src="https://github.com/MrEricL/GET/blob/master/pics/Screen%20Shot%202017-01-17%20at%2010.48.12%20AM.png">
<img src="https://github.com/MrEricL/GET/blob/master/pics/Screen%20Shot%202017-01-17%20at%2010.48.24%20AM.png"><br>
War
---
Casino war is simple: the player and the house are dealt two cards.

However, if you tie you get three options (the tie rate has been modified to 50% for user engagement).
1. Bet on win -> Three cards are discarded and you double your bet.
2. Bet on tie -> Three cards are discarded and you triple your bet.
3. Surrender -> Only give up half your bet.

Bingo
-----
Bingo is almost completely simulated. You simply will watch the calls and wait to win. 
Your difficulty will generate random amounts of player based on the formula 'difficulty X 6 X Math.random()'
