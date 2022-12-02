package com.prashanth.day2;

import static com.prashanth.day2.RPS.*;

public class Game {
    private RPS opponent;
    private RPS me;

    public void opponentPlayed(RPS rps) {
        this.opponent = rps;
    }

    public void mePlayed(RPS rps) {
        this.me = rps;
    }

    public int getScore(){
        int score = 0;
        if((opponent == ROCK & me == PAPER) | (opponent == PAPER & me == SCISSOR) | (opponent == SCISSOR & me == ROCK))
            score += 6;
        else if((opponent == ROCK & me == ROCK) | (opponent == PAPER & me == PAPER) | (opponent == SCISSOR & me == SCISSOR))
            score += 3;
        return  score + me.getValue();
    }
}
