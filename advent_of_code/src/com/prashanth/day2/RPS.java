package com.prashanth.day2;

public enum RPS {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    private final int value;

    RPS(int value) {
        this.value = value;
    }

    int getValue(){
        return value;
    }
}
